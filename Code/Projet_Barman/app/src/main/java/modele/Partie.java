package modele;

public class Partie {
    private Niveau niveau;
    private Manager lemanager=Manager.getInstance();

    public Partie(Niveau niveau){
        this.niveau=niveau;
    }

    public Niveau getNiveau() { return niveau; }

    /**
     * Méthode qui passe au niveau suivant si le joueur a gagné le niveau actuel.
     */
    public void changerNiveau(){
        if (niveau.isVictoire()){
            lemanager.mémoriser(getNiveau());
            Shaker nvShaker=new Shaker(getNiveau().getNbMinPts()+90);
            this.niveau=new Niveau(niveau.getNbMinPts()+95,niveau.getNumNiveau()+1, niveau.getJoueur(),nvShaker);
        }
        return;
    }

    /**
     * Méthode appelée en cas d'abandon du joueur ou en cas de défaite (ptsjoueur<ptsNiveauSuivant)
     * @return si la défaite a bien été comptabilisée
     */
    public boolean defaite(){
        if (!niveau.isVictoire()){
            Shaker shaker=new Shaker(1000);
            this.niveau=new Niveau(700,1,niveau.getJoueur(),shaker);
            return true;
        }

        return false;
    }
}
