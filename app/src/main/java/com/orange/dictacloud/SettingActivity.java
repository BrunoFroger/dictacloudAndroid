package com.orange.dictacloud;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private TextView mServerView;
    private TextView mPseudoView;
    private TextView mEmailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        mServerView = (TextView) findViewById(R.id.content_setting_server_value);
        String serverName = preferences.getString(Constants.ACCESS_SERVER, "");
        if (!serverName.equals("")) {
            mServerView.setText(serverName);
        } else {
            mServerView.setText(Constants.EXTERNAL_SERVER);
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

        super.onCreate(savedInstanceState);
        String accesServer = preferences.getString(Constants.ACCESS_SERVER,"");
        RadioButton activePf;
        if (accesServer.equals(Constants.EXTERNAL_SERVER)) {
            activePf = (RadioButton) findViewById(R.id.RadioBt_server_external);
        } else {
            activePf = (RadioButton) findViewById(R.id.RadioBt_server_internal);
        }
        activePf.toggle();
    }


    public void onRadioButtonClicked(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean checked = ((RadioButton) view).isChecked();
        SharedPreferences.Editor editor = preferences.edit();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.RadioBt_server_external:
                if (checked)
                    editor.putString(Constants.ACCESS_SERVER, Constants.EXTERNAL_SERVER);
                break;
            case R.id.RadioBt_server_internal:
                if (checked)
                    editor.putString(Constants.ACCESS_SERVER, Constants.INTERNAL_SERVER);
                break;
        }
        editor.commit();
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

}
