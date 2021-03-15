package com.example.projet_barman;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import modele.Manager;

public class JeuActivity extends AppCompatActivity {

    Manager manager = Manager.getInstance();

    @SuppressLint("StaticFieldLeak")
    public static TextView votreTemps;

    @SuppressLint("StaticFieldLeak")
    public static TextView votreScore;

    public static void setScore(String score) {
        votreScore.setText(score);
    }

    public static void setTemps(String temps) {
        votreTemps.setText(temps);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_jeu);
        manager.setSensorManager((SensorManager)getSystemService(Context.SENSOR_SERVICE));
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
}
