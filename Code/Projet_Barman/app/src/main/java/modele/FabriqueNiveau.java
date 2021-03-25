package modele;

/**
 * Fabrique les niveaux
 */
public class FabriqueNiveau {
    /**
     * Fabrique un niveau avec les bonnes configurations selon le niveau
     * @param numNiveau le numéro du niveau
     * @return le niveau à mettre dans la partie
     */
    public static Niveau fabriquer(int numNiveau)
    {
        int numNiveau0 = numNiveau-1;
        return new Niveau(numNiveau,new Shaker((int) (700*(Math.pow(2,numNiveau0))*300),numNiveau0));
    }
}
