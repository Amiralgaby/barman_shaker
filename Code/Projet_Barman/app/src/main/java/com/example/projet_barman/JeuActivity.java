package com.example.projet_barman;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import modele.Manager;

public class JeuActivity extends AppCompatActivity {

    Manager manager = Manager.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_jeu);
        manager.setSensorManager((SensorManager)getSystemService(Context.SENSOR_SERVICE));
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
