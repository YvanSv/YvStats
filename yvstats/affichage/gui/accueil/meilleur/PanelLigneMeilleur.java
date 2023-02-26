package yvstats.affichage.gui.accueil.meilleur;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import yvstats.Controleur;
import yvstats.utils.PanelVide;


public class PanelLigneMeilleur extends JPanel {
    private Controleur ctrl;

    public PanelLigneMeilleur(Controleur ctrl) {
        this.ctrl = ctrl;
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        this.add(new PanelVide(300, 1));
        this.add(new PanelMeilleurArtiste(this.ctrl.getMeilleurArtiste()));
        this.add(new PanelVide(200, 1));
        this.add(new PanelMeilleurAlbum(this.ctrl.getMeilleurAlbum()));
        this.add(new PanelVide(200, 1));
        this.add(new PanelMeilleurMusique(this.ctrl.getMeilleurMusique()));
        this.add(new PanelVide(300, 1));
    }
}
