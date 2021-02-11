package modele;

public class Joueur {
    private boolean enAttente=true;
    private int tpsjoueur;
    private Niveau niveauActuel;
    private String nom;

    private Manager lemanager= Manager.getInstance();

    /**
     * Constructeur du joueur lors de la récupération d'une sauvegarde.
     * @param nom= pseudo du joueur
     * @param niveauActuel= niveau dans lequel se trouve le joueur
     */
    public Joueur(String nom, Niveau niveauActuel){
        this.nom=nom;
        this.niveauActuel=niveauActuel;
    }

    /**
     * Constructeur du joueur au lancement du jeu en le mettant au niveau 1 et avec le shaker de base.
     * @param nom= pseudo du joueur
     */
    public Joueur(String nom) {
        this.nom=nom;
        // Niveau 1 + Shaker de base pour le premier niveau (valeurs a tester plus tard)
        this.niveauActuel=new Niveau(700,1,this,new Shaker(1000));
    }

    public void setTpsjoueur(int tpsjoueur) { this.tpsjoueur = tpsjoueur; }

    /**
     * Méthode qui récupère le temps passer à secouer par le joueur
     * @return Les points du joueur après avoir secoué
     */
    public int secouer(){
        if (!enAttente){
            //On secoue et on récupère le temps en secondes
        }
        // 10 = valeur a changer par le temps réel du joueur.
        setTpsjoueur(10);
        Shaker shaker=niveauActuel.getShaker();
        lemanager.getPartieActuelle().getNiveau().Pts(tpsjoueur,shaker.getMaxpts(),shaker.getTpsshake());
        //return le tps.
        return 10;
    }

    /**
     * Méthode qui se lance en cas d'abandon du joueur (possibilité de quitter). Déclenche la fonction défaite de la partie et fait reprendre le joueur au niveau 1.
     */
    public void Recommencer(){
        lemanager.getPartieActuelle().getNiveau().setVictoire(false);
    }

}
