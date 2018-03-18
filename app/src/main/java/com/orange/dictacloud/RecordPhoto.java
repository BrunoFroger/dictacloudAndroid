package com.orange.dictacloud;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
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

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(RecordPhoto.this);
            String pseudo = preferences.getString(Constants.PSEUDO, "");

            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd.HH-mm-ss");
            String fileDate = "2018-03-12.20-12-34";
            fileDate = dt.format(new Date()).toString();
            String filename = String.format("dictacloud." + pseudo + "." + fileDate + ".jpg");
            Log.d(TAG, "BFR : enregistrement de la photo au format jpeg : " + filename + " de taille " + bytes.length);

            sendPhoto(bytes, pseudo, filename);

            if (!statusResponse) {
                final Dialog dialog = new Dialog(RecordPhoto.this);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.popup_error_layout);
                String popupMessage = String.format(getString(R.string.popup_error_http_message), mMessage);
                TextView messageTextView = (TextView) dialog.findViewById(R.id.popup_confirm_video_share_message);
                messageTextView.setText(popupMessage);

                // Hide popup after 10 seconds
                final Handler handler = new Handler();
                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                            finish();
                        }
                    }
                };
            }
            onResume();
        }
    };

    private boolean sendPhoto(final byte[] bytesPhoto, final String pseudo, final String filename) {
        // todo envoyer le fichier sur le serveur

        Toast.makeText(RecordPhoto.this, getString(R.string.send_in_progress), Toast.LENGTH_LONG).show();
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
                        Log.d(TAG, "BFR : Response du serveur : <" + response + "> nb champs = " + pieces.length);
                        // en retour on a les donnees suivantes :
                        // <requete>:[OK:KO]:pseudo:email:passwd
                        if (pieces.length >= 4) {
                            mRequete = pieces[0];
                            mResult = pieces[1];
                            mPseudo = pieces[2];
                            mMessage = pieces[3];
                        } else {
                            Log.d(TAG, "BFR : requete KO, manque de parametres en retour");
                            Toast.makeText(RecordPhoto.this, getString(R.string.photo_error_result), Toast.LENGTH_LONG).show();
                            return;
                        }
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
                Map<String,String> param = new HashMap<>();

                String images = getStringImage(bytesPhoto);
                param.put("REQUETE","sendPhoto");
                param.put("PSEUDO",pseudo);
                param.put("FILENAME",filename);
                param.put("IMAGE",images);
                return param;
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


    public String getStringImage(byte[] imageBytes) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int compressionRate = preferences.getInt(Constants.TAUX_COMPRESSION, 0);
        bitmap.compress(Bitmap.CompressFormat.JPEG, compressionRate, baos);
        byte[] CompressedImageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(CompressedImageBytes, Base64.DEFAULT);
        return encodedImage;
    }
}
