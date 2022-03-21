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
        // créer carré
        this.nbligne = nbligne;
        this.nbcolonne = nbcolonne;
        matrice = new Case[nbligne][nbcolonne];
        CreerCase("oui");
        ajoutPion("oui");
    }

    private void ajoutPion(String forme) {
        int decal=0,j=0;
        //Création du triangle de départ bleu
        for (int i=4;i<=7;i++) {
            j=0+decal;
            decal++;
            while (j<=7-decal) {
                if (i==4 && j==0){
                    matrice[i][j].setPion(new Pion(Color.BLUE,true));
                }
                else {
                    matrice[i][j].setPion(new Pion(Color.BLUE));
                }
                j+=2;
            }
        }
        decal=0;
        //Création du triangle de départ rouge
        for (int i=13;i<=16;i++) {
            j=9+decal;
            decal++;
            while (j<=16-decal) {
                if (i==16 && j==12){
                    matrice[i][j].setPion(new Pion(Color.RED,true));
                }
                else {
                    matrice[i][j].setPion(new Pion(Color.RED));
                }
                j+=2;
            }
        }
        decal=0;
        //Création du triangle de départ rose
        for (int i=4;i<=7;i++) {
            j=18-decal;
            decal--;
            while (j<=25+decal) {
                if (i==4 && j==24){
                    matrice[i][j].setPion(new Pion(Color.PINK,true));
                }
                else {
                    matrice[i][j].setPion(new Pion(Color.PINK));
                }
                j+=2;
            }
        }

    }

    private void CreerCase(String forme) {
        int decal=0,decal2=0;
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