package modele;

import java.io.Serializable;

/**
 * Modèle du Shaker qui contient les données utilisées pour le calcul de réussite du niveau
 */
public class Shaker implements Serializable {

    private float secouageAccumule = 0;
    private long tpsshake;
    private int maxpts;

    /**
     * Constructeur du Shaker. 1 shaker par niveau.
     * @param maxpts= maximum de points du shaker si le joueur fait exactement le temps demandé
     */
    public Shaker(int maxpts, int numniveau) {
        System.out.println("Maximum points dans le shaker: "+ maxpts + " Numéro niveau dans le shaker: " + numniveau);
        this.maxpts=maxpts;
        tpsshake= (long) ( (2+numniveau) + Math.random()*(10-5));
    }

    public int getMaxpts() { return maxpts; }

    /**
     * obtenir le temps durant lequel le shacker fut secoué
     * @return le temp de secouage en nanosecondes
     */
    public long getTpsshakeEnSecondes() {
        return tpsshake;
    }

    /**
     * ajoute le timestamp au temps de shake
     * @param timestamp le timestamp à ajouter
     */
    public void ajouteTps(long timestamp) {
        tpsshake += timestamp;
    }

    /**
     * ajoute la valeur passée en paramètre
     * @param secouageAccumule la valeur de secouage à ajouter
     */
    public void ajouteSecouage(float secouageAccumule) {
        this.secouageAccumule += secouageAccumule;
        //Log.d("SECOUE_ACUMMULATION","secouage vaut "+this.secouage_accumule);
    }

    /**
     * obtenir le secouage accumulé du shaker
     * @return la valeur de secouage du shaker
     */
    public float getSecouageAccumule() {
        return secouageAccumule;
    }
}
