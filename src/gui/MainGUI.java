package gui;

import config.Configuration;
import moteur.deplacement.Souris;
import moteur.donnee.Case;
import moteur.donnee.Tablier;

import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame implements Runnable {
    private Tablier tablier;
    private Window dashboard;
    private JPanel panel = new JPanel();

    public MainGUI() {
        init();
    }

    public void init() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        tablier = new Tablier(21, 21);
        dashboard = new Window(tablier);
        Souris souris = new Souris(tablier,dashboard);
        dashboard.addMouseListener(souris);

        dashboard.setPreferredSize(new Dimension(tablier.getNbLigne() * Configuration.TAILLE_CASE, tablier.getNbColonne() * Configuration.TAILLE_CASE));
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
