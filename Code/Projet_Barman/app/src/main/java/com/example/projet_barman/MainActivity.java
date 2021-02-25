package com.example.projet_barman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import modele.Joueur;
import modele.Manager;

public class MainActivity extends AppCompatActivity {
    Manager manager=Manager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void demarrer(View view) {
        setContentView(R.layout.page_jeu);
    }


    public void jouer(View view) {

    }
}