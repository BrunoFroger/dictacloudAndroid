package com.orange.dictacloud;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by obfe6300 on 05/02/2018.
 */

public class Produit implements Serializable {

    private final String TAG = getClass().getSimpleName();

    @SerializedName("numero")
    @Expose
    private long numero;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("titre")
    @Expose
    private String titre;
    @SerializedName("urlImage")
    @Expose
    private String urlImage;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("taille")
    @Expose
    private double taille;

    Produit(long numero, String type, String titre,
            String url, String description, double taille) {
        this.numero = numero;
        this.type = type;
        this.titre = titre;
        this.urlImage = url;
        this.description = description;
        this.taille=taille;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "numero=" + numero +
                ", type='" + type + '\'' +
                ", titre='" + titre + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", description='" + description + '\'' +
                ", taille='" + taille + '\'' +
                '}';
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getUrlImage() {
        String tmp = urlImage;
        Log.d (TAG, "BFR : produits.getUrlImage = " + tmp);
        return tmp;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTaille(){return taille;}
}
