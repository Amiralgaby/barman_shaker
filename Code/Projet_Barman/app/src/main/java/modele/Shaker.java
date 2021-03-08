package modele;

import android.util.Log;

public class Shaker {

    private float secouage_accumule = 0;
    private long tpsshake = 0;
    private int maxpts;

    /**
     * Constructeur du Shaker. 1 shaker par niveau.
     * @param maxpts= maximum de points du shaker si le joueur fait exactement le temps demandé
     */
    public Shaker(int maxpts) {
        this.maxpts=maxpts;
    }

    public int getMaxpts() { return maxpts; }

    /**
     * obtenir le temps durant lequel le shacker fut secoué
     * @return le temp de secouage en nanosecondes
     */
    public long getTpsshake() { return tpsshake; }

    public void ajouteTps(long timestamp) {
        tpsshake += timestamp;
    }

    public void ajouteSecouage(float secouage_accumule) {
        this.secouage_accumule += secouage_accumule;
        Log.d("SECOUE_ACUMMULATION","ajout de "+secouage_accumule+" au secouage");
    }
}
