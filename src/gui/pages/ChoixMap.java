package gui.pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import config.Configuration;
import gui.pages.MenuPrincipal;

public class ChoixMap extends JFrame{


    private static final long serialVersionUID = 1L;


    private final static Dimension preferredSize = new Dimension(800, 600);


    private JButton carreb = new JButton("Carré");//Bouton pour lancer avec la map en forme carré
    private JButton rectb = new JButton("Rectangle");//Bouton pour lancer avec la map en forme rectangle
    private JButton etoileb = new JButton("Étoile");//Bouton pour lancer avec la map en forme étoile
    private JButton retourb = new JButton("Retour");//Bouton servant a revenir l'interface d'Acceuil
    private JButton quitterb = new JButton("Quitter");//Bouton servant a fermer le jeu

    private JLabel titrel;//Titre de la page


    public ChoixMap(int nbjoueur) {

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setSize(preferredSize);

        this.setTitle("Choix de la map");


        titrel = new JLabel("Choisissez la map");
        titrel.setForeground(Color.BLACK);
        titrel.setFont(new Font("DialogInput", Font.BOLD, 30));
        titrel.setBounds(0, 30, Configuration.WINDOW_WIDTH, 70);
        titrel.setHorizontalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(titrel);

        carreb.setBounds(255, 120, 250, 50);
        carreb.setForeground(Color.BLACK);
        this.getContentPane().add(carreb);
        carreb.setFont(new Font("Zapfino", Font.BOLD, 34));

        rectb.setBounds(255, 190, 250, 50);
        rectb.setForeground(Color.BLACK);
        this.getContentPane().add(rectb);
        rectb.setFont(new Font("Zapfino", Font.BOLD, 34));

        etoileb.setBounds(255, 260, 250, 50);
        etoileb.setForeground(Color.BLACK);
        this.getContentPane().add(etoileb);
        etoileb.setFont(new Font("Zapfino", Font.BOLD, 34));

        retourb.setBounds(255, 330, 250, 50);
        retourb.setForeground(Color.BLACK);
        this.getContentPane().add(retourb);
        retourb.setFont(new Font("Zapfino", Font.BOLD, 34));

        quitterb.setBounds(255, 400,250, 50);
        quitterb.setForeground(Color.BLACK);
        this.getContentPane().add(quitterb);
        quitterb.setFont(new Font("Zapfino", Font.BOLD, 34));

        carreb.addActionListener(new Solo(this));
        rectb.addActionListener(new Duo(this));
        etoileb.addActionListener(new Trio(this));
        retourb.addActionListener(new Retour(this));
        quitterb.addActionListener(new Quitter(this));

        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
        this.setVisible(true);
        this.setResizable(false);
        this.setBounds(0, 0, Configuration.WINDOW_WIDTH, Configuration.WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private class Solo implements ActionListener{//ActionListener permettant de jouer en solo
        private JFrame window;

        public Solo(JFrame window) {//Constructeur de la Classe
            this.window = window;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            //new Jeu("JvsBot",bestplayername ,bestplayertime);
            window.dispose();


        }
    }

    private class Duo implements ActionListener{//ActionListener permettant de jouer en Duo
        private JFrame window;

        public Duo(JFrame window) {//Constructeur de la Classe
            this.window = window;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            //new FrameNomJoueur("JvsJ",bestplayername ,bestplayertime);
            window.dispose();



        }
    }

    private class Trio implements ActionListener{//ActionListener permettant de jouer en Trio
        private JFrame window;

        public Trio(JFrame window) {//Constructeur de la Classe
            this.window = window;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            new Jeu(3);
            window.dispose();


        }
    }

    private class Retour implements ActionListener{//ActionListener permettant de revenir en arrière

        private JFrame window;
        public Retour(JFrame window) {//Constructeur de la Classe
            this.window = window;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            new MenuPrincipal();
            window.dispose();


        }
    }

    private class Quitter implements ActionListener {//ActionListener permettant de fermer le jeu
        private JFrame window;

        public Quitter(JFrame window) {//Constructeur de la Classe
            this.window = window;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            window.dispose();
        }
    }

}