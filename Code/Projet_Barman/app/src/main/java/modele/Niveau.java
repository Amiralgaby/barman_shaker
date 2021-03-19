package modele;

import android.util.Log;

public class Niveau {
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
        Partie partie=Manager.getInstance().getPartieActuelle();
        victoire = (ptsJoueur>nbMinPts);
        partie.continuerAJouer();
    }

    /**
     * Méthode qui est appelé une fois que le joueur a finit de secouer pour calculer son nombre de points
     * @param tpsjoueur le temps qu'a réalisé le joueur provenant de PartieController
     */
    public void pts(long tpsjoueur) throws ArithmeticException{
        //ptsJoueur = (shaker.getSecouageAccumule()*shaker.getMaxpts())/shaker.getTpsshakeEnSecondes(); // si on garde, j'aimerais savoir pourquoi ce calcul
        System.out.println("Le score max en * 0.8 donne: "+ shaker.getMaxpts()*(Math.pow(0.8,numNiveau)));
        ptsJoueur = tpsjoueur*shaker.getSecouageAccumule() + shaker.getMaxpts()*(Math.pow(0.8,numNiveau));
        ptsJoueur = Math.round(ptsJoueur);
        Log.d("DEBUG_TRACE","les pts de joueur sont "+ptsJoueur);
        setVictoire();
    }

    public double getPtsJoueur() {
        return ptsJoueur;
    }
}
