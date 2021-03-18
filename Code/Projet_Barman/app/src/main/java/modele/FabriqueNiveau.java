package modele;

public class FabriqueNiveau {
    public static Niveau fabriquer(int numNiveau)
    {
        int numNiveau0 = numNiveau-1;
        return new Niveau(700+numNiveau0*100,numNiveau,new Shaker(700*(2^numNiveau0)*300,numNiveau0));
    }
}
