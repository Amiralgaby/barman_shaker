package com.example.projet_barman;

import android.hardware.SensorManager;

import androidx.annotation.NonNull;

import modele.FabriqueNiveau;
import modele.Partie;

public class PartieController {

    private SensorController sensorController;
    private Partie partieActuelle;

    private final ShakerController shakerController = new ShakerController();

    public PartieController()
    {
        partieActuelle = new Partie(FabriqueNiveau.fabriquer(1));
    }

    public void run(@NonNull SensorManager sensorManager)
    {
        sensorController = new SensorController(sensorManager);
        // On set le shaker qui sera utilisé par le sensorEventListener pour le "mettre à jour" selon les events
        shakerController.setShaker(partieActuelle.getNiveau().getShaker());
        //On s'enregistre
        sensorController.register(shakerController);
        // TODO -- On laisse au joueur 4sec pour se mettre en position. Si il décide de commencer avant, il peut
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
}
