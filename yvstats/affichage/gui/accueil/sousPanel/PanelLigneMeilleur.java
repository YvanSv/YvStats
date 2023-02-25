package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import yvstats.Controleur;

import java.awt.GridLayout;

public class PanelLigneMeilleur extends JPanel {
    private Controleur ctrl;

    public PanelLigneMeilleur(Controleur ctrl) {
        this.ctrl = ctrl;
        this.setOpaque(false);
        this.setLayout(new GridLayout(0,5,180,0));

        this.add(new JLabel());
        this.add(new PanelMeilleurArtiste(this.ctrl.getMeilleurArtiste()));
        this.add(new PanelMeilleurAlbum(this.ctrl.getMeilleurAlbum()));
        this.add(new PanelMeilleurMusique(this.ctrl.getMeilleurMusique()));
        this.add(new JLabel());
    }
}
