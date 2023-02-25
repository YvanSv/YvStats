package yvstats.affichage.gui.accueil;

import javax.swing.JPanel;

import yvstats.Controleur;

public class PanelAccueil extends JPanel {
    // private Controleur ctrl;
    public PanelAccueil(Controleur ctrl) {
        // this.ctrl = ctrl;
        this.add(new PanelGauche(ctrl));
        this.add(new PanelDroit(ctrl));
    }
}
