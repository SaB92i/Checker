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
     int cdx, cdy;



     public Souris(Tablier tablier, Window dashboard) {
        this.tablier=tablier;
        this.dashboard=dashboard;
     }

    public void mouseClicked(MouseEvent e) {
        int l2 = e.getX() / Configuration.TAILLE_CASE;
        int c2 = e.getY() / Configuration.TAILLE_CASE;
        Case c = tablier.getMatrice()[c2][l2];


        if (c.estUnPion() && !clic) {
            casedepart = c;
            cdx=l2;
            cdy=c2;
            clic = true;
            System.out.println("Pion selectionné");
        }
        else{
            if (c.estUnPion() && clic){
                System.out.println("Pion relaché");
                clic=false;
            }
        }
        if (!c.estUnPion() && clic ) {
            Accepteur a = new Accepteur(l2,c2,cdx,cdy,casedepart,tablier);
            if (a.accepte()){
                System.out.println("déplacement valide");
                clic=false;
                Pion p =casedepart.getPion();
                casedepart.setPion(null);
                c.setPion(p);
                dashboard.repaint();
                System.out.println("Déplacement effectué");
            }
            else {
                System.out.println("INTERDIT");
                clic=false;
            }
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
