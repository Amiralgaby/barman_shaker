package com.example.projet_barman;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.SystemClock;

import androidx.annotation.NonNull;

import modele.Shaker;

/**
 * Doit uniquement prendre en compte le contrôle d'un modèle shaker
 * cette classe écoute les events d'un sensor et réalise les prises en compte des envents dans le modèle de shaker
 */
public class ShakerController implements SensorEventListener {

    private Shaker shacker;

    /**
     * Set le modèle de shaker utilisé qui possède nos valeurs
     * @param shaker le shacker
     */
    public void setShaker(@NonNull Shaker shaker) {
        this.shacker = shaker;
    }

    /**
     * Appelée lorsque qu'il y a un nouvel event
     * @param event le sensor event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        float value_y = Math.abs(event.values[1]);
        if (value_y >= 1){
            shacker.ajouteTps(SystemClock.currentThreadTimeMillis());
            //Log.d("TIMESTAMP","voici le temps "+event.timestamp);
            shacker.ajouteSecouage(value_y); // augmente la valeur accumuler de secouage du shaker
        }
    }

    /**
     * Appelée quand la précision du sensor change
     * @param sensor le sensor sur lequel est affecté le changement de précision
     * @param accuracy la nouvelle valeur de la précision
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // appelé lorsque l'accuracy est changée
        // ne fait actuellement rien
    }

    /**
     * Permet d'obtenir le temps de secouage en nanosecondes
     * @return le temps de secouage en nanosecondes
     */
    public long getTempDeSecouage(){
        return shacker.getTpsshakeEnSecondes();
    }
}
