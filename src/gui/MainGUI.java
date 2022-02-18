package gui;

import moteur.donnee.Tablier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainGUI extends JFrame implements Runnable {
    private Tablier tablier;
    private Window dashboard;
    private JPanel panel = new JPanel();

    public MainGUI() {
        init();
    }
    public void init(){
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        tablier = new Tablier(10,10);

        if(tablier.getMatrice()[0][0].getPion().getCouleur()==Color.BLUE){
            System.out.println("pd");
        }
        dashboard = new Window(tablier);

        dashboard.setPreferredSize(new Dimension(tablier.getNbLigne()*33,tablier.getNbColonne()*33));
        contentPane.add(dashboard, BorderLayout.CENTER);

        contentPane.add(BorderLayout.EAST,panel);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        //setResizable(false);
        setPreferredSize(new Dimension(tablier.getNbLigne()*33,tablier.getNbColonne()*33));
        setLocationRelativeTo(null);
    }



    @Override
    public void run() {

    }
}
