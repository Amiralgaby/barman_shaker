package com.example.projet_barman;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import androidx.annotation.NonNull;

public class NotifierTimeSleep implements Runnable{

    private final long milli;
    SensorManager sensorManager;
    SensorEventListener eventListener;

    public NotifierTimeSleep(@NonNull SensorManager sensorManager, @NonNull SensorEventListener sensorEventListener, long sleep_time) {
        this.sensorManager = sensorManager;
        eventListener = sensorEventListener;
        this.milli = sleep_time;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(0);
            sensorManager.unregisterListener(eventListener);
        }catch (InterruptedException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
