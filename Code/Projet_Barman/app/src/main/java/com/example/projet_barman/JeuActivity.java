package com.example.projet_barman;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import modele.Manager;

public class JeuActivity extends AppCompatActivity implements OnGameUpdatedListener {

    Manager manager = Manager.getInstance();

    private TextView votreTemps;

    private TextView votreScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_jeu);
        manager.setSensorManager((SensorManager)getSystemService(Context.SENSOR_SERVICE));
        manager.setJeuActivity(this);
        votreTemps = findViewById(R.id.votre_temps);
        votreScore = findViewById(R.id.votre_score);
    }

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
}
