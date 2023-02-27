package yvstats.affichage.gui.accueil.classement;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import yvstats.metier.Objet;
import yvstats.utils.PanelLabel;
import yvstats.utils.Polices;

public class PanelLigne extends JPanel implements MouseListener {
    private JLabel lblPlay;
    private PanelLabel lblNom;

    public PanelLigne(Objet o) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.addMouseListener(this);

        this.lblPlay = new JLabel("⏵");
        this.lblPlay.setFont(new Font("serif",Font.BOLD,20));
        this.lblPlay.setForeground(Color.WHITE);
        this.lblPlay.addMouseListener(this);

        this.lblNom = new PanelLabel(o.getNom(),Polices.T20);

        this.add(this.lblPlay);
        this.add(this.lblNom);
        
        this.lblPlay.setVisible(false);
    }

    
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        this.lblPlay.setVisible(true);
    }
    public void mouseExited(MouseEvent e) {
        this.lblPlay.setVisible(true);
    }
}

