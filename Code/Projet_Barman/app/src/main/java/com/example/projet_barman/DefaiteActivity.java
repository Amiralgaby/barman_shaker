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

/**
 * Activité de défaite
 */
public class DefaiteActivity extends Activity {
    Manager manager = Manager.getInstance();
    Partie partie = manager.getPartieActuelle();
    Niveau niveau=partie.getNiveau();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_defaite);
    }

    /**
     * Quit le jeu et fait revenir au menu principal
     * @param view inutilisée
     */
    public void Quitter(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    /**
     * Récupére le niveau actuelle et recommence une activité de jeu
     * @param view inutilisée
     */
    public void Recommencer(View view) {
        partie.setNiveau(FabriqueNiveau.fabriquer(niveau.getNumNiveau()));
        Intent intent = new Intent(this,JeuActivity.class);
        startActivity(intent);
    }
}
