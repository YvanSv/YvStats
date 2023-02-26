package yvstats.affichage.gui.accueil.meilleur;

import java.awt.Color;
import java.awt.event.MouseEvent;

import yvstats.metier.Album;

public class PanelMeilleurAlbum extends PanelMeilleur {
    public PanelMeilleurAlbum(Album a) {
        super(a,"Album");
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getSource());
    }

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
