package gui.pages;

import config.Configuration;

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


public class MenuPrincipal  extends JFrame {


    private static final long serialVersionUID = 1L;

    private final static Dimension preferredSize = new Dimension(800, 600);

    private JButton jouerb = new JButton("JOUER");//Bouton permettant de choisir le nombre de joueurs

    private JButton quitterb = new JButton(" QUITTER ");//Bouton permettant de quitter

    private JButton aideb = new JButton(" AIDE ");//Bouton qui ouvre la page d'aide

    private JLabel titrel ;//Titre du Projet
    private JLabel creditl1 ;//Credit contenant nos noms
    private JLabel creditl2 ;//Credits


    public MenuPrincipal() {


        this.setTitle("CHECKER");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.setSize(preferredSize);


        creditl1 = new JLabel("AUTEURS: Amine Boukelmoun & Sabry Flici");
        creditl1.setFont(new Font("DialogInput", Font.BOLD, 24));
        creditl1.setForeground(Color.BLACK);
        creditl1.setHorizontalAlignment(SwingConstants.CENTER);
        creditl1.setBounds(20, 420, 700, 50);
        this.getContentPane().add(creditl1);

        creditl2 = new JLabel("PROJET GLP | 2021/2022");
        creditl2.setFont(new Font("DialogInput", Font.BOLD, 24));
        creditl2.setForeground(Color.BLACK);
        creditl2.setHorizontalAlignment(SwingConstants.CENTER);
        creditl2.setBounds(15, 445, 700, 50);
        this.getContentPane().add(creditl2);


        titrel= new JLabel("CHECKER");
        titrel.setForeground(Color.BLACK);
        titrel.setFont(new Font("DialogInput", Font.BOLD, 80));
        titrel.setBounds(210, 50, 400, 70);
        this.getContentPane().add(titrel);

        jouerb.setHorizontalAlignment(SwingConstants.CENTER);
        jouerb.setFont(new Font("Zapfino", Font.BOLD, 30));
        jouerb.setBounds(255, 150, 250, 50);
        jouerb.setForeground(Color.BLACK);
        this.getContentPane().add(jouerb);

        aideb.setHorizontalAlignment(SwingConstants.CENTER);
        aideb.setFont(new Font("Zapfino", Font.BOLD, 30));
        aideb.setForeground(Color.BLACK);
        aideb.setBounds(255, 250, 250, 50);
        this.getContentPane().add(aideb);

        quitterb.setHorizontalAlignment(SwingConstants.CENTER);
        quitterb.setFont(new Font("Zapfino", Font.BOLD, 30));
        quitterb.setForeground(Color.BLACK);
        quitterb.setBounds(255, 350, 250, 50);
        this.getContentPane().add(quitterb);

        jouerb.addActionListener(new Jouer(this));//Ajout de l'ActionListener servant a la lancer la partie
        quitterb.addActionListener(new Quitter(this));//Ajout de  l'ActionListener servant a fermer le programme
        aideb.addActionListener(new Aide(this));


        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.decode("#cccccc"));
        this.setVisible(true);
        this.setResizable(false);
        this.setBounds(0, 0, Configuration.WINDOW_WIDTH, Configuration.WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private class Jouer implements ActionListener{//Actionlistener pour lancer la partie
        private JFrame window;

        public Jouer(JFrame window) {//Constructeur de la Classe
            this.window = window;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispose();
            new ChoixJoueurs();

        }
    }

    private class Aide implements ActionListener{//Actionlistener pour ouvrir le menu d'aide
        private JFrame window;

        public Aide(JFrame window) {//Constructeur de la Classe
            this.window = window;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new Infos();
            window.dispose();
        }
    }

    private class Quitter implements ActionListener {//Actionlistener pour fermer le jeu
        private JFrame window;
        public Quitter(JFrame window) {//Constructeur de la Classe
            this.window = window;
        }
        @Override
        public void actionPerformed(ActionEvent e) {//Methode parametrant l'action de fermeture de la fenêtre d'accueil

            window.dispose();
        }
    }


}

