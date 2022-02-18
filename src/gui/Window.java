package gui;

import moteur.donnee.Tablier;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {
    private static final long serialVersionUID = 1L;
    private Tablier tablier;
    private AffichageGUI affichage = new AffichageGUI();


    public Window(Tablier tablier) {
        this.tablier = tablier;
    }

    public AffichageGUI getAffichage(){
        return affichage;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        affichage.paint(tablier, g);
    }
}
