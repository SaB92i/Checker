package moteur.donnee;
import java.awt.*;

public class Tablier {
    private int nbligne;
    private int nbcolonne;
    private String forme;
    private Case[][] matrice;
    private int nbjoueur, decal=0,decal2=0;
    private boolean reglespe;


    public Tablier(String forme, int nbjoueur, boolean reglespe) {
        this.forme = forme;
        this.nbjoueur = nbjoueur;
        this.reglespe = reglespe;
        //taille a définir
        matrice = new Case[40][40];
    }

    public Tablier(int nbligne, int nbcolonne) {
        // créer carré
        this.nbligne = nbligne;
        this.nbcolonne = nbcolonne;
        matrice = new Case[nbligne][nbcolonne];
        couleurCase("oui");
        ajoutPion("oui");
    }

    private void ajoutPion(String forme) {
        matrice[5][5].setPion(new Pion(Color.BLUE));
        matrice[7][7].setPion(new Pion(Color.BLUE));

    }

    private void couleurCase(String forme) {
        for (int l = 0; l < matrice.length; l++) {

            for (int c = 0; c < matrice[l].length; c++) {

                if ((l + c) % 2 == 0) {
                    matrice[l][c] = new Case( new Color(000000));
                }
                else {
                    matrice[l][c] = new Case(Color.gray);
                }
            }
        }
        //Création de la "zone morte" en haut à gauche
        for (int y=0;y<=3;y++){
            for (int x=9-y;x>=0;x--) {
                matrice[y][x]= new Case(Color.lightGray);
            }
        }
        //Création de la "zone morte" en haut à droite
        for (int y=0;y<=3;y++){
            for (int x=11+y;x<21;x++) {
                matrice[y][x]= new Case(Color.lightGray);
            }
        }
        //Création de la "zone morte" à gauche
        for (int y=5;y<=15;y++){
            if (y<9){
                decal++;
            }
            else if (y>12){
                decal--;
            }
            for (int x=0;x<decal;x++) {
                matrice[y][x]= new Case(Color.lightGray);
            }
        }
        //Création de la "zone morte" à droite
        for (int y=5;y<=15;y++){
            if (y<9){
                decal++;
            }
            else if (y>12){
                decal--;
            }
            for (int x=20;x>(21-decal);x--) {
                matrice[y][x]= new Case(Color.lightGray);
            }
        }
        //Création de la "zone morte" en bas a gauche
        for (int y=17;y<21;y++){
            decal2++;
            for (int x=0;x<6+decal2;x++) {
                matrice[y][x]= new Case(Color.lightGray);
            }
        }
        //Création de la "zone morte" en bas a droite
        for (int y=17;y<21;y++){
            decal2++;
            for (int x=20;x>(18-decal2);x--) {
                matrice[y][x]= new Case(Color.lightGray);
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