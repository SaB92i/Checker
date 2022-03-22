package gui;

import moteur.donnee.Case;
import moteur.donnee.Tablier;
import config.Configuration;

import java.awt.*;
import java.util.Objects;

public class AffichageGUI {


    public void paint(Tablier tablier, Graphics graphics) {
        int tailleCase = Configuration.TAILLE_CASE;
        Case[][] cases = tablier.getMatrice();



        for (int l = 0; l < cases.length; l++) {

            for (int c = 0; c < cases[l].length; c++) {

                //affichage des cases
                if (Objects.equals(cases[l][c].getCouleur(), Color.gray) && !cases[l][c].estUnPion()) {
                    graphics.setColor(Color.gray);
                    graphics.fillRect(c * tailleCase, l * tailleCase, tailleCase, tailleCase);
                }
                if (Objects.equals(cases[l][c].getCouleur(), new Color(0)) && !cases[l][c].estUnPion()) {
                    graphics.setColor(Color.black);
                    graphics.fillRect(c * tailleCase, l * tailleCase, tailleCase, tailleCase);
                }
                if (Objects.equals(cases[l][c].getCouleur(), Color.lightGray) && !cases[l][c].estUnPion()) {
                    graphics.setColor(Color.lightGray);
                    graphics.fillRect(c * tailleCase, l * tailleCase, tailleCase, tailleCase);
                }

                //affichage des pions/megapions de couleur bleu
                if (cases[l][c].estUnPion()) {
                    if (cases[l][c].getPion().getCouleur() == Color.BLUE) {
                        graphics.setColor(cases[l][c].getCouleur());
                        graphics.fillRect(c * tailleCase, l * tailleCase,tailleCase, tailleCase);
                        if (cases[l][c].getPion().estUnMegaPion()){
                            graphics.setColor(Color.BLUE);
                        }
                        else {
                            graphics.setColor(Color.CYAN);
                        }
                        graphics.fillRoundRect(c * tailleCase, l * tailleCase, tailleCase, tailleCase, tailleCase, tailleCase);
                    }
                }

                //affichage des pions/megapions de couleur rouge
                if (cases[l][c].estUnPion()) {
                    if (cases[l][c].getPion().getCouleur() == Color.RED) {
                        graphics.setColor(cases[l][c].getCouleur());
                        graphics.fillRect(c * tailleCase, l * tailleCase,tailleCase, tailleCase);
                        if (cases[l][c].getPion().estUnMegaPion()){
                            graphics.setColor(Color.decode("#660000"));
                        }
                        else {
                            graphics.setColor(Color.RED);
                        }
                        graphics.fillRoundRect(c * tailleCase, l * tailleCase, tailleCase, tailleCase, tailleCase, tailleCase);
                    }
                }

                //affichage des pions/megapions de couleur rose
                if (cases[l][c].estUnPion()) {
                    if (cases[l][c].getPion().getCouleur() == Color.PINK) {
                        graphics.setColor(cases[l][c].getCouleur());
                        graphics.fillRect(c * tailleCase, l * tailleCase,tailleCase, tailleCase);
                        if (cases[l][c].getPion().estUnMegaPion()){
                            graphics.setColor(Color.decode("#9900FF"));
                        }
                        else {
                            graphics.setColor(Color.decode("#FF00FF"));
                        }
                        graphics.fillRoundRect(c * tailleCase, l * tailleCase, tailleCase, tailleCase, tailleCase, tailleCase);
                    }
                }
                //Affichage de la zone bonus
                graphics.setColor(Color.green);
                graphics.drawRect(9*tailleCase,5*tailleCase, tailleCase*7, tailleCase*6);
            }
        }
    }
}

