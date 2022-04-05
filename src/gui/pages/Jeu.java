package gui.pages;

import config.Configuration;
import gui.Souris;
import moteur.deplacement.Tours;
import gui.Window;
import moteur.donnee.Tablier;

import javax.swing.*;
import java.awt.*;

public class Jeu extends JFrame implements Runnable {
    private Tablier tablier;
    private Window dashboard;
    private Tours tour;
    private JPanel panel = new JPanel();

    public Jeu(int nbjoueur) {
        init(nbjoueur);
    }

    public void init(int nbjoueur) {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        tablier = new Tablier("carre",3);
        dashboard = new Window(tablier);
        tour = new Tours(tablier,dashboard,3);
        Souris souris = new Souris(tablier,dashboard,tour);
        dashboard.addMouseListener(souris);

        dashboard.setPreferredSize(new Dimension(tablier.getNbColonne() * Configuration.TAILLE_CASE,tablier.getNbLigne() * Configuration.TAILLE_CASE));
        contentPane.add(dashboard, BorderLayout.CENTER);

        contentPane.add(BorderLayout.EAST, panel);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);
        //setPreferredSize(new Dimension(tablier.getNbLigne() * 33, tablier.getNbColonne() * 33));
        setLocationRelativeTo(null);
    }

    @Override
    public void run() {

    }
}
