package com.example.projet_barman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import modele.FabriqueNiveau;
import modele.Manager;
import modele.Partie;

public class MainActivity extends AppCompatActivity {
    Manager manager=Manager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Partie partieActuelle = new Partie(FabriqueNiveau.fabriquer(1));
        manager.setPartieActuelle(partieActuelle);
    }

    public void demarrer(View view) {
        //setContentView(R.layout.page_jeu);
        Intent intent = new Intent(this,JeuActivity.class);
        startActivity(intent);
    }

    public void jouer(View view) {

    }
}