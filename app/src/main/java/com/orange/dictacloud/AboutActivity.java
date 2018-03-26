package com.orange.dictacloud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    String aboutHtml = "Dictacloud<br>Version 1.0<br>Copyright B.Froger 2018";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView aboutText = findViewById(R.id.aboutText);
        aboutText.setText(Html.fromHtml(aboutHtml));

    }

}
