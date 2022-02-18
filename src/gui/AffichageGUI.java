package gui;

import moteur.donnee.Case;
import moteur.donnee.Tablier;
import config.Configuration;

import java.awt.*;
import java.util.Objects;

public class AffichageGUI {
    private Graphics g;


    public void paint(Tablier tablier, Graphics graphics) {
        g=graphics;
        int caseSize = Configuration.TAILLE_CASE;
        Case[][] cases = tablier.getMatrice();


        for (int l = 0; l < cases.length; l++) {
            for (int c = 0; c < cases[l].length; c++) {

                if (Objects.equals(cases[l][c].getCouleur(), Color.gray) && !cases[l][c].estUnPion()) {
                    graphics.setColor(Color.gray);
                    graphics.fillRect(c * caseSize, l * caseSize, caseSize, caseSize);
                }
                if (Objects.equals(cases[l][c].getCouleur(), new Color(0)) && !cases[l][c].estUnPion()) {
                    graphics.setColor(Color.black);
                    graphics.fillRect(c * caseSize, l * caseSize, caseSize, caseSize);
                }
                if (cases[l][c].estUnPion()) {
                    if (cases[l][c].getPion().getCouleur() == Color.BLUE) {
                        graphics.setColor(cases[l][c].getCouleur());
                        graphics.fillRect(c * caseSize, l * caseSize,caseSize, caseSize);
                        graphics.setColor(Color.CYAN);
                        graphics.fillRoundRect(c * caseSize, l * caseSize, caseSize, caseSize, caseSize, caseSize);
                    }
                }

            }
        }
    }
}

