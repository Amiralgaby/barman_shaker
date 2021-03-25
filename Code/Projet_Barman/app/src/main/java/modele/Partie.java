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

}
