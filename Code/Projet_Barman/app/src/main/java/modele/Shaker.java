package modele;

/**
 * Modèle du Shaker qui contient les données utilisées pour le calcul de réussite du niveau
 */
public class Shaker {

    private float secouageAccumule = 0;
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
