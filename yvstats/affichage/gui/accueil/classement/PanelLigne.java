package yvstats.affichage.gui.accueil.classement;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import yvstats.affichage.GUI;
import yvstats.metier.Objet;
import yvstats.utils.Couleur;
import yvstats.utils.PanelLabel;
import yvstats.utils.PanelImage;
import yvstats.utils.Polices;

public class PanelLigne extends JPanel implements MouseListener {
    private GUI gui;
    private JLabel lblPlay;
    private PanelLabel lblNom;
    private PanelImage vide;

    public PanelLigne(GUI gui, Objet o) {
        this.gui = gui;

        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.addMouseListener(this);

        this.lblPlay = new JLabel("⏵");
        this.lblPlay.setFont(new Font("serif",Font.BOLD,20));
        this.lblPlay.setForeground(Color.WHITE);
        this.lblPlay.addMouseListener(this);

        this.vide = new PanelImage(8, 1, PanelImage.VIDE);

        this.lblNom = new PanelLabel(o.getNom(),Polices.T20);

        this.add(new PanelImage(20,1,PanelImage.VIDE));
        this.add(this.vide);
        this.add(this.lblNom);
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.lblPlay) this.lblPlay.setForeground(Couleur.VERT);
        else if (e.getSource() == this) {
            this.remove(this.vide);
            this.remove(this.lblNom);
            this.add(this.lblPlay);
            this.add(this.lblNom);
            this.gui.refresh();
        }
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.lblPlay) this.lblPlay.setForeground(Color.WHITE);
        else if (e.getSource() == this) {
            this.remove(this.lblPlay);
            this.remove(this.lblNom);
            this.add(this.vide);
            this.add(this.lblNom);
            this.gui.refresh();
        }
    }
}

