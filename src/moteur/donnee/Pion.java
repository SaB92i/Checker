package moteur.donnee;

import java.awt.*;

public class Pion {
    private Color couleur;
    private boolean mega;


    public Pion( Color couleur) {
        this.couleur = couleur;
        this.mega=false;
    }


    public Pion( Color couleur, boolean mega) {
        this.couleur = couleur;
        this.mega = mega;
    }

    public Color getCouleur() {
        return couleur;
    }

    public boolean isMega() {
        return mega;
    }

}
