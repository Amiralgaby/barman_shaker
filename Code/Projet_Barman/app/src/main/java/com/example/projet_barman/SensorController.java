package com.example.projet_barman;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.util.Log;

/**
 * Permet de controller le manager de sensor, et d'obtenir les events du sensor
 */
public class SensorController {
    private final SensorManager mSensorManager;
    private final Sensor mAccelerometer;
    private boolean registered=false;
    private long debut_register;
    private long temp_passe_a_register = 0;

    /**
     * Créer une instance de SensorController qui gère les listeners du sensor
     * @param manager le manager de l'accélèromètre
     */
    public SensorController(SensorManager manager)
    {
        mSensorManager = manager;
        int accelerometer = Sensor.TYPE_LINEAR_ACCELERATION; // meilleur que Sensor.TYPE_ACCELEROMETER car ne prend pas en compte la gravité
        if ((mAccelerometer = mSensorManager.getDefaultSensor(accelerometer)) != null){
            Log.d("DEBUG","Il y a bien un accéléromètre sur votre téléphone");
        } else {
            Log.d("ERROR","Il n'y a pas d'accéléromètre sur votre téléphone !");
        }
    }

    /**
     * Ajoute this en tant que listener de l'accélèromètre via le manager de sensor
     */
    public boolean register(SensorEventListener sensorEventListener) {
        debut_register = SystemClock.elapsedRealtime();
        return registered = mSensorManager.registerListener(sensorEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**
     * Retire le listener this du manager de sensor
     */
    public void unregister(SensorEventListener sensorEventListener) {
           mSensorManager.unregisterListener(sensorEventListener);
           registered = false;
           temp_passe_a_register = debut_register - SystemClock.elapsedRealtime();
    }

    public boolean getRegistered() { return registered; }

    public long getDebut_register() {
        return debut_register;
    }

    public long getTemp_passe_a_register() {
        return temp_passe_a_register;
    }
}
