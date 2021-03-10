package com.example.projet_barman;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.concurrent.ExecutionException;

import modele.FabriqueNiveau;
import modele.Partie;

public class PartieController implements SensorEventListener {

    private SensorController sensorController;
    private Partie partieActuelle;
    private Long debut = null;

    private final ShakerController shakerController = new ShakerController();
    private boolean running = false;
    private long fin;

    public PartieController()
    {
        partieActuelle = new Partie(FabriqueNiveau.fabriquer(1));
    }

    public void run(@NonNull SensorManager sensorManager)
    {
        debut = null; // si on veut retenter alors le debut doit être forcément null comme à son initialisation
        sensorController = new SensorController(sensorManager);
        // On set le shaker qui sera utilisé par le sensorEventListener pour le "mettre à jour" selon les events
        shakerController.setShaker(partieActuelle.getNiveau().getShaker());
        //On s'enregistre
        sensorController.register(shakerController);
        sensorController.register(this);
        // TODO -- On laisse au joueur 4sec pour se mettre en position. Si il décide de commencer avant, il peut

        // TODO -- on fait un thread qui attend avant désenregistrer la partie car si fait dans le main apparament ça bloque l'event
    }

    /**
     * Désenregistrer le shaker controller du sensorController
     */
    public void mettreLaPartieEnPause() {
        sensorController.unregister(shakerController);
    }

    public Partie getPartieActuelle() {
        return partieActuelle;
    }

    /**
     * Permet de prendre le temps de la partie selon le temps maximal de secouage
     * @param event l'envent à partir duquel on obtient le temps
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (debut == null && running) debut = event.timestamp; // défini le timestamp de début de jeu
        float value_y = Math.abs(event.values[1]); // facilite la suite
        if (value_y >= 1) running = true; // le jeu commence uniquement si le joueur secoue
        if (value_y < 1 && running) // condition de fin
        {
            fin = event.timestamp;
            finDePartie(); // on désenregistre les listeners
        }
    }

    private void finDePartie() {
        running = false; // quand appelé oblige la partie controller à ne pas tourner
        sensorController.unregister(shakerController);
        sensorController.unregister(this);

        long ecart_nanosecondes = fin - debut;
        Log.d("SCORE","Vous avez commencé à "+ debut + " et vous avez terminé à "+ fin);
        Log.d("SCORE", "Vous avez secoué durant : " + ecart_nanosecondes + " nanosecondes soit "+ecart_nanosecondes/(1000000000.0));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // do nothing
    }
}
