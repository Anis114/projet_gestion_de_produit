package com.example.projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DetailProduit extends AppCompatActivity {
EditText nom,prix;
Button mod,sup;
 String  id;
 Helper  h=new  Helper(DetailProduit.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produit);
        nom=findViewById(R.id.nom);
        prix=findViewById(R.id.prix);
        mod=findViewById(R.id.mod);
        sup=findViewById(R.id.sup);
        id=getIntent().getStringExtra("id");
        Produit p=h.getOneProduit(Integer.parseInt(id));
        nom.setText(p.getNom());
        prix.setText(String.valueOf(p.getPrix()));

    }
}