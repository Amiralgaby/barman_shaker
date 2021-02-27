package modele;

public class Niveau {
    private Joueur joueur;
    private Shaker shaker;
    private Manager lemanager= Manager.getInstance();

    private int nbMinPts;
    private int ptsJoueur;
    private int numNiveau;
    private boolean victoire;

    /**
     * Constructeur du niveau, une partie peut voir se succéder plusieurs niveaux.
     * @param nbMinPts= Nombre de points minimum resuiq pour passer au niveau suivant
     * @param numNiveau=Numéro du niveau actuel
     * @param joueur=Joueur actuel sur le jeu
     * @param shaker=Shaker du niveau actuel
     */
    public Niveau(int nbMinPts,int numNiveau, Joueur joueur, Shaker shaker) {
        this.nbMinPts=nbMinPts;
        this.numNiveau=numNiveau;
        this.joueur=joueur;
        this.shaker=shaker;
    }

    public Joueur getJoueur() { return joueur; }
    public Shaker getShaker() { return shaker; }
    public boolean isVictoire() { return victoire; }
    public int getNumNiveau() { return numNiveau; }
    public int getNbMinPts() { return nbMinPts; }

    public void setShaker(Shaker shaker) { this.shaker = shaker; }
    public void setVictoire(boolean victoire) {
        this.victoire=victoire;
        if (!victoire){
            lemanager.getPartieActuelle().defaite();
        }
    }

    public void setPtsJoueur(int ptsJoueur) { this.ptsJoueur = ptsJoueur; }

    /**
     * Méthode qui est appelé après le calcul des points. Déclare la victoire ou non du joueur.
     */
    public void Victoire(){
        Partie partie=lemanager.getPartieActuelle();
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
    public void Pts(int tpsjoueur, int nbMaxPoints, int tpsshake){
        int pts=(tpsjoueur*nbMaxPoints)/tpsshake;
        setPtsJoueur(pts);
        Victoire();
    }


}
