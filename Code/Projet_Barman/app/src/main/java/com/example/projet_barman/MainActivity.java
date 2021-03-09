package com.example.projet_barman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import modele.Manager;

public class MainActivity extends AppCompatActivity {
    Manager manager=Manager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void demarrer(View view) {
        Intent intent = new Intent(this,JeuActivity.class);
        startActivity(intent);
    }

}