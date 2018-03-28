package com.orange.dictacloud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    String aboutHtml = "<H1>Dictacloud<</h1><br>" +
            "<b>Version 1.0</b><br><br>" +
            "Cette version utilise un serveur de stockage et d'authentification " +
            "sans garantie de disponibilité" +
            "<br><br>" +
            "Le site hébergeant vos fichiers est en cours de developpement " +
            "et n'est pas encore sécurisé, les informations que vous lui communiquez " +
            "peuvent être visibles par des personnes mal intentionnées, pour votre sécurité, " +
            "utilisez des identifiants provisoires que vous n'utilisez sur aucun autre site." +
            "<br><br>" +
            "Si vous trouvez des erreurs ou vous avez des idées d'amélioration, " +
            "n'hésitez pas, envoyez un mail à bruno.froger2@wanadoo.fr, " +
            "j'ajouterais vos remarques dans la liste des évolutions de cette application" +
            "<br><br>" +
            "<b>Copyright B.Froger 2018</b><br>";

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
