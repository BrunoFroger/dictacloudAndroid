package com.orange.dictacloud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FilesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        populateListeProduits(create());
    }


    public static List<Produit> create() {
        List<Produit> produits = new ArrayList<>();
        /*
        produits.add(new Produit(1, "Chaussure", "escarpin", 135, "http://"+ Constants.IP_SERVEUR +":8080/serveur/images/escarpins.jpg", "jolie chaussure",1));
        produits.add(new Produit(2, "Chaussure", "basket", 78.7, "http://"+ Constants.IP_SERVEUR +":8080/serveur/images/baskets.jpg", "pour courir",1));
        produits.add(new Produit(11, "Voiture", "Renault", 14526, "http://"+ Constants.IP_SERVEUR +":8080/serveur/images/renault.jpg", "ma voiture",1));
        produits.add(new Produit(12, "Voiture", "Dacia", 11654, "http://"+ Constants.IP_SERVEUR +":8080/serveur/images/dacia.jpg", "mon autre voiture",1));
        produits.add(new Produit(21, "Légume", "Poivron", 1.45, "http://"+ Constants.IP_SERVEUR +":8080/serveur/images/poivrons.jpg", "vert , rouge ou jaune",1));
        produits.add(new Produit(22, "Légume", "Tomate", 1.64, "http://"+ Constants.IP_SERVEUR +":8080/serveur/images/tomates.jpg", "legume",1));
        produits.add(new Produit(31, "Fruit", "Pomme", 0.25, "http://"+ Constants.IP_SERVEUR +":8080/serveur/images/pomme.jpg", "fruit",1));
        produits.add(new Produit(32, "Fruit", "Orange", 2.34, "http://"+ Constants.IP_SERVEUR +":8080/serveur/images/oranges.jpg", "fruit",1));
        produits.add(new Produit(31, "Multimédia", "Lecteur DVD", 143, "http://"+ Constants.IP_SERVEUR +":8080/serveur/images/lecteurDVD.jpg", "pour ecouter vos disques",1));
        produits.add(new Produit(32, "Multimédia", "Télévision", 2415, "http://"+ Constants.IP_SERVEUR +":8080/serveur/images/tv.jpg", "pour regarder vos DVD",1));
        */
        produits.add(new Produit(1, "photo", "dictacloud.bruno.2018-03-25.12-01-56.jpg", "http://srvweb/dictacloud/downloads/dictacloud.bruno.2018-03-25.12-01-56.jpg", "desciption 1"));
        produits.add(new Produit(1, "photo", "dictacloud.bruno.2018-03-25.12-01-56.jpg", "http://srvweb/dictacloud/downloads/dictacloud.bruno.2018-03-25.12-01-56.jpg", "desciption 1"));
        produits.add(new Produit(1, "photo", "dictacloud.bruno.2018-03-25.12-01-56.jpg", "http://srvweb/dictacloud/downloads/dictacloud.bruno.2018-03-25.12-01-56.jpg", "desciption 1"));
        return produits;
    }

    private void populateListeProduits(List<Produit> produits) {
        FileAdapteur fileAdapteur = new FileAdapteur(this, produits);
        getListView().setAdapter(fileAdapteur);
    }


    private ListView getListView() {
        return (ListView) findViewById(R.id.listesFichiers);
    }

}
