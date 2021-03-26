package modele;

import android.util.Log;

import java.io.Serializable;

/**
 * La classe niveau gère les points minimum, les points du joueur, le shaker utilisé, la condition de victoire
 */
public class Niveau implements Serializable {
    private Shaker shaker;

    private int nbMinPts;
    private double ptsJoueur = 0;
    private int numNiveau;
    private boolean victoire;

    /**
     * Constructeur du niveau, une partie peut voir se succéder plusieurs niveaux.
     * @param numNiveau=Numéro du niveau actuel
     * @param shaker=Shaker du niveau actuel
     */
    public Niveau(int numNiveau, Shaker shaker) {
        this.numNiveau = numNiveau;
        this.shaker = shaker;
        this.nbMinPts= (int) Math.round(shaker.getMaxpts()*0.85);
        victoire = false;
    }

    public Shaker getShaker() { return shaker; }
    public boolean isVictoire() { return victoire; }
    public int getNumNiveau() { return numNiveau; }
    public int getNbMinPts() { return nbMinPts; }

    /**
     * Méthode qui est appelé après le calcul des points. Déclare la victoire ou non du joueur.
     */
    public void setVictoire(){
        victoire = (ptsJoueur>nbMinPts);
    }

    /**
     * Méthode qui est appelé une fois que le joueur a finit de secouer pour calculer son nombre de points
     * @param tpsjoueur le temps qu'a réalisé le joueur provenant de PartieController
     */
    public void pts(long tpsjoueur) throws ArithmeticException{
        System.out.println("Le score max en * 0.8 donne: "+ shaker.getMaxpts()*(Math.pow(0.8,numNiveau)));
        //int tpscalcul = (int) Math.abs(shaker.getTpsshakeEnSecondes()-tpsjoueur); // le temps absolu de différence entre les deux objets

        // shaker.getMaxpts() : le max de points
        // shaker.getTpsSecouage() : le temps de secouage du shaker
        // shaker.getSecouageAcculule() : les secouage du shaker

        // TODO -- Sérieusement expliquer comment on calcule parce que je crois que l'on arrive pas à ce mettre d'accord : il faut EXPLIQUER
        // EXPLICATION CALCUL SCORE : c'est le temps de jeu du joueur multiplié par la force de secouage
        // EXPLICATION DE MON CHOIX : on prend le minimum entre le score du joueur et le score maximum

        ptsJoueur = Math.min(tpsjoueur*shaker.getSecouageAccumule(),shaker.getMaxpts());
        ptsJoueur = Math.round(ptsJoueur);
        Log.d("DEBUG_TRACE","INFO : "+tpsjoueur+", le secouage accumule vaut : "+shaker.getSecouageAccumule());
        setVictoire();
    }

    public double getPtsJoueur() {
        return ptsJoueur;
    }
}
