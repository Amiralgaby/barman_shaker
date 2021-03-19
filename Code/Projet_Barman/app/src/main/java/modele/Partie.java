package modele;

/**
 * le modèle de la partie contenant le niveau qui est joué par le joueur
 */
public class Partie {
    private Niveau niveau;

    public Partie(Niveau niveau){
        this.niveau=niveau;
    }

    public Niveau getNiveau() { return niveau; }

    public void setNiveau(Niveau niveau) { this.niveau = niveau; }

    /**
     * Méthode qui passe au niveau suivant si le joueur a gagné le niveau actuel.
     * sinon le renvoie au niveau 1
     * la partie n'est pas relancée, juste reconfigurée
     */
    public void continuerAJouer(){
        /* TODO -- le niveau change directement on peut faire autrement, voir si obtenir directement les points du joueur avec la méthode pts de Niveau */
        if (niveau.isVictoire()){
            Manager.getInstance().memorize(getNiveau());
            //this.niveau= FabriqueNiveau.fabriquer(niveau.getNumNiveau()+1);
        }else{
            //this.niveau=FabriqueNiveau.fabriquer(1);
        }
    }
}
