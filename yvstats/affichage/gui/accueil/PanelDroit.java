package yvstats.affichage.gui.accueil;

import javax.swing.JPanel;

import yvstats.Controleur;
import yvstats.affichage.gui.accueil.sousPanel.PanelCentre;
import yvstats.affichage.gui.accueil.sousPanel.PanelHaut;

public class PanelDroit extends JPanel {
    public PanelDroit(Controleur ctrl) {
        this.add(new PanelHaut());
        this.add(new PanelCentre(ctrl));
    }
}
