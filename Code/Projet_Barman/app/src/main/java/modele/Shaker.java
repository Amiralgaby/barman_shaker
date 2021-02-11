package modele;

import java.util.Random;

public class Shaker {
    private boolean full=false;
    private int tpsshake;
    private int maxpts;

    /**
     * Constructeur du Shaker. 1 shaker par niveau.
     * @param maxpts= maximum de points du shaker si le joueur fait exactement le temps demandé
     */
    public Shaker(int maxpts) {
        this.maxpts=maxpts;
        //Temps de secouage entre 1 et 10 sec.
        Random rand = new Random();
        this.tpsshake=rand.nextInt(9)+1;
    }

    public int getMaxpts() { return maxpts; }

    public int getTpsshake() { return tpsshake; }
}
