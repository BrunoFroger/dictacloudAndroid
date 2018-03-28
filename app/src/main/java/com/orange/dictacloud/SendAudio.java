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

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class SendAudio extends Activity {
    private final String TAG = getClass().getSimpleName();
    private Button startButton, stopButton;

    public byte[] buffer;
    public static DatagramSocket socket;
    private int port = 50005;

    AudioRecord recorder;

    private int sampleRate = 16000; // 44100 for music
    private int channelConfig = AudioFormat.CHANNEL_CONFIGURATION_MONO;
    private int audioFormat = AudioFormat.ENCODING_PCM_16BIT;
    int minBufSize = AudioRecord.getMinBufferSize(sampleRate, channelConfig, audioFormat);
    private boolean status = true;
    private TextView mRecordMessage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_audio);

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
            status = false;
            recorder.release();
            Log.d(TAG, "BFR : Recorder released");
            mRecordMessage.setVisibility(View.INVISIBLE);
            finish();
        }

    };

    private final OnClickListener startListener = new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            status = true;
            startStreaming();
            mRecordMessage.setVisibility(View.VISIBLE);
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
                    String url = preferences.getString(Constants.ACCESS_AUDIO_SERVER, "");
                    Log.d(TAG, "BFR : adresse du serveur " + url);
                    //final InetAddress destination = InetAddress.getByName(url);
                    final InetAddress destination = InetAddress.getByName("192.168.1.5");
                    Log.d(TAG, "BFR : Address retrieved");


                    recorder = new AudioRecord(MediaRecorder.AudioSource.MIC, sampleRate, channelConfig, audioFormat, minBufSize * 10);
                    Log.d(TAG, "BFR : Recorder initialized");

                    // TODO uncomment startRecording
                    //recorder.startRecording();

                    while (status == true) {
                        //reading data from MIC into buffer
                        minBufSize = recorder.read(buffer, 0, buffer.length);

                        //putting buffer in the packet
                        packet = new DatagramPacket(buffer, buffer.length, destination, port);
                        socket.send(packet);
                        System.out.println("MinBufferSize: " + minBufSize);
                    }

                } catch (UnknownHostException e) {
                    Log.e(TAG, "BFR : UnknownHostException");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e(TAG, "BFR : IOException");
                }
            }

        });
        streamThread.start();
    }
}