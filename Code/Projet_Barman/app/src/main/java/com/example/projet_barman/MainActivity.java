package com.example.projet_barman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import modele.Joueur;
import modele.Manager;
import modele.Niveau;
import modele.Partie;
import modele.Shaker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("D","[DEBUG] version master-dev");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Partie partieActuelle = new Partie(new Niveau(500,1,new Joueur("TEST"),new Shaker(9999)));
        Manager.getInstance().setPartieActuelle(partieActuelle);
    }
}