package yvstats.affichage.gui.accueil.meilleur;

import java.awt.Color;
import java.awt.event.MouseEvent;

import yvstats.metier.Album;
import yvstats.utils.Couleur;

public class PanelMeilleurAlbum extends PanelMeilleur {
    public PanelMeilleurAlbum(Album a) {
        super(a,"Album");
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.lblNom)
            this.lblNom.setForeground(Couleur.VERT);
        if (e.getSource() == this.lblNomArtiste)
            this.lblNomArtiste.setForeground(Couleur.VERT);
            
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.lblNom)
            this.lblNom.setForeground(Color.WHITE);
        if (e.getSource() == this.lblNomArtiste)
            this.lblNomArtiste.setForeground(Color.WHITE);
    }
}
