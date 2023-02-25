package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import yvstats.metier.Artiste;
import yvstats.utils.Polices;

public class PanelMeilleurArtiste extends JPanel implements MouseListener {
    private JLabel img;
    private JLabel lblNom;

    public PanelMeilleurArtiste(Artiste a) {
        this.setOpaque(false);

        String nom = "Inconnu";
        if (a != null)
            nom = a.getNom();

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.img = new JLabel(new ImageIcon("../ressources/img/"+nom+".png"));
        this.lblNom = new JLabel(nom);
        this.lblNom.setForeground(Color.WHITE);
        this.lblNom.setFont(Polices.arista_pro_light);
        this.img.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblNom.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblNom.addMouseListener(this);

        this.add(this.img);
        this.add(new PanelLigneVide(1, 10));
        this.add(this.lblNom);
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.lblNom)
            this.lblNom.setForeground(new Color(30,215,96));
            
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.lblNom)
            this.lblNom.setForeground(Color.WHITE);
    }
}
