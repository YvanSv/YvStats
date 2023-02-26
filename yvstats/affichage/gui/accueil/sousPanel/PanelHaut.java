package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import yvstats.utils.Couleur;
import yvstats.utils.PanelLabel;

public class PanelHaut extends JPanel implements MouseListener {
    private PanelLabel pnlArtistes;
    private PanelLabel pnlAlbums;
    private PanelLabel pnlMusiques;

    public PanelHaut() {
        this.setBackground(Couleur.NOIR_16);
        this.setLayout(new GridLayout(3,3));

        this.pnlArtistes = new PanelLabel("Artistes");
        this.pnlArtistes.lbl.addMouseListener(this);

        this.pnlAlbums = new PanelLabel("Albums");
        this.pnlAlbums.lbl.addMouseListener(this);

        this.pnlMusiques = new PanelLabel("Musiques");
        this.pnlMusiques.lbl.addMouseListener(this);

        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(this.pnlArtistes);
        this.add(this.pnlAlbums);
        this.add(this.pnlMusiques);
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.pnlArtistes.lbl) this.pnlArtistes.lbl.setForeground(Couleur.VERT);
        else if (e.getSource() == this.pnlAlbums.lbl) this.pnlAlbums.lbl.setForeground(Couleur.VERT);
        else if (e.getSource() == this.pnlMusiques.lbl) this.pnlMusiques.lbl.setForeground(Couleur.VERT);
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.pnlArtistes.lbl) this.pnlArtistes.lbl.setForeground(Color.WHITE);
        else if (e.getSource() == this.pnlAlbums.lbl) this.pnlAlbums.lbl.setForeground(Color.WHITE);
        else if (e.getSource() == this.pnlMusiques.lbl) this.pnlMusiques.lbl.setForeground(Couleur.VERT);
    }
}
