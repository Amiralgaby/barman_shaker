package com.example.projet_barman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import modele.Manager;
import modele.Partie;

/**
 * Activité principale
 */
public class MainActivity extends AppCompatActivity {
    Manager manager= Manager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void demarrer(View view) {
        Intent intent = new Intent(this,JeuActivity.class);
        startActivity(intent);
    }

    public void Charger(View view) throws ClassNotFoundException {
        try {
            File f= getFilesDir();
            File fichiersauvegarde = new File(f,"Partie.ser");
            FileInputStream sauvegarde = new FileInputStream(fichiersauvegarde);
            ObjectInputStream ois = new ObjectInputStream(sauvegarde);
            Partie p = manager.getPartieActuelle().deserialiser(ois);
            ois.close();
            manager.getPartieController().setPartieActuelle(p);
            Intent intent = new Intent(this, JeuActivity.class);
            startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void SupprimerSauvegarde(View view) {
        File f= getFilesDir();
        File fichiersauvegarde = new File(f,"Partie.ser");
        fichiersauvegarde.delete();
    }
}