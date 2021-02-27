package modele;

import java.util.ArrayList;

public class Manager {
    private Partie partieActuelle;
    private ArrayList<Niveau> listeNiveaux = new ArrayList<>();

    /**
     * (seule) Instance de manager.
     */
    private static Manager INSTANCE = new Manager();

    /**
     * @return l'instance du manager
     */
    public static  Manager getInstance() { return INSTANCE; }

    public Partie getPartieActuelle() { return partieActuelle; }

    public void setPartieActuelle(Partie partieActuelle) {
        this.partieActuelle = partieActuelle;
    }

    /**
     * Méthode qui ajoute un niveau a la liste de niveaux terminés.
     * @param niveau= niveau qui vient d'être terminé
     */
    public void memorize(Niveau niveau) {
        listeNiveaux.add(niveau);
    }
}
