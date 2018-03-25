package com.orange.dictacloud;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private final int ASK_PERMISSIONS_REQUEST_CODE = 1001;
    String mUserName;
    String mMediaType;
    private String mTreatmentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Set<String> permissions = PermissionUtil.getNotGrantedPermissions(this);
        if (permissions.size() > 0) {
            PermissionUtil.askPermissions(this, permissions, ASK_PERMISSIONS_REQUEST_CODE);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initPreferences();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUserName = preferences.getString(Constants.PSEUDO, "");
        if (mUserName == ""){
            findViewById(R.id.welcome_message_suite).setVisibility(View.VISIBLE);
        }else{
            findViewById(R.id.welcome_message_suite).setVisibility(View.INVISIBLE);
        }
        TextView welcomeTextView = findViewById(R.id.welcome_message);
        welcomeTextView.setText(String.format(getString(R.string.welcome_message), mUserName));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingIntent = new Intent(MainActivity.this, SettingDictacloudActivity.class);
            startActivity(settingIntent);
            return true;
        }

        if (id == R.id.action_about) {
            Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(aboutIntent);
            return true;
        }

        if (id == R.id.action_login) {
            Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(loginIntent);
            return true;
        }

        if (id == R.id.action_files) {
            Intent loginIntent = new Intent(MainActivity.this, FilesActivity.class);
            startActivity(loginIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onRadioButton2Clicked(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean checked = ((RadioButton) view).isChecked();
        SharedPreferences.Editor editor = preferences.edit();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.RadioBt_select_traitement_mail:
                if (checked) {
                    editor.putString(Constants.TREATMENT_TYPE, Constants.TREATMENT_MAIL);
                }
                break;
            case R.id.RadioBt_select_traitement_stockage:
                if (checked) {
                    editor.putString(Constants.TREATMENT_TYPE, Constants.TREATMENT_STORE);
                }
                break;
            case R.id.RadioBt_select_traitement_cloud:
                if (checked) {
                    editor.putString(Constants.TREATMENT_TYPE, Constants.TREATMENT_CLOUD);
                }
                break;
        }
        editor.commit();
        mTreatmentType = preferences.getString(Constants.TREATMENT_TYPE, "");
    }

    public void onRadioButtonClicked(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean checked = ((RadioButton) view).isChecked();
        SharedPreferences.Editor editor = preferences.edit();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.RadioBt_select_input_photo:
                if (checked) {
                    editor.putString(Constants.MEDIA_TYPE, Constants.MEDIA_PHOTO);
                    if (preferences.getString(Constants.ACCESS_TYPE, "").equals(Constants.ACCESS_TYPE_EXTERNAL)) {
                        editor.putString(Constants.ACCESS_PHOTO_SERVER, Constants.EXTERNAL_PHOTO_SERVER);
                    } else {
                        editor.putString(Constants.ACCESS_PHOTO_SERVER, Constants.INTERNAL_PHOTO_SERVER);
                    }
                }
                break;
            case R.id.RadioBt_select_input_video:
                if (checked) {
                    editor.putString(Constants.MEDIA_TYPE, Constants.MEDIA_VIDEO);
                    if (preferences.getString(Constants.ACCESS_TYPE, "").equals(Constants.ACCESS_TYPE_EXTERNAL)) {
                        editor.putString(Constants.ACCESS_VIDEO_SERVER, Constants.EXTERNAL_VIDEO_SERVER);
                    } else {
                        editor.putString(Constants.ACCESS_VIDEO_SERVER, Constants.INTERNAL_VIDEO_SERVER);
                    }
                }
                break;
            case R.id.RadioBt_select_input_audio:
                if (checked) {
                    editor.putString(Constants.MEDIA_TYPE, Constants.MEDIA_AUDIO);
                    if (preferences.getString(Constants.ACCESS_TYPE, "").equals(Constants.ACCESS_TYPE_EXTERNAL)) {
                        editor.putString(Constants.ACCESS_AUDIO_SERVER, Constants.EXTERNAL_AUDIO_SERVER);
                    } else {
                        editor.putString(Constants.ACCESS_AUDIO_SERVER, Constants.INTERNAL_AUDIO_SERVER);
                    }
                }
                break;
        }
        editor.commit();
        mMediaType = preferences.getString(Constants.MEDIA_TYPE, "");
    }

    public void startRecording(View view) {

        // check if user is registered
        if (mUserName == null || mUserName == "") {
            Toast.makeText(this, getString(R.string.register_message), Toast.LENGTH_LONG).show();
        } else {
            Log.d(TAG, "BFR : Debut d'enregistrement => media type=" + mMediaType + "; traitement=" + mTreatmentType);
            // TODO test provisoire des mode de traitement disponibles
            switch(mTreatmentType){
                case Constants.TREATMENT_MAIL:
                    break;
                case Constants.TREATMENT_STORE:
                    break;
                case Constants.TREATMENT_CLOUD:
                    Toast.makeText(this, getString(R.string.not_implemented_treatment), Toast.LENGTH_LONG).show();
                    return;
            }
            /*
            if (!mTreatmentType.equals(Constants.TREATMENT_MAIL)) {
                Toast.makeText(this, getString(R.string.not_implemented_treatment), Toast.LENGTH_LONG).show();
                return;
            }*/
            switch (mMediaType) {
                case Constants.MEDIA_PHOTO:
                    Intent photoIntent = new Intent(MainActivity.this, RecordPhoto.class);
                    photoIntent.putExtra(Constants.TREATMENT_TYPE, mTreatmentType);
                    startActivity(photoIntent);
                    break;
                case Constants.MEDIA_VIDEO:
                    Toast.makeText(this, getString(R.string.not_implemented_media), Toast.LENGTH_LONG).show();
                    break;
                case Constants.MEDIA_AUDIO:
                    Toast.makeText(this, getString(R.string.not_implemented_media), Toast.LENGTH_LONG).show();
                    //Intent sendAudioIntent = new Intent(MainActivity.this, SendAudio.class);
                    //startActivity(sendAudioIntent);
                    break;
            }
        }
    }

    void initPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        if (preferences.getString(Constants.INITIALIZED, "").equals("")) {
            // le préférences ne sont pas initialisées, on les initialise aux valeurs par defaut
            editor.putString(Constants.ACCESS_TYPE, Constants.ACCESS_TYPE_EXTERNAL);
            editor.putString(Constants.ACCESS_PHOTO_SERVER, Constants.EXTERNAL_PHOTO_SERVER);
            editor.putString(Constants.ACCESS_AUDIO_SERVER, Constants.EXTERNAL_AUDIO_SERVER);
            editor.putString(Constants.ACCESS_VIDEO_SERVER, Constants.EXTERNAL_VIDEO_SERVER);
            editor.putInt(Constants.TAUX_COMPRESSION, Constants.TAUX_COMPRESSION_DEFAULT);
            mMediaType = Constants.MEDIA_PHOTO;
            mTreatmentType = Constants.TREATMENT_MAIL;
            editor.putString(Constants.INITIALIZED, "Initialized");
            editor.commit();
        }

        // positionne le media type recupere dans les preferences
        mMediaType = preferences.getString(Constants.MEDIA_TYPE, "");
        RadioButton mediaSelected;
        if (mMediaType.equals(Constants.MEDIA_AUDIO)) {
            mediaSelected = (RadioButton) findViewById(R.id.RadioBt_select_input_audio);
        } else if (mMediaType.equals(Constants.MEDIA_VIDEO)) {
            mediaSelected = (RadioButton) findViewById(R.id.RadioBt_select_input_video);
        } else {
            mediaSelected = (RadioButton) findViewById(R.id.RadioBt_select_input_photo);
            mMediaType = Constants.MEDIA_PHOTO;
        }
        mediaSelected.toggle();

        // positionne le type de traitement recupere dans les preferences
        mTreatmentType = preferences.getString(Constants.TREATMENT_TYPE, "");
        RadioButton treatmentSelected;
        if (mTreatmentType.equals(Constants.TREATMENT_CLOUD)) {
            treatmentSelected = (RadioButton) findViewById(R.id.RadioBt_select_traitement_cloud);
        } else if (mTreatmentType.equals(Constants.TREATMENT_STORE)) {
            treatmentSelected = (RadioButton) findViewById(R.id.RadioBt_select_traitement_stockage);
        } else {
            treatmentSelected = (RadioButton) findViewById(R.id.RadioBt_select_traitement_mail);
            mTreatmentType = Constants.TREATMENT_MAIL;
        }
        treatmentSelected.toggle();

        int compressRate = preferences.getInt(Constants.TAUX_COMPRESSION, 0);
        if (compressRate == 0) {
            compressRate = Constants.TAUX_COMPRESSION_DEFAULT;
            editor.putInt(Constants.TAUX_COMPRESSION, compressRate);
        }
    }

}
