package com.example.projet_barman;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JeuActivity extends AppCompatActivity {

    private SensorController sensorController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorController = new SensorController((SensorManager)getSystemService(Context.SENSOR_SERVICE));
    }
}
