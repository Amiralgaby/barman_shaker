package com.example.projet_barman;

import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import modele.Manager;
import modele.Niveau;
import modele.Partie;
import modele.Shaker;

/**
 * Activité du jeu
 */
public class JeuActivity extends AppCompatActivity implements OnGameUpdatedListener {

    Manager manager = Manager.getInstance();
    Partie partie=manager.getPartieActuelle();
    Niveau niveau = partie.getNiveau();
    Shaker shaker = niveau.getShaker();

    private TextView votreTemps;
    private TextView votreScore;
    private TextView scoreABattre;
    private TextView tempsAFaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_jeu);
        manager.setSensorManager((SensorManager)getSystemService(Context.SENSOR_SERVICE));
        manager.setJeuActivity(this);
        votreTemps = findViewById(R.id.votre_temps);
        votreScore = findViewById(R.id.votre_score);
        scoreABattre = findViewById(R.id.Score_a_battre);
        tempsAFaire = findViewById(R.id.Temps_a_faire);
        scoreABattre.setText(String.valueOf(niveau.getNbMinPts()));
        System.out.println("Temps: " + shaker.getTpsshakeEnSecondes() + "s et points: "+ shaker.getMaxpts());
        tempsAFaire.setText(String.valueOf(shaker.getTpsshakeEnSecondes()));
    }

    /**
     * Lance le jeu
     * @param view inutilisée
     */
    public void jouer(View view) {
        manager.lancerLeJeu();
    }

    /**
     * IMPORTANT si le joueur met en pause le jeu il ne faut pas prendre en compte le secouage
     * économie d'énergie et de passage dans l'event
     */
    @Override
    protected void onPause() {
        manager.seMettreEnpause();
        super.onPause();
    }

    /**
     * Utilise un nouveau thread qui permet de set le score dans la textview prévu à cet effet
     * @param score le score à écrire dans la textview
     */
    @Override
    public void updateScore(String score) {
        runOnUiThread(() -> votreScore.setText(score));
    }

    /**
     * Utilise un ouveau thread qui permet de set le temps dans la textview prévu à cet effet
     * @param temps le temps à écrire dans la textview
     */
    @Override
    public void updateTemps(String temps) {
        runOnUiThread(() -> votreTemps.setText(temps));
    }

    /**
     * Demande l'activité victoire et la lance
     */
    @Override
    public void victoire(){
        Intent intent = new Intent(this, VictoireActivity.class);
        intent.putExtra("SCORE",votreScore.getText());
        startActivity(intent);
    }

    /**
     * Demande l'activité défaite et la lance
     */
    @Override
    public void defaite(){
        Intent intent = new Intent(this, DefaiteActivity.class);
        intent.putExtra("SCORE",votreScore.getText());
        startActivity(intent);
    }

    /**
     * sauvegarde la partie
     * @param view inutilisée
     * @throws IOException lance une exception si il y a une erreur d'entrée-sortie
     */
    public void sauvegarder(View view) throws IOException {
        File f = getFilesDir();
        File fichiersauvegarde= new File(f,"Partie.ser");
        if(fichiersauvegarde.exists()){
            fichiersauvegarde.delete();
        }

        FileOutputStream sauvegarde = new FileOutputStream(fichiersauvegarde);
        ObjectOutputStream oos = new ObjectOutputStream(sauvegarde);
        partie.serialiser(oos);
        oos.close();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
