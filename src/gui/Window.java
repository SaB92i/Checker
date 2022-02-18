package gui;

import moteur.donnee.Tablier;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {
    private static final long serialVersionUID = 1L;
    private Tablier tablier;
    //private Pion pion;
    private AffichageGUI couleur = new AffichageGUI();


    public Window(Tablier tablier) {
        this.tablier = tablier;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        couleur.paint(tablier, g);
    }
}
