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

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private final int ASK_PERMISSIONS_REQUEST_CODE = 1001;
    String mUserName;
    String mMediaType;

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
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        mMediaType = preferences.getString(Constants.MEDIA_TYPE,"");
        RadioButton mediaSelected;
        if (mMediaType.equals(Constants.MEDIA_PHOTO)) {
            mediaSelected = (RadioButton) findViewById(R.id.RadioBt_select_input_photo);
        } else if (mMediaType.equals(Constants.MEDIA_VIDEO)) {
            mediaSelected = (RadioButton) findViewById(R.id.RadioBt_select_input_video);
        } else {
            mediaSelected = (RadioButton) findViewById(R.id.RadioBt_select_input_audio);
        }
        mediaSelected.toggle();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        mUserName = preferences.getString(Constants.PSEUDO,"");
        TextView welcomeTextView = findViewById(R.id.welcome_message);
        welcomeTextView.setText(String.format(getString(R.string.welcome_message),mUserName));

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
            Intent settingIntent = new Intent(MainActivity.this, SettingActivity.class);
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

        return super.onOptionsItemSelected(item);
    }


    public void onRadioButtonClicked(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean checked = ((RadioButton) view).isChecked();
        SharedPreferences.Editor editor = preferences.edit();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.RadioBt_select_input_photo:
                if (checked)
                    editor.putString(Constants.MEDIA_TYPE, Constants.MEDIA_PHOTO);
                break;
            case R.id.RadioBt_select_input_video:
                if (checked)
                    editor.putString(Constants.MEDIA_TYPE, Constants.MEDIA_VIDEO);
                break;
            case R.id.RadioBt_select_input_audio:
                if (checked)
                    editor.putString(Constants.MEDIA_TYPE, Constants.MEDIA_AUDIO);
                break;
        }
        editor.commit();
        mMediaType = preferences.getString(Constants.MEDIA_TYPE,"");
    }

    public void startRecording(View view){
        Log.d(TAG, "BFR : Debut d'enregistrement " + mMediaType);
        switch (mMediaType) {
            case Constants.MEDIA_PHOTO:
                Intent settingIntent = new Intent(MainActivity.this, RecordPhoto.class);
                startActivity(settingIntent);
                break;
            case Constants.MEDIA_VIDEO:

                break;
            case Constants.MEDIA_AUDIO:

                break;
        }
    }

}