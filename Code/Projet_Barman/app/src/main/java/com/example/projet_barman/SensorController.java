package com.example.projet_barman;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

/**
 * Permet de controller le manager de sensor, et d'obtenir les events du sensor
 */
public class SensorController implements SensorEventListener {
    private final SensorManager mSensorManager;
    private final Sensor mAccelerometer;

    /**
     * Créer une instance de SensorController qui gère les envents et les contrôles de l'accéléromètre et du manager de sensor
     * @param manager le manager de l'accélèromètre
     */
    public SensorController(SensorManager manager)
    {
        mSensorManager = manager;
        int accelerometer = Sensor.TYPE_LINEAR_ACCELERATION; // meilleur que Sensor.TYPE_ACCELEROMETER car ne prend pas en compte la gravité
        if ((mAccelerometer = mSensorManager.getDefaultSensor(accelerometer)) != null){
            Log.d("DEBUG","Il y a bien un accéléromètre sur votre téléphone");
            register();
        } else {
            Log.d("ERROR","Il n'y a pas d'accéléromètre sur votre téléphone !");
            unregister();
        }
    }

    /**
     * Ajoute this en tant que listener de l'accélèromètre via le manager de sensor
     */
    public void register() {
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**
     * Retire le listener this du manager de sensor
     */
    public void unregister() {
        mSensorManager.unregisterListener(this);
    }

    /**
     * Appelée lorsque qu'il y a un nouvel envent
     * @param event le sensor event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        // pour obtenir la valeur faire event.values[1]
        Log.d("DONNEES", "la valeur y : " + event.values[1]);
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

}
