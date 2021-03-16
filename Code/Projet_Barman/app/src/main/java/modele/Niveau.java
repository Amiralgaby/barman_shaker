package modele;

public class Niveau {
    private Shaker shaker;

    private int nbMinPts;
    private long ptsJoueur = 0;
    private int numNiveau;
    private boolean victoire;

    /**
     * Constructeur du niveau, une partie peut voir se succéder plusieurs niveaux.
     * @param nbMinPts= Nombre de points minimum resuiq pour passer au niveau suivant
     * @param numNiveau=Numéro du niveau actuel
     * @param shaker=Shaker du niveau actuel
     */
    public Niveau(int nbMinPts, int numNiveau, Shaker shaker) {
        this.nbMinPts = nbMinPts;
        this.numNiveau = numNiveau;
        this.shaker = shaker;
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
        ptsJoueur = (tpsjoueur*shaker.getMaxpts())/shaker.getTpsshake();
        setVictoire();
    }

    public long getPtsJoueur() {
        return ptsJoueur;
    }
}
