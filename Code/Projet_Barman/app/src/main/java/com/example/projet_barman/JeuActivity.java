package com.example.projet_barman;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class JeuActivity extends AppCompatActivity {

    private SensorController sensorController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorController = new SensorController((SensorManager)getSystemService(Context.SENSOR_SERVICE));
        setContentView(R.layout.page_jeu);
    }

    public void jouer(View view) {

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        sensorController.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorController.unregister();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorController.unregister();
    }
}
