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
        int accelerometer = Sensor.TYPE_ACCELEROMETER;
        if ((mAccelerometer = mSensorManager.getDefaultSensor(accelerometer)) != null){
            Log.d("DEBUG","Il y a bien un accéléromètre sur votre téléphone");
            register();
        } else {
            Log.d("ERROR","Il n'y a pas d'accéléromètre sur votre téléphone !");
            unregister();
        }
        Log.d("ON_SENSOR_CHANGED","please do something");
    }

    public void register() {
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregister() {
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        System.out.println("onSensorChanged : " + event.values[1] + event.sensor.getName());
        Log.d("ON_SENSOR_CHANGED","please do something");
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d("ON_SENSOR_CHANGED","do something");
    }
}
