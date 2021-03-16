package modele;

import android.hardware.SensorManager;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.projet_barman.OnGameUpdatedListener;
import com.example.projet_barman.PartieController;

import java.util.ArrayList;

public class Manager {
    private PartieController partieController = new PartieController();;
    private ArrayList<Niveau> listeNiveaux = new ArrayList<>();
    private SensorManager sensorManager;

    /**
     * (seule) Instance de manager.
     */
    private static Manager INSTANCE = new Manager();

    /**
     * @return l'instance du manager
     */
    public static  Manager getInstance() {
        return INSTANCE;
    }

    public Partie getPartieActuelle() { return partieController.getPartieActuelle(); }

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

    /**
     * Set le OnGameUpdateListener qui sera utilisé pour réalisé l'affichage
     * @param listener le listener à utilisé
     */
    public void setJeuActivity(OnGameUpdatedListener listener) {
        partieController.setListener(listener);
    }
}
