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
        this.niveauActuel=FabriqueNiveau.fabriquer(1);
    }

    public void setTpsjoueur(int tpsjoueur) { this.tpsjoueur = tpsjoueur; }

    /**
     * Méthode qui se lance en cas d'abandon du joueur (possibilité de quitter). Déclenche la fonction défaite de la partie et fait reprendre le joueur au niveau 1.
     */
    public void recommencer(){
        lemanager.getPartieActuelle().getNiveau().setVictoire(false);
    }

}
