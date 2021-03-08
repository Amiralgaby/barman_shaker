package com.example.projet_barman;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class JeuActivity extends AppCompatActivity {

    private SensorController sensorController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorController = new SensorController((SensorManager)getSystemService(Context.SENSOR_SERVICE));
        setContentView(R.layout.page_jeu);
    }

    public void jouer(View view) {
        //On s'enregistre + on prend le temps de l'appuie sur le bouton
        sensorController.register();
        long debut=sensorController.getDebut();
        Log.d("Depart","Je commence a: "+debut);
        //On laisse au joueur 4sec pour se mettre en position. Si il décide de commencer avant, il peut
        while((sensorController.getDebut()<debut + 1000000000) || (!sensorController.getSecouage())){
            long ecart=sensorController.getDebut()-debut;
            Log.d("Ecart","Je suis a: "+ ecart);
            //Log.d("Secouage","Non");
            //Log.d("Register","Suis-je secouage ? " + sensorController.getSecouage());
            //Log.d("Register","Suis-je enregistré ? " + sensorController.getRegistered());
        }

        //On change le temps pour que le temps de départ soit celui du "vrai" début de la partie et on préviens le controller.
        debut=sensorController.getDebut();
        sensorController.setStarted(true);

        //Tant que le capteur ne s'est pas déconnecté, on continue de prendre le temps.
        while(sensorController.getRegistered()){
            Log.d("Enregistré","Oui");
        }

        //Dès que le joueur a arrêté de secouer on prend son temps final.
        long fin = sensorController.getFin();
        long dt=fin-debut;
        Log.d("Temps de secouage: ", String.valueOf(dt));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        //sensorController.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //sensorController.unregister();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //sensorController.unregister();
    }
}
