package com.example.projet_barman;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import modele.Manager;
import modele.Niveau;
import modele.Partie;
import modele.Shaker;

/**
 * Activité du jeu
 */
public class JeuActivity extends AppCompatActivity implements OnGameUpdatedListener {

    Manager manager = Manager.getInstance();
    Partie partie=manager.getPartieActuelle();
    Niveau niveau = partie.getNiveau();
    Shaker shaker = niveau.getShaker();

    private TextView votreTemps;
    private TextView votreScore;
    private TextView Score_a_battre;
    private TextView Temps_a_faire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_jeu);
        manager.setSensorManager((SensorManager)getSystemService(Context.SENSOR_SERVICE));
        manager.setJeuActivity(this);
        votreTemps = findViewById(R.id.votre_temps);
        votreScore = findViewById(R.id.votre_score);
        Score_a_battre = findViewById(R.id.Score_a_battre);
        Temps_a_faire = findViewById(R.id.Temps_a_faire);
        Score_a_battre.setText(String.valueOf(niveau.getNbMinPts()));
        System.out.println("Temps: " + shaker.getTpsshakeEnSecondes() + "s et points: "+ shaker.getMaxpts());
        Temps_a_faire.setText(String.valueOf(shaker.getTpsshakeEnSecondes()));
    }

    /**
     * Lance le jeu
     * @param view inutilisée
     */
    public void jouer(View view) {
        manager.lancerLeJeu();
    }

    /**
     * IMPORTANT si le joueur met en pause le jeu il ne faut pas prendre en compte le secouage
     * économie d'énergie et de passage dans l'event
     */
    @Override
    protected void onPause() {
        manager.seMettreEnpause();
        super.onPause();
    }

    /**
     * Utilise un nouveau thread qui permet de set le score dans la textview prévu à cet effet
     * @param score le score à écrire dans la textview
     */
    @Override
    public void updateScore(String score) {
        runOnUiThread(() -> votreScore.setText(score));
    }

    /**
     * Utilise un ouveau thread qui permet de set le temps dans la textview prévu à cet effet
     * @param temps le temps à écrire dans la textview
     */
    @Override
    public void updateTemps(String temps) {
        runOnUiThread(() -> votreTemps.setText(temps));
    }

    /**
     * Demande l'activité victoire et la lance
     */
    @Override
    public void victoire(){
        Intent intent = new Intent(this, VictoireActivity.class);
        startActivity(intent);
    }

    /**
     * Demande l'activité défaite et la lance
     */
    @Override
    public void defaite(){
        Intent intent = new Intent(this, DefaiteActivity.class);
        startActivity(intent);
    }
}
