package com.example.projet_barman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
        if (savedInstanceState == null)
        {
            Bundle bundle = getIntent().getExtras();
            CharSequence sequence = bundle.getCharSequence("SCORE");
            TextView score = findViewById(R.id.textView3);
            score.setText(String.format("Vous avez perdu avec %s points", sequence));
            Log.d("DEBUG_BUNDLE","Voici la récupération du score via le Bundle : "+sequence);
        }
    }

    /**
     * Quit le jeu et fait revenir au menu principal
     * @param view inutilisée
     */
    public void quitter(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    /**
     * Récupére le niveau actuelle et recommence une activité de jeu
     * @param view inutilisée
     */
    public void recommencer(View view) {
        partie.setNiveau(FabriqueNiveau.fabriquer(niveau.getNumNiveau()));
        Intent intent = new Intent(this,JeuActivity.class);
        startActivity(intent);
    }
}
