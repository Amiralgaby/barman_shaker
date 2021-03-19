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

public class VictoireActivity extends Activity {
    Manager manager = Manager.getInstance();
    Partie partie = manager.getPartieActuelle();
    Niveau niveau = partie.getNiveau();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_victoire);
    }

    public void Quitter(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void niveauSuivant(View view) {
        partie.setNiveau(FabriqueNiveau.fabriquer(niveau.getNumNiveau()+1));
        Intent intent = new Intent(this,JeuActivity.class);
        startActivity(intent);
    }
}
