package com.orange.dictacloud;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilesActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private String mPseudo;
    private RequestQueue mQueue;
    private String mRequete;
    private String mResult;
    private String mMessage;
    private boolean statusResponse;
    private List<Produit> mProduits;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);
        Intent intent = getIntent();
        mPseudo = intent.getStringExtra(Constants.PSEUDO);
        Log.d(TAG, "BFR : onCreate pour " + mPseudo);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        createListe();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produit produit = (Produit) parent.getItemAtPosition(position);
                Log.d("ouvrirDetail", "ouverture de " + position);
                ouvrirDetail(produit);
            }
        });
    }

    public List<Produit> createListe() {

        Log.d(TAG, "BFR : requete pour creation de la liste pour " + mPseudo);
        String requete = Constants.LISTE;

        //TODO requete http pour recuperer liste de fichier

        mProduits = new ArrayList<>();
        getListeFichiers(mPseudo, requete);

        //String tmpFilename;
        //tmpFilename = "dictacloud.bruno.2018-03-25.17-59-31.jpg";
        //mProduits.add(new Produit(1, "photo", tmpFilename, "http://srvweb/dictacloud/downloads/" + tmpFilename, "desciption 1"));
        //tmpFilename = "dictacloud.bruno.2018-03-25.17-50-12.jpg";
        //mProduits.add(new Produit(2, "photo", tmpFilename, "http://srvweb/dictacloud/downloads/" + tmpFilename, "desciption 1"));

        // fin TODO recuperation liste de fichiers
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Log.d (TAG, "BFR : produits apres requete " + mProduits.toString());
        return mProduits;
    }

    private void populateListeProduits(List<Produit> produits) {
        FileAdapteur fileAdapteur = new FileAdapteur(this, produits);
        getListView().setAdapter(fileAdapteur);
    }

    private ListView getListView() {
        return (ListView) findViewById(R.id.listesFichiers);
    }

    private boolean getListeFichiers(final String pseudo, final String requete) {
        // todo envoyer le fichier sur le serveur

        //Toast.makeText(FilesActivity.this, getString(R.string.send_in_progress), Toast.LENGTH_LONG).show();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String url = preferences.getString(Constants.ACCESS_PHOTO_SERVER, "");
        //url = url + "?REQUETE=sendPhoto&PSEUDO=" + pseudo + "&FILENAME=" + filename;
        mQueue = Volley.newRequestQueue(this);  // this = context

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        //Log.d(TAG, "BFR : Response du serveur : <" + response + ">");
                        String[] pieces = response.split(":");
                        //Log.d(TAG, "BFR : Response du serveur : <" + response + "> nb champs = " + pieces.length);
                        // en retour on a les donnees suivantes :
                        // <requete>:[OK:KO]:pseudo:email:passwd
                        if (pieces.length >= 3) {
                            mRequete = pieces[0];
                            mResult = pieces[1];
                            mPseudo = pieces[2];

                            for (int i = 3; i < pieces.length; i++) {
                                int indice = i - 2;
                                String type = "photo";
                                String filename = pieces[i];
                                String url = mPreferences.getString(Constants.ACCESS_PHOTO_SERVER, "") + filename;
                                String description = "...";
                                mProduits.add(new Produit(indice, type, filename, url, description));
                                //Log.d(TAG, "BFR : fichier => " + filename);
                            }
                            populateListeProduits(mProduits);
                        } else {
                            Log.d(TAG, "BFR : requete KO, manque de parametres en retour");
                            Toast.makeText(FilesActivity.this, getString(R.string.photo_error_result), Toast.LENGTH_LONG).show();
                            return;
                        }
                        ;
                        if (mResult.equals("OK")) {
                            Log.d(TAG, "BFR : requete OK [" + mRequete + "] = " + mResult);
                            statusResponse = true;
                            //Toast.makeText(FilesActivity.this, getString(R.string.photo_recorded), Toast.LENGTH_LONG).show();
                            //finish();
                        } else {
                            //TODO affficher une popup avec le message d'erreur
                            Log.d(TAG, "BFR : requete KO [" + mRequete + "] = " + mResult);
                            Toast.makeText(FilesActivity.this, mMessage, Toast.LENGTH_LONG).show();
                            statusResponse = false;
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // todo afficher popup d'erreur
                        Log.d(TAG, "BFR : Error.Response : <" + error.toString() + ">");
                        Toast.makeText(FilesActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();

                param.put("REQUETE", requete);
                param.put("PSEUDO", pseudo);
                Log.d(TAG, "BFR : getParams : " + param.toString());
                return param;
            }
        };

        mQueue.add(postRequest);

        Log.d(TAG, "BFR : Send request mQueue.add : " + url);


        // TODO: subscribe the new account here.
        return true;
    }

    void ouvrirDetail(Produit produit) {
        Intent intent = new Intent(this, FileDetailActivity.class);
        intent.putExtra("produit", (Serializable) produit);
        Log.d(TAG, "BFR : ouvrir detail => produit = " + produit.toString());
        startActivity(intent);
    }

}
