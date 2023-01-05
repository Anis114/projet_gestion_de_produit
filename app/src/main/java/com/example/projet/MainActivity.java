package com.example.projet;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView nom;
TextView prix;
Button b;
Helper h=new  Helper(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom=findViewById(R.id.nom);
        prix=findViewById(R.id.prix);
    b=findViewById(R.id.add);
    b.setOnClickListener(new View.OnClickListener(){
        @Override
        public void  onClick(View view){
            Produit p=new  Produit(nom.getText().toString(),Double.parseDouble(prix.getText().toString()));
            h.insertProduit(p);
            Intent i = new Intent (MainActivity.this,ListeProduit.class);
            startActivity(i);
        }
    });
    }
}
