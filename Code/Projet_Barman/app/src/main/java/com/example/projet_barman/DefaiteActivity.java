package com.example.projet_barman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import modele.FabriqueNiveau;
import modele.Manager;
import modele.Niveau;
import modele.Partie;


public class DefaiteActivity extends Activity {
    Manager manager = Manager.getInstance();
    Partie partie = manager.getPartieActuelle();
    Niveau niveau=partie.getNiveau();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_defaite);
    }

    public void Quitter(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void Recommencer(View view) {
        partie.setNiveau(FabriqueNiveau.fabriquer(niveau.getNumNiveau()));
        Intent intent = new Intent(this,JeuActivity.class);
        startActivity(intent);
    }
}
