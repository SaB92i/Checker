package moteur.deplacement;
import config.Configuration;
import gui.Window;
import moteur.donnee.Case;
import moteur.donnee.Pion;
import moteur.donnee.Tablier;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

 public class Souris implements MouseListener {
     private Tablier tablier;
     private boolean clic;
     Case casedepart;
     Window dashboard;

     public Souris(Tablier tablier, Window dashboard) {
        this.tablier=tablier;
        this.dashboard=dashboard;
     }

    public void mouseClicked(MouseEvent e) {
        int c2 = e.getX() / Configuration.TAILLE_CASE;
        int l2 = e.getY() / Configuration.TAILLE_CASE;

        Case c = tablier.getMatrice()[l2][c2];
        if (c.estUnPion() && !clic) {
            casedepart=c;
            clic=true;
            System.out.println("premier clic");
            System.out.println(clic);
        }
        if (!c.estUnPion() && clic) {
            clic=false;
            Pion p =casedepart.getPion();
            casedepart.setPion(null);
            c.setPion(p);
            dashboard.repaint();
        }







    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
