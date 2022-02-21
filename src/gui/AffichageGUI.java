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
                if (cases[l][c].estUnPion()) {
                    if (cases[l][c].getPion().getCouleur() == Color.BLUE) {
                        graphics.setColor(cases[l][c].getCouleur());
                        graphics.fillRect(c * tailleCase, l * tailleCase,tailleCase, tailleCase);
                        graphics.setColor(Color.CYAN);
                        graphics.fillRoundRect(c * tailleCase, l * tailleCase, tailleCase, tailleCase, tailleCase, tailleCase);
                    }
                }

            }
        }
    }
}

