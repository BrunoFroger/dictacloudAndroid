package com.orange.dictacloud;

import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RecordPhoto extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private Camera mCamera = null;
    private CameraView mCameraView = null;
    private String mRequete;
    private String mResult;
    private String mPseudo;
    private RequestQueue mQueue;
    public boolean statusResponse;
    private String mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_photo);

        //btn to close the application
        ImageButton imgClose = (ImageButton) findViewById(R.id.imgClose);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            mCamera = Camera.open();//you can use open(int) to use different cameras
        } catch (Exception e) {
            Log.d(TAG, "ERROR : Failed to get camera: " + e.getMessage());
        }

        if (mCamera != null) {
            mCameraView = new CameraView(this, mCamera);//create a SurfaceView to show camera data
            FrameLayout camera_view = (FrameLayout) findViewById(R.id.camera_view);
            camera_view.addView(mCameraView);//add the SurfaceView to the layout
        }
    }

    public void recordPhoto(View view) {
        Log.d(TAG, "BFR : click sur record photo");

        mCamera.takePicture(shutterCallback, rawCallback, jpegCallback);
    }

    Camera.ShutterCallback shutterCallback = new Camera.ShutterCallback() {

        @Override
        public void onShutter() {
            // Todo ajouter du code a executer lors du declenchement
        }
    };

    Camera.PictureCallback rawCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] bytes, Camera camera) {
            // TODO sauvegarde au forat raw des images
        }
    };

    Camera.PictureCallback jpegCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] bytes, Camera camera) {
            // sauvegarde de la photo au format jpeg
            // generation du nom de fichier
            // nom de fichier = Dictacloud.YYYY-MM-JJ.hh-mm-ss.jpg
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd.hh-mm-ss");
            String fileDate = "2018-03-12.20-12-34";
            fileDate = dt.format(new Date()).toString();
            String filename = String.format("dictacloud." + fileDate + ".jpg");
            Log.d(TAG, "BFR : enregistrement de la photo au format jpeg : " + filename);

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(RecordPhoto.this);
            String pseudo = preferences.getString(Constants.PSEUDO, "");

            sendPhoto(bytes, pseudo, filename);
            onResume();
        }
    };

    private boolean sendPhoto(final byte[] bytesPhoto, final String pseudo, String filename) {
        // todo envoyer le fichier sur le serveur

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String url = preferences.getString(Constants.ACCESS_SERVER, "");
        mQueue = Volley.newRequestQueue(this);  // this = context

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        //Log.d(TAG, "BFR : Response du serveur : <" + response + ">");
                        String[] pieces = response.split(":");
                        Log.d(TAG, "BFR : Response du serveur : <" + response + "> nb champs = " + pieces.length);
                        // en retour on a les donnees suivantes :
                        // <requete>:[OK:KO]:pseudo:email:passwd
                        mRequete = pieces[0];
                        mResult = pieces[1];
                        mPseudo = pieces[2];
                        mMessage = pieces[3]
;
                        if (mResult.equals("OK")) {
                            Log.d(TAG, "BFR : requete OK [" + mRequete + "] = " + mResult);
                            statusResponse = true;
                            Toast.makeText(RecordPhoto.this, getString(R.string.photo_recorded), Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            //TODO affficher une popup avec le message d'erreur
                            Log.d(TAG, "BFR : requete KO [" + mRequete + "] = " + mResult);
                            Toast.makeText(RecordPhoto.this, mMessage, Toast.LENGTH_LONG).show();
                            statusResponse = false;
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // todo afficher popup d'erreur
                        Log.d(TAG, "BFR : Error.Response : <" + error.toString() + ">");
                        Toast.makeText(RecordPhoto.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Log.d(TAG, "BFR : getParams : " + requete + ":" + pseudo);
                params.put("REQUETE", "sendPhoto");
                params.put("PSEUDO", pseudo);

                Log.d(TAG, "BFR : getParams : " + params.toString());
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap();
                params.put("Content-type", "multipart/form-data");
                params.put("Content-disposition", "text/html");
                params.put("Content-disposition", "image/jpeg");
                Log.d(TAG, "BFR : getHeader : " + params.toString());
                return super.getHeaders();
            }

            @Override
            public String getBodyContentType() {
                return bytesPhoto.toString();
                //return super.getBodyContentType();
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return bytesPhoto;
                //return super.getBody();
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

}
