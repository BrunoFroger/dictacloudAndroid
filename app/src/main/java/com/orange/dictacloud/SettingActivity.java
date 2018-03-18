package com.orange.dictacloud;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private TextView mServerView;
    private TextView mPseudoView;
    private TextView mEmailView;
    private EditText mCompressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        mServerView = (TextView) findViewById(R.id.content_setting_server_value);
        String serverName = preferences.getString(Constants.ACCESS_PHOTO_SERVER, "");
        if (!serverName.equals("")) {
            mServerView.setText(serverName);
        } else {
            mServerView.setText(Constants.EXTERNAL_PHOTO_SERVER);
        }

        mPseudoView = (TextView) findViewById(R.id.content_setting_pseudo_value);
        String pseudo = preferences.getString(Constants.PSEUDO, "");
        if (!pseudo.equals("")) {
            mPseudoView.setText(pseudo);
        } else {
            mPseudoView.setText(Constants.PSEUDO);
        }

        mEmailView = (TextView) findViewById(R.id.content_setting_email_value);
        String email = preferences.getString(Constants.EMAIL, "");
        if (!email.equals("")) {
            mEmailView.setText(email);
        } else {
            mEmailView.setText(Constants.EMAIL);
        }

        mCompressView = (EditText) findViewById(R.id.content_setting_compress_value);
        int compressionRate = preferences.getInt(Constants.TAUX_COMPRESSION, 0);
        if (compressionRate != 0) {
            mCompressView.setText("" + compressionRate);
        } else {
            mCompressView.setText("" + Constants.TAUX_COMPRESSION_DEFAULT);
        }

        String accesServer = preferences.getString(Constants.ACCESS_PHOTO_SERVER, "");
        RadioButton activePf;
        if (accesServer.equals(Constants.INTERNAL_PHOTO_SERVER)) {
            activePf = (RadioButton) findViewById(R.id.RadioBt_server_internal);
        } else {
            activePf = (RadioButton) findViewById(R.id.RadioBt_server_external);
        }
        activePf.toggle();
        super.onCreate(savedInstanceState);
    }


    public void onRadioButtonClicked(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean checked = ((RadioButton) view).isChecked();
        SharedPreferences.Editor editor = preferences.edit();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.RadioBt_server_external:
                if (checked) {
                    editor.putString(Constants.ACCESS_PHOTO_SERVER, Constants.EXTERNAL_PHOTO_SERVER);
                    editor.putString(Constants.ACCESS_AUDIO_SERVER, Constants.EXTERNAL_AUDIO_SERVER);
                    editor.putString(Constants.ACCESS_VIDEO_SERVER, Constants.EXTERNAL_VIDEO_SERVER);
                }
                break;
            case R.id.RadioBt_server_internal:
                if (checked){
                    editor.putString(Constants.ACCESS_PHOTO_SERVER, Constants.INTERNAL_PHOTO_SERVER);
                    editor.putString(Constants.ACCESS_AUDIO_SERVER, Constants.INTERNAL_AUDIO_SERVER);
                    editor.putString(Constants.ACCESS_VIDEO_SERVER, Constants.INTERNAL_VIDEO_SERVER);
                }
                break;
        }
        editor.commit();
        finish();
    }

    public void mBtValidationListener(View v) {
        finish();
    }

    public void mBtClearPreferencesClickListener(View v) {
        clearPreferences(SettingActivity.this);
    }

    public void clearPreferences(Context ctx) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(ctx, getString(R.string.preferences_cleared), Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    protected void onDestroy() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        int savedCompressRate = preferences.getInt(Constants.TAUX_COMPRESSION, 0);
        int newCompressRate = Integer.parseInt(mCompressView.getText().toString());
        if (newCompressRate != savedCompressRate) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(Constants.TAUX_COMPRESSION, newCompressRate);
            editor.commit();
        }
        Log.d(TAG, "BFR : update compression rate " + newCompressRate);
        super.onDestroy();
    }
}
