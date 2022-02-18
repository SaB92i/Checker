package moteur.donnee;

import java.awt.*;

public class Case {
    private Pion pion;
    private Color couleur;



    //Constructeur pour les cases
    public Case (Pion pion,Color couleur) {
        this.pion  = pion;
        this.couleur = couleur;

    }

    public Case(Color couleur) {

        this.couleur = couleur;
    }

    public Pion getPion() {
        return pion;
    }
    public void setPion(Pion pion) {
        this.pion = pion;
    }

    public boolean estUnPion(){
        return(pion!=null);
    }

    public Color getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {

        this.couleur = Color.decode(couleur);
    }

    public boolean isMegapion(Pion pion) {return pion.isMega();}


}

