package modele;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * le modèle de la partie contenant le niveau qui est joué par le joueur
 */
public class Partie implements Serializable {
    private Niveau niveau;

    public Partie(Niveau niveau){
        this.niveau=niveau;
    }

    public Niveau getNiveau() { return niveau; }

    public void setNiveau(Niveau niveau) { this.niveau = niveau; }

    public void serialiser(ObjectOutputStream oos){
        try {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Partie deserialiser(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        return (Partie) ois.readObject();
    }

}
