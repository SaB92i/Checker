package moteur.donnee;
import java.awt.*;

public class Tablier {
    private int nbligne;
    private int nbcolonne;
    private String forme;
    private Case[][] matrice;
    private int nbjoueur;
    private boolean reglespe;


    public Tablier(String forme, int nbjoueur, boolean reglespe) {
        this.forme = forme;
        this.nbjoueur = nbjoueur;
        this.reglespe = reglespe;
        //taille a définir
        matrice = new Case[40][40];
    }

    public Tablier(int nbligne, int nbcolonne) {
        this.nbligne = nbligne;
        this.nbcolonne = nbcolonne;
        matrice = new Case[nbligne][nbcolonne];
        couleurCase();
        ajoutPion();
    }

    private void ajoutPion() {
        matrice[0][0].setPion(new Pion(Color.BLUE));

    }

    private void couleurCase() {
        for (int l = 0; l < matrice.length; l++) {
            for (int c = 0; c < matrice[0].length; c++) {
                if ((l + c) % 2 == 0) {
                    matrice[l][c] = new Case( new Color(000000));
                }
                else {
                    matrice[l][c] = new Case( new Color(0x534F4F));
                }
            }
        }
    }


    public int getNbLigne() {
        return nbligne;
    }

    public int getNbColonne() {
        return nbcolonne;
    }

    public int getNbjoueur() {
        return nbjoueur;
    }

    public Case[][] getMatrice() {
        return matrice;
    }


}