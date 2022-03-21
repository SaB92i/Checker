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
        for (int i=4;i<8;i++) {
            for (int j=0;j<=7;) {
                matrice[4][0].setPion(new Pion(Color.BLUE));
            }
        }

    }

    private void couleurCase(String forme) {
        for (int l = 0; l < nbligne; l++) {

            for (int c = 0; c < nbcolonne; c++) {

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
            for (int x=11-y;x>=0;x--) {
                matrice[y][x]= new Case(Color.lightGray);
            }
        }

        //Création de la "zone morte" en haut à droite
        for (int y=0;y<=3;y++){
            for (int x=13+y;x<25;x++) {
                matrice[y][x]= new Case(Color.lightGray);
            }
        }

        //Création de la "zone morte" à gauche
        for (int y=5;y<=11;y++){
            if (y<9){
                decal++;
            }
            else {
                decal--;
            }
            for (int x=0;x<decal;x++) {
                matrice[y][x]= new Case(Color.lightGray);
            }
        }

        //Création de la "zone morte" à droite
        for (int y=5;y<=11;y++){
            if (y<9){
                decal++;
            }
            else if (y>8){
                decal--;
            }
            for (int x=24;x>(25-decal);x--) {
                matrice[y][x]= new Case(Color.lightGray);
            }
        }

        //Création de la "zone morte" en bas a gauche
        for (int y=13;y<17;y++){
            decal2++;
            for (int x=0;x<8+decal2;x++) {
                matrice[y][x]= new Case(Color.lightGray);
            }
        }

        //Création de la "zone morte" en bas a droite
        for (int y=13;y<17;y++){
            decal2++;
            for (int x=24;x>(20-decal2);x--) {
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