package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import yvstats.metier.Album;
import yvstats.utils.Polices;

public class PanelMeilleurAlbum extends JPanel implements MouseListener {
    private JLabel img;
    private JLabel lblNom;
    private JLabel lblNomArtiste;

    public PanelMeilleurAlbum(Album a) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        String nom = "Inconnu", nomArtiste = "Inconnu";
        if (a != null) {
            nom = a.getNom();
            nomArtiste = a.getArtiste().getNom();
        }

        this.img = new JLabel(new ImageIcon("../ressources/img/"+nom+".png"));
        this.lblNom = new JLabel(nom);
        this.lblNomArtiste = new JLabel(nomArtiste);
        this.lblNom.setForeground(Color.WHITE);
        this.lblNomArtiste.setForeground(Color.WHITE);
        this.lblNom.setFont(Polices.arista_pro_light);
        this.lblNomArtiste.setFont(Polices.arista_pro_light_30);
        this.img.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblNom.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblNomArtiste.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblNom.addMouseListener(this);
        this.lblNomArtiste.addMouseListener(this);

        this.add(this.img);
        this.add(new PanelLigneVide(1, 10));
        this.add(this.lblNom);
        this.add(this.lblNomArtiste);
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.lblNom)
            this.lblNom.setForeground(new Color(30,215,96));
        if (e.getSource() == this.lblNomArtiste)
            this.lblNomArtiste.setForeground(new Color(30,215,96));
            
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.lblNom)
            this.lblNom.setForeground(Color.WHITE);
        if (e.getSource() == this.lblNomArtiste)
            this.lblNomArtiste.setForeground(Color.WHITE);
    }
}
