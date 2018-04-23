package com.orange.dictacloud;

/**
 * Created by obfe6300 on 18/03/2018.
 */

import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SendAudio extends Activity {
    private final String TAG = getClass().getSimpleName();
    private Button startButton, stopButton;

    public byte[] buffer;
    public static DatagramSocket socket;

    SharedPreferences mPreferences;
    AudioRecord mRecorder;
    private String mRequete = "sendAudio";
    private String mResult;
    private String mPseudo;
    private RequestQueue mQueue;

    private int sampleRate = 16000; // 44100 for music
    private int channelConfig = AudioFormat.CHANNEL_CONFIGURATION_MONO;
    private int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
    int minBufSize = AudioRecord.getMinBufferSize(sampleRate, channelConfig, audioFormat);
    private boolean status = true;
    private TextView mRecordMessage;
    private boolean isRecording = false;
    private String mFilename;
    private String mMessage;
    private String mPort;
    private String mAlertMode;
    private String mServer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_audio);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mPseudo = mPreferences.getString(Constants.PSEUDO,"");
        String mAccess = mPreferences.getString(Constants.ACCESS_TYPE,"");
        if (mAccess.equals(Constants.ACCESS_TYPE_EXTERNAL)){
            mServer=mPreferences.getString(Constants.EXTERNAL_SERVER_BASE,"");
        }

        startButton = (Button) findViewById(R.id.start_button);
        stopButton = (Button) findViewById(R.id.stop_button);

        startButton.setOnClickListener(startListener);
        stopButton.setOnClickListener(stopListener);

        mRecordMessage = (TextView) findViewById(R.id.Recording);
        mRecordMessage.setVisibility(View.INVISIBLE);

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd.HH-mm-ss");
        String fileDate = "2018-03-12.20-12-34";
        fileDate = dt.format(new Date()).toString();
        mFilename = String.format("dictacloud." + mPseudo + "." + fileDate + ".audio");
        Log.d(TAG, "BFR : Filename = " + mFilename);

        // positionne le mode d'alerte pour enreigistrement audio/video
        mAlertMode = mPreferences.getString(Constants.ALERT_TYPE,"");
        RadioButton alertSelected;
        if (mAlertMode.equals(Constants.ALERT_FLASH)){
            alertSelected = (RadioButton) findViewById(R.id.RadioBt_select_alert_flash);
        } else if (mAlertMode.equals(Constants.ALERT_LED)){
            alertSelected = (RadioButton) findViewById(R.id.RadioBt_select_alert_led);
        } else if (mAlertMode.equals(Constants.ALERT_VIBRATION)){
            alertSelected = (RadioButton) findViewById(R.id.RadioBt_select_alert_vibration);
        } else {
            alertSelected = (RadioButton) findViewById(R.id.RadioBt_select_alert_none);
            mAlertMode = Constants.ALERT_NONE;
        }
        alertSelected.toggle();
    }

    private final OnClickListener stopListener = new OnClickListener() {
        @Override
        public void onClick(View arg0) {
            stopRecording();
        }

    };

    private final void stopRecording(){
        if (isRecording){
            status = false;
            if (mRecorder != null){
                mRecorder.release();
            }
            Log.d(TAG, "BFR : Audio recorder released");
            mRecordMessage.setVisibility(View.INVISIBLE);
            isRecording=false;
            activateAlert(false);

            sendRequete("stopAudio");
            finish();
        }
    }

    private final OnClickListener startListener = new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            if (!isRecording){
                sendRequete("startAudio");

                status = true;
                mRecordMessage.setVisibility(View.VISIBLE);
            }
        }

    };

    public void startRecording() {
        isRecording=true;
        activateAlert(true);
        Thread streamThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    DatagramSocket socket = new DatagramSocket();
                    Log.d(TAG, "BFR : Socket Created");

                    byte[] buffer = new byte[minBufSize];

                    Log.d(TAG, "BFR : Buffer created of size " + minBufSize);
                    DatagramPacket packet;


                    String url = mServer;
                    /*
                    // TODO change adress of server
                    //String url = "livebox-3840.dtdns.net:8001/dictacloud/audioRecord/" + filename;
                    String url = "livebox-3840.dtdns.net";
                    //String url = preferences.getString(Constants.ACCESS_AUDIO_SERVER, "");
                    */
                    Log.d(TAG, "BFR : adresse du serveur " + url);
                    //final InetAddress destination = InetAddress.getByName(url);
                    //final InetAddress destination = InetAddress.getByName("192.168.1.5");
                    final InetAddress destination = InetAddress.getByName(url);
                    Log.d(TAG, "BFR : Address retrieved = " + destination);
                    String adresseIp = destination.getHostAddress();
                    //TODO prisoirement on fixe l'adresse IP avec le nom
                    //adresseIp="192.168.1.39";

                    mRecorder = new AudioRecord(MediaRecorder.AudioSource.MIC, sampleRate, channelConfig, audioFormat, minBufSize * 10);
                    Log.d(TAG, "BFR : audio recorder initialized");

                    mRecorder.startRecording();

                    Log.d(TAG,"BFR : recordAudio : @IP " + adresseIp + ";  port : " + mPort);
                    int i = 0;
                    while (status == true) {
                        //reading data from MIC into buffer
                        minBufSize = mRecorder.read(buffer, 0, buffer.length);

                        //putting buffer in the packet
                        packet = new DatagramPacket(buffer, buffer.length, destination, Integer.parseInt(mPort));
                        // TODO uncomment send
                        socket.send(packet);
                        Log.d(TAG,"BFR : recordAudio : packet " + i++ + " traité : " + minBufSize);
                    }

                } catch (UnknownHostException e) {
                    Log.e(TAG, "BFR : UnknownHostException");
                    Toast.makeText(SendAudio.this, "Server Error", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(TAG, "BFR : IOException");
                    Toast.makeText(SendAudio.this, "IO Error", Toast.LENGTH_LONG).show();
                    stopRecording();
                }
            }

        });
        streamThread.start();
    }

    private void sendRequete(final String treatment){
        // todo envoi de la requete au serveur
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String url = preferences.getString(Constants.ACCESS_AUDIO_SERVER, "");
        Log.d(TAG, "BFR : url de la requete : <" + url + ">");
        mQueue = Volley.newRequestQueue(this);  // this = context

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    String returnTreatment;
                    @Override
                    public void onResponse(String response) {
                        // response
                        //Log.d(TAG, "BFR : Response du serveur : <" + response + ">");
                        String[] pieces = response.split(":");
                        Log.d(TAG, "BFR : Response du serveur : <" + response + "> nb champs = " + pieces.length);
                        // en retour on a les donnees suivantes :
                        // <requete>:[OK:KO]:pseudo:email:passwd
                        if (pieces.length >= 5) {
                            mRequete = pieces[0];
                            mResult = pieces[1];
                            mPort = pieces[2];
                            returnTreatment = pieces[3];
                            mMessage = pieces[4];
                        } else {
                            Log.d(TAG, "BFR : requete KO, manque de parametres en retour");
                            Toast.makeText(SendAudio.this, getString(R.string.photo_error_result), Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (mResult.equals("OK")) {
                            Log.d(TAG, "BFR : requete OK [" + mRequete + "] = " + mResult);
                            Log.d(TAG, "BFR : requete OK => fin du traitement " + returnTreatment);
                            if (returnTreatment.equals("stopAudio")) {
                                Toast.makeText(SendAudio.this, getString(R.string.audio_recorded), Toast.LENGTH_LONG).show();
                                finish();
                            }else{
                                Log.d(TAG, "BFR : requete OK [" + mRequete + "] = " + mResult);
                                startRecording();
                            }
                        } else {
                            //TODO affficher une popup avec le message d'erreur
                            Log.d(TAG, "BFR : requete KO [" + mRequete + "] = " + mResult);
                            Toast.makeText(SendAudio.this, mMessage, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // todo afficher popup d'erreur
                        Log.d(TAG, "BFR : Error.Response : <" + error.toString() + ">");
                        Toast.makeText(SendAudio.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();

                param.put("REQUETE", "sendAudio");
                param.put("FILENAME", mFilename);
                param.put("PSEUDO", mPseudo);
                param.put("TREATMENT", treatment);
                Log.d(TAG, "BFR : getParams : " + param.toString());
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

    }

    public void onAlertRadioButtonClicked(View view) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean checked = ((RadioButton) view).isChecked();
        SharedPreferences.Editor editor = preferences.edit();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.RadioBt_select_alert_flash:
                if (checked) {
                    editor.putString(Constants.ALERT_TYPE, Constants.ALERT_FLASH);
                }
                break;
            case R.id.RadioBt_select_alert_led:
                if (checked) {
                    editor.putString(Constants.ALERT_TYPE, Constants.ALERT_LED);
                }
                break;
            case R.id.RadioBt_select_alert_vibration:
                if (checked) {
                    editor.putString(Constants.ALERT_TYPE, Constants.ALERT_VIBRATION);
                }
                break;
            case R.id.RadioBt_select_alert_none:
                if (checked) {
                    editor.putString(Constants.ALERT_TYPE, Constants.ALERT_NONE);
                }
                break;
        }
        editor.commit();
        mAlertMode = preferences.getString(Constants.ALERT_TYPE, "");
    }

    private void activateAlert(boolean value){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String alertType = preferences.getString(Constants.ALERT_TYPE, "");
        Camera mycam;
        Camera.Parameters p;
        if (value){
            switch (alertType){
                case Constants.ALERT_FLASH:
                    Log.d(TAG, "BFR : allumage du flash");
                    mycam = Camera.open();
                    p = mycam.getParameters();
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_ON);
                    mycam.setParameters(p);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Log.d(TAG, "BFR : erreur sur allumage du flash");
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    mycam.release();
                    // activate flash
                    break;
                case Constants.ALERT_LED:
                    // activate led
                    break;
                case Constants.ALERT_VIBRATION:
                    // activate vibration
                    break;
                case Constants.ALERT_NONE:
                    mycam = Camera.open();
                    p = mycam.getParameters();// = mycam.getParameters();
                    // desactivate all alerts
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    mycam.release();
                    break;

            }
        }else{
            // desactivate all alerts
            mycam = Camera.open();
            p = mycam.getParameters();// = mycam.getParameters();
            // desactivate all alerts
            p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            mycam.release();
        }
    }
}