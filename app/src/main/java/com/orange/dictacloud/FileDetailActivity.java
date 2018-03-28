package com.orange.dictacloud;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class FileDetailActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    private String mRequete;
    private String mFilename;
    private RequestQueue mQueue;
    private String mResult;
    private String mPseudo;
    SharedPreferences mPreferences;
    private String mMessage;
    private boolean statusResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        setContentView(R.layout.activity_file_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Produit produit = (Produit) getIntent().getSerializableExtra("produit");

        TextView filenameValueTextView = (TextView) findViewById(R.id.file_detail_filename_value);
        filenameValueTextView.setText(produit.getTitre());


        Button removeButton = findViewById(R.id.file_detail_button_remove);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRequete = Constants.REMOVEFILEONSERVER;
                mFilename = produit.getTitre();
                sendRequete(mFilename,mRequete);
                Toast.makeText(getApplicationContext(), getString(R.string.not_implemented_treatment), Toast.LENGTH_LONG).show();
            }
        });

        Button sendButton = findViewById(R.id.file_detail_button_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRequete = Constants.SENDFILEBYEMAIL;
                mFilename = produit.getTitre();
                sendRequete(mFilename,mRequete);
                Toast.makeText(getApplicationContext(), getString(R.string.not_implemented_treatment), Toast.LENGTH_LONG).show();
            }
        });

        ImageView urlImage = findViewById(R.id.file_detail_image);
        Picasso.with(this).load(produit.getUrlImage()).into(urlImage);
    }

    private boolean sendRequete(final String filename, final String requete) {
        // todo envoyer le fichier sur le serveur

        //Toast.makeText(FilesActivity.this, getString(R.string.send_in_progress), Toast.LENGTH_LONG).show();
        String url = mPreferences.getString(Constants.ACCESS_PHOTO_SERVER, "");
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
                            mMessage = pieces[3];

                        } else {
                            Log.d(TAG, "BFR : requete KO, manque de parametres en retour");
                            Toast.makeText(FileDetailActivity.this, getString(R.string.photo_error_result), Toast.LENGTH_LONG).show();
                            return;
                        }
                        ;
                        if (mResult.equals("OK")) {
                            Log.d(TAG, "BFR : requete OK [" + mRequete + "] = " + mResult);
                            statusResponse = true;
                            Toast.makeText(FileDetailActivity.this, mMessage, Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            //TODO affficher une popup avec le message d'erreur
                            Log.d(TAG, "BFR : requete KO [" + mRequete + "] = " + mResult);
                            Toast.makeText(FileDetailActivity.this, mMessage, Toast.LENGTH_LONG).show();
                            statusResponse = false;
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // todo afficher popup d'erreur
                        Log.d(TAG, "BFR : Error.Response : <" + error.toString() + ">");
                        Toast.makeText(FileDetailActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();

                param.put("REQUETE", requete);
                param.put("FILENAME", filename);
                Log.d(TAG, "BFR : getParams : " + param.toString());
                return param;
            }
        };

        mQueue.add(postRequest);

        Log.d(TAG, "BFR : Send request mQueue.add : " + url);


        // TODO: subscribe the new account here.
        return true;
    }

}
