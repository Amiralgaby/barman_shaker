package modele;

public class Niveau {
    private Shaker shaker;

    private int nbMinPts;
    private int ptsJoueur;
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

    public void setVictoire(boolean victoire) {
        this.victoire=victoire;
        if (!victoire){
            Manager.getInstance().getPartieActuelle().defaite();
        }
    }

    public void setPtsJoueur(int ptsJoueur) { this.ptsJoueur = ptsJoueur; }

    /**
     * Méthode qui est appelé après le calcul des points. Déclare la victoire ou non du joueur.
     */
    public void victoire(){
        Partie partie=Manager.getInstance().getPartieActuelle();
        setVictoire(ptsJoueur>nbMinPts);
        if(victoire)
            partie.changerNiveau();
        else
            partie.defaite();
    }

    /**
     * Méthode qui est appelé une fois que le joueur a finit de secouer pour calculer son nombre de points
     * @param tpsjoueur
     * @param nbMaxPoints
     * @param tpsshake
     */
    public void pts(int tpsjoueur, int nbMaxPoints, long tpsshake){
        int pts=(tpsjoueur*nbMaxPoints)/(int)tpsshake;
        setPtsJoueur(pts);
        victoire();
    }


}
