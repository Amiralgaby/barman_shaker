package modele;

public class FabriqueNiveau {
    public static Niveau fabriquer(int numNiveau)
    {
        int numNiveau0 = numNiveau-1;
        return new Niveau(numNiveau,new Shaker((int) (700*(Math.pow(2,numNiveau0))*300),numNiveau0));
    }
}
