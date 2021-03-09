package modele;

import android.hardware.SensorManager;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.projet_barman.PartieController;

import java.util.ArrayList;

public class Manager {
    private PartieController partieController;
    private ArrayList<Niveau> listeNiveaux = new ArrayList<>();
    private SensorManager sensorManager;

    /**
     * (seule) Instance de manager.
     */
    private static Manager INSTANCE;

    /**
     * @return l'instance du manager
     */
    public static  Manager getInstance() {
        return (INSTANCE != null) ? INSTANCE : new Manager();
    }

    public Partie getPartieActuelle() { return partieController.getPartieActuelle(); }

    public Manager()
    {
        INSTANCE = this;
        partieController = new PartieController();
    }

    public void lancerLeJeu()
    {
        try {
            partieController.run(sensorManager);
        }catch (Exception e)
        {
            Log.d("ERREUR","Le jeu n'a pas fonctionné "+e.getCause());
        }
    }

    /**
     * Méthode qui ajoute un niveau a la liste de niveaux terminés.
     * @param niveau= niveau qui vient d'être terminé
     */
    public void memorize(Niveau niveau) {
        listeNiveaux.add(niveau);
    }

    public void setSensorManager(@NonNull SensorManager systemService) {
        sensorManager = systemService;
    }

    /**
     * Met la partie en pause
     */
    public void seMettreEnpause() {
        partieController.mettreLaPartieEnPause();
    }
}
