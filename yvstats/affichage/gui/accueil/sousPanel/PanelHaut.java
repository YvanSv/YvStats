package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import yvstats.affichage.GUI;
import yvstats.utils.Couleur;
import yvstats.utils.PanelLabel;

public class PanelHaut extends JPanel implements MouseListener {
    private GUI gui;
    public static int height = 0;
    public static int width = 0;
    private PanelLabel pnlArtistes;
    private PanelLabel pnlAlbums;
    private PanelLabel pnlMusiques;

    public PanelHaut(GUI gui) {
        this.gui = gui;

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

        PanelHaut.height = this.getY();
        PanelHaut.width = this.getX();
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.pnlArtistes.lbl) this.gui.setClassementArtiste();
        else if (e.getSource() == this.pnlAlbums.lbl) this.gui.setClassementAlbums();
        else if (e.getSource() == this.pnlMusiques.lbl) this.gui.setClassementMusiques();
    }
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
        else if (e.getSource() == this.pnlMusiques.lbl) this.pnlMusiques.lbl.setForeground(Color.WHITE);
    }

    public void setTaille() {
        PanelHaut.height = this.getHeight();
        PanelHaut.width = this.getWidth();
    }
}
