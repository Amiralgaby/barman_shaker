package com.example.projet_barman;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import modele.FabriqueNiveau;
import modele.Manager;
import modele.Partie;

public class JeuActivity extends AppCompatActivity {

    Manager manager = Manager.getInstance();

    private SensorController sensorController;

    private final ShakerController shakerController = new ShakerController();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorController = new SensorController((SensorManager)getSystemService(Context.SENSOR_SERVICE));
        Partie partieActuelle = new Partie(FabriqueNiveau.fabriquer(1));
        manager.setPartieActuelle(partieActuelle);
        setContentView(R.layout.page_jeu);
    }

    public void jouer(View view) {
        // On set le shacker qui sera utilisé par le sensorEventListener pour le "mettre à jour" selon les events
        shakerController.setShaker(Manager.getInstance().getPartieActuelle().getNiveau().getShaker());
        //On s'enregistre + on prend le temps de l'appuie sur le bouton
        sensorController.register(shakerController);
        // TODO -- On laisse au joueur 4sec pour se mettre en position. Si il décide de commencer avant, il peut
    }

    /**
     * IMPORTANT si le joueur met en pause le jeu il ne faut pas prendre en compte le secouage
     * économie d'énergie et de passage dans l'event
     */
    @Override
    protected void onPause() {
        sensorController.unregister(shakerController);
        super.onPause();
    }
}
