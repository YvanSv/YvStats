package yvstats.affichage.gui.accueil.meilleur;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import yvstats.affichage.GUI;
import yvstats.utils.PanelImage;


public class PanelLigneMeilleur extends JPanel {
    public PanelLigneMeilleur(GUI gui) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        this.add(new PanelImage(300, 1, PanelImage.VIDE));
        this.add(new PanelMeilleurArtiste(gui.getMeilleurArtiste()));
        this.add(new PanelImage(200, 1, PanelImage.VIDE));
        this.add(new PanelMeilleurAlbum(gui.getMeilleurAlbum()));
        this.add(new PanelImage(200, 1, PanelImage.VIDE));
        this.add(new PanelMeilleurMusique(gui.getMeilleurMusique()));
        this.add(new PanelImage(300, 1, PanelImage.VIDE));
    }
}
