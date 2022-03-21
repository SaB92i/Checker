package moteur.deplacement;

import moteur.donnee.Case;
import moteur.donnee.Tablier;

import java.awt.*;

public class Accepteur {
    boolean autorise;
    int x, y, cdx, cdy;
    Case cased;
    Tablier tablier;


    public Accepteur(int x, int y, int cdx, int cdy,Case cased, Tablier tablier){
    this.x=x;
    this.y=y;
    this.cdx=cdx;
    this.cdy=cdy;
    this.cased=cased;
    this.tablier=tablier;
    }
    public boolean accepte(){
        //déplacement des pions
        if (cased.estUnPion()){
            //deplacement a gauche
            if (x-cdx==-2 && y==cdy){
                autorise=true;
            }
            //deplacement a droite
            if (x-cdx==2 && y==cdy){
                autorise=true;
            }
            //deplacement haut droite
            if (x-cdx==1 && y-cdy==-1){
                autorise=true;
            }
            //deplacement haut gauche
            if (x-cdx==-1 && y-cdy==-1){
                autorise=true;
            }
            //deplacement bas droite
            if (x-cdx==1 && y-cdy==1){
                autorise=true;
            }
            //deplacement bas gauche
            if (x-cdx==-1 && y-cdy==1){
                autorise=true;
            }
            //l'utilisateur tente un saut a gauche
            if ((x-cdx==-4 && y==cdy)) {
                //il y a un pion a gauche donc on autorise le saut
                Case c=tablier.getMatrice()[y][x+2];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
            //l'utilisateur tente un saut a droite
            if ((x-cdx==4 && y==cdy)) {
                //il y a un pion a droite donc on autorise le saut
                Case c=tablier.getMatrice()[y][x-2];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
            //l'utilisateur tente un saut en haut a droite
            if ((x-cdx==2 && y-cdy==-2)) {
                //il y a un pion en haut a droite donc on autorise le saut
                Case c=tablier.getMatrice()[y+1][x-1];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
            //l'utilisateur tente un saut en haut a gauche
            if ((x-cdx==-2 && y-cdy==-2)) {
                //il y a un pion en haut a gauche donc on autorise le saut
                Case c=tablier.getMatrice()[y+1][x+1];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
            //l'utilisateur tente un saut en bas a droite
            if ((x-cdx==2 && y-cdy==2)) {
                //il y a un pion en bas a droite donc on autorise le saut
                Case c=tablier.getMatrice()[y-1][x-1];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
            //l'utilisateur tente un saut en bas a gauche
            if ((x-cdx==-2 && y-cdy==2)) {
                //il y a un pion en bas a gauche donc on autorise le saut
                Case c=tablier.getMatrice()[y-1][x+1];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
        }
        //déplcament des méga pions
        if (cased.getPion().estUnMegaPion() || ((cased.estUnPion() && ((x<15)&&(x>9))&&(y<10)&&(y>5)))){
            //deplacement a gauche
            if (x-cdx==-4 && y==cdy){
                autorise=true;
            }
            //deplacement a droite
            if (x-cdx==4 && y==cdy){
                autorise=true;
            }
            //deplacement haut droite
            if (x-cdx==2 && y-cdy==-2){
                autorise=true;
            }
            //deplacement haut gauche
            if (x-cdx==-2 && y-cdy==-2){
                autorise=true;
            }
            //deplacement bas droite
            if (x-cdx==2 && y-cdy==2){
                autorise=true;
            }
            //deplacement bas gauche
            if (x-cdx==-2 && y-cdy==2){
                autorise=true;
            }
            //l'utilisateur tente un saut a gauche
            if ((x-cdx==-4 && y==cdy)) {
                //il y a un pion a gauche donc on autorise le saut
                Case c=tablier.getMatrice()[y][x+2];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
            //l'utilisateur tente un saut a droite
            if ((x-cdx==4 && y==cdy)) {
                //il y a un pion a droite donc on autorise le saut
                Case c=tablier.getMatrice()[y][x-2];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
            //l'utilisateur tente un saut en haut a droite
            if ((x-cdx==2 && y-cdy==-2)) {
                //il y a un pion en haut a droite donc on autorise le saut
                Case c=tablier.getMatrice()[y+1][x-1];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
            //l'utilisateur tente un saut en haut a gauche
            if ((x-cdx==-2 && y-cdy==-2)) {
                //il y a un pion en haut a gauche donc on autorise le saut
                Case c=tablier.getMatrice()[y+1][x+1];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
            //l'utilisateur tente un saut en bas a droite
            if ((x-cdx==2 && y-cdy==2)) {
                //il y a un pion en bas a droite donc on autorise le saut
                Case c=tablier.getMatrice()[y-1][x-1];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
            //l'utilisateur tente un saut en bas a gauche
            if ((x-cdx==-2 && y-cdy==2)) {
                //il y a un pion en bas a gauche donc on autorise le saut
                Case c=tablier.getMatrice()[y-1][x+1];
                if (c.estUnPion()) {
                    autorise = true;
                }
            }
        }
        if ((tablier.getMatrice()[y][x].getCouleur().equals(Color.lightGray))){
            autorise=false;
        }
        return autorise;
    }
}
