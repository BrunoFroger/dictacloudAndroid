package com.orange.dictacloud;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordPhoto extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private Camera mCamera = null;
    private CameraView mCameraView = null;

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
            String fileDate="2018-03-12.20-12-34";
            fileDate = dt.format(new Date()).toString();
            String filename= String.format("dictacloud."+fileDate+".jpg");
            Log.d(TAG, "BFR : enregistrement de la photo au format jpeg : " + filename);

            sendPhoto(bytes);
            onResume();
        }
    };

    private void sendPhoto(byte[] bytes) {
        // todo envoyer le fichier sur le serveur
        Toast.makeText(RecordPhoto.this, getString(R.string.photo_recorded), Toast.LENGTH_LONG).show();
    }

}
