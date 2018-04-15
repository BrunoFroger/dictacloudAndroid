package com.orange.dictacloud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by obfe6300 on 06/02/2018.
 */

public class FileAdapteur extends ArrayAdapter<Produit> {
    public FileAdapteur(Context context, List<Produit> produits) {
        super(context, R.layout.row_file, produits);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Produit produit = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_file, parent, false
            );
        }
        TextView typeTextView = (TextView) convertView.findViewById(R.id.typeTextView);
        typeTextView.setText(produit.getType());
        TextView titreTextView = (TextView) convertView.findViewById(R.id.titreTextView);
        titreTextView.setText(produit.getTitre());
        String tmp = produit.getUrlImage();
        if (tmp != ""){
            ImageView imageView = (ImageView) convertView.findViewById(R.id.produitFileView);
            Picasso.with(getContext()).load(tmp).into(imageView);
        }
        return convertView;
    }
}

