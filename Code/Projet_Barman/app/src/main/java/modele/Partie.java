package modele;

public class Partie {
    private Niveau niveau;
    private final Manager lemanager = Manager.getInstance();

    public Partie(Niveau niveau){
        this.niveau=niveau;
    }

    public Niveau getNiveau() { return niveau; }

    /**
     * Méthode qui passe au niveau suivant si le joueur a gagné le niveau actuel.
     */
    public void changerNiveau(){
        if (niveau.isVictoire()){
            lemanager.memorize(getNiveau());
            this.niveau= FabriqueNiveau.fabriquer(niveau.getNumNiveau()+1);
        }
    }

    /**
     * Méthode appelée en cas d'abandon du joueur ou en cas de défaite (ptsjoueur<ptsNiveauSuivant)
     */
    public void defaite(){
        if (!niveau.isVictoire()){
            this.niveau=FabriqueNiveau.fabriquer(1);
        }

    }
}
