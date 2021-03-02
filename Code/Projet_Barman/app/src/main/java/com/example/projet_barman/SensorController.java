package com.example.projet_barman;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class SensorController implements SensorEventListener {
    private final SensorManager mSensorManager;
    private final Sensor mAccelerometer;

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

    public void register() {
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregister() {
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // pour obtenir la valeur faire event.values[1]
        Log.d("CALCUL", "la valeur y : " + event.values[1]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // appelé lorsque l'accuracy est changée
        // ne fait actuellement rien
    }

}
