package com.orange.dictacloud;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by obfe6300 on 03/03/2018.
 */

public class LoginActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    private EditText mPseudoView;
    private EditText mEmailView;
    private EditText mPasswordView;
    private RequestQueue mQueue;
    public boolean statusResponse = true;
    public String mPassword;
    public String mEmail;
    public String mPseudo;
    public String mResult;
    public String mRequete;
    private EditText mPseudoView1;
    private EditText mPasswordView1;
    private JSONObject mJsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mPseudoView = (EditText) findViewById(R.id.pseudo);
        mPseudoView1 = (EditText) findViewById(R.id.pseudo1);
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView1 = (EditText) findViewById(R.id.password1);

        Button mSignInButton = (Button) findViewById(R.id.sign_in_button);
        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pseudo = mPseudoView.getText().toString();
                String email = mEmailView.getText().toString();
                String passwd = mPasswordView.getText().toString();
                attemptLogin(Constants.SUBSCRIBE, pseudo, email, passwd);
            }
        });

        Button mRegisterButton = (Button) findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pseudo = mPseudoView1.getText().toString();
                String email = mEmailView.getText().toString();
                String passwd = mPasswordView1.getText().toString();
                attemptLogin(Constants.REGISTER, pseudo, email, passwd);
            }
        });
        mQueue = Volley.newRequestQueue(this);  // this = context
    }

    private boolean attemptLogin(final String requete, final String pseudo, final String email, final String passwd) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String url = preferences.getString(Constants.ACCESS_PHOTO_SERVER, "");

        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("REQUETE", requete);
            jsonParams.put("PSEUDO", pseudo);

            if (requete.equals(Constants.SUBSCRIBE)) {
                jsonParams.put("EMAIL", email);
            }
            jsonParams.put("PASSWD", passwd);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST,
                url, jsonParams,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "BFR : Response du serveur : <" + response.toString() + ">");

                        mJsonResponse = response;
                        // extraction des donnees recues du serveur
                        try {
                            mRequete = mJsonResponse.getString("REQUETE");
                            mResult = mJsonResponse.getString("RESULT");
                            mPseudo = mJsonResponse.getString("PSEUDO");
                            if (mJsonResponse.has("EMAIL")) {
                                mEmail = mJsonResponse.getString("EMAIL");
                            }
                            if (mJsonResponse.has("PASSWD")) {
                                mPassword = mJsonResponse.getString("PASSWD");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // sauvegarde des valeurs saisies dans les preferences
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                        SharedPreferences.Editor editor = preferences.edit();
                        Log.d(TAG, "BFR attemptLogin : mPseudo stocké dans les preferences : " + mPseudo);
                        editor.putString(Constants.PSEUDO, mPseudo);
                        editor.commit();
                        Log.d(TAG, "BFR attemptLogin : mEmail stocké dans les preferences : " + mEmail);
                        editor.putString(Constants.EMAIL, mEmail);
                        editor.commit();
                        Toast.makeText(LoginActivity.this, getString(R.string.register_ok), Toast.LENGTH_LONG).show();

                        statusResponse = true;
                        finish();
                    }
                },

                    /*
                    @Override
                    public void onResponse(JSONObject response) {
                        // response
                        /*
                        String[] pieces = response.split(":");
                        Log.d(TAG, "BFR : Response du serveur : <" + response + "> nb champs = " + pieces.length);
                        // en retour on a les donnees suivantes :
                        // <requete>:[OK:KO]:pseudo:email:passwd
                        mRequete = pieces[0];
                        mResult = pieces[1];
                        mPseudo = pieces[2];
                        mEmail = pieces[3];
                        if (pieces.length > 4){
                            mPassword = pieces[4];
                        }

                        if (mResult.equals("OK")) {
                            Log.d(TAG, "BFR : requete OK [" + mRequete + "] = " + mResult);
                            statusResponse = true;

                            finish();
                        } else {
                            //TODO affficher une popup avec le message d'erreur
                            Log.d(TAG, "BFR : requete KO [" + mRequete + "] = " + mResult);
                            Toast.makeText(LoginActivity.this, String.format(getString(R.string.register_ko),mResult), Toast.LENGTH_LONG).show();
                            statusResponse = false;
                        }*/
                //}*/
                //},
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // todo afficher popup d'erreur
                        statusResponse = false;
                        Log.d(TAG, "BFR : Error.Response : <" + error.toString() + ">");
                    }
                }
        ) {

            /*
            @Override
            public byte[] getBody() {
                Map<String, String> jsonParams = new HashMap<>();
                //Log.d(TAG, "BFR : getBody : parametres : " + requete + ":" + pseudo + ":" + email + ":" + passwd);
                jsonParams.put("REQUETE", requete);
                jsonParams.put("PSEUDO", pseudo);
                if (requete.equals(Constants.SUBSCRIBE)) {
                    jsonParams.put("EMAIL", email);
                }
                jsonParams.put("PASSWD", passwd);
                String params = new Gson().toJson(jsonParams);
                Log.d(TAG, "BFR : getBody : json :" + params);
                return params.getBytes();
            }*/

            /*
            @Override
            public String getBodyContentType() {
                return super.getBodyContentType();
            }*/

            /*
            @Override
            public byte[] getPostBody() throws AuthFailureError {
                Map<String, String> jsonParams = new HashMap<>();
                //Log.d(TAG, "BFR : getBody : parametres : " + requete + ":" + pseudo + ":" + email + ":" + passwd);
                jsonParams.put("REQUETE", requete);
                jsonParams.put("PSEUDO", pseudo);
                if (requete.equals(Constants.SUBSCRIBE)) {
                    jsonParams.put("EMAIL", email);
                }
                jsonParams.put("PASSWD", passwd);
                String params = new Gson().toJson(jsonParams);
                Log.d(TAG, "BFR : getBody : json :" + params);
                return params.getBytes();
            }*/

            /*
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> jsonParams = new HashMap<>();
                //Log.d(TAG, "BFR : getParams : parametres : " + requete + ":" + pseudo + ":" + email + ":" + passwd);
                jsonParams.put("REQUETE", requete);
                jsonParams.put("PSEUDO", pseudo);
                if (requete.equals(Constants.SUBSCRIBE)) {
                    jsonParams.put("EMAIL", email);
                }
                jsonParams.put("PASSWD", passwd);
                String params = new Gson().toJson(jsonParams);
                Log.d(TAG, "BFR : getParams : json :" + jsonParams);
                return jsonParams;
            }*/

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap();
                //params.put("Content-type", "text/html");
                params.put("Content-Type", "application/json");
                Log.d(TAG, "BFR : getHeader : " + params.toString());
                return super.getHeaders();
            }
        };

        mQueue.add(postRequest);

        Log.d(TAG, "BFR : Send request mQueue.add : " + url);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // TODO: subscribe the new account here.
        return true;
    }

    @Override
    protected void onDestroy() {




        super.onDestroy();
    }
}

