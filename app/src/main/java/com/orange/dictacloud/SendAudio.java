package com.orange.dictacloud;

/**
 * Created by obfe6300 on 18/03/2018.
 */

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
    private int port = 50005;

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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_audio);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        mPseudo = preferences.getString(Constants.PSEUDO,"");

        startButton = (Button) findViewById(R.id.start_button);
        stopButton = (Button) findViewById(R.id.stop_button);

        startButton.setOnClickListener(startListener);
        stopButton.setOnClickListener(stopListener);

        mRecordMessage = (TextView) findViewById(R.id.Recording);
        mRecordMessage.setVisibility(View.INVISIBLE);

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

            sendRequete("stop");
            finish();
        }
    }

    private final OnClickListener startListener = new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            if (!isRecording){
                sendRequete("start");

                status = true;
                startStreaming();
                mRecordMessage.setVisibility(View.VISIBLE);
                isRecording=true;
            }
        }

    };

    public void startStreaming() {
        Thread streamThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    DatagramSocket socket = new DatagramSocket();
                    Log.d(TAG, "BFR : Socket Created");

                    byte[] buffer = new byte[minBufSize];

                    Log.d(TAG, "BFR : Buffer created of size " + minBufSize);
                    DatagramPacket packet;

                    // TODO change adress of server
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SendAudio.this);
                    String pseudo = preferences.getString(Constants.PSEUDO, "");

                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd.HH-mm-ss");
                    String fileDate = "2018-03-12.20-12-34";
                    fileDate = dt.format(new Date()).toString();
                    mFilename = String.format("dictacloud." + pseudo + "." + fileDate + ".audio");
                    //String url = "livebox-3840.dtdns.net:8001/dictacloud/audioRecord/" + filename;
                    String url = "livebox-3840.dtdns.net";
                    //String url = preferences.getString(Constants.ACCESS_AUDIO_SERVER, "");
                    Log.d(TAG, "BFR : adresse du serveur " + url);
                    //final InetAddress destination = InetAddress.getByName(url);
                    //final InetAddress destination = InetAddress.getByName("192.168.1.5");
                    final InetAddress destination = InetAddress.getByName(url);
                    Log.d(TAG, "BFR : Address retrieved = " + destination);


                    mRecorder = new AudioRecord(MediaRecorder.AudioSource.MIC, sampleRate, channelConfig, audioFormat, minBufSize * 10);
                    Log.d(TAG, "BFR : audio recorder initialized");

                    mRecorder.startRecording();

                    int i = 0;
                    while (status == true) {
                        //reading data from MIC into buffer
                        minBufSize = mRecorder.read(buffer, 0, buffer.length);

                        //putting buffer in the packet
                        packet = new DatagramPacket(buffer, buffer.length, destination, port);
                        // TODO uncomment send
                        //socket.send(packet);
                        //Log.d(TAG,"BFR : recordAudio : packet " + i++ + " traité : " + minBufSize);
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
                            mMessage = pieces[2];
                        } else {
                            Log.d(TAG, "BFR : requete KO, manque de parametres en retour");
                            Toast.makeText(SendAudio.this, getString(R.string.photo_error_result), Toast.LENGTH_LONG).show();
                            return;
                        }
                        ;
                        if (mResult.equals("OK")) {
                            Log.d(TAG, "BFR : requete OK [" + mRequete + "] = " + mResult);
                            Toast.makeText(SendAudio.this, getString(R.string.photo_recorded), Toast.LENGTH_LONG).show();
                            finish();
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

                param.put("REQUETE", "sendPhoto");
                param.put("FILENAME", mFilename);
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
}