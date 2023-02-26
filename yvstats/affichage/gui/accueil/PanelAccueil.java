package yvstats.affichage.gui.accueil;

import javax.swing.JPanel;

import yvstats.Controleur;
import yvstats.utils.Couleur;

public class PanelAccueil extends JPanel {
    public PanelAccueil(Controleur ctrl) {
        this.setBackground(Couleur.NOIR_12);
        this.add(new PanelGauche(ctrl));
        this.add(new PanelDroit(ctrl));
    }
}
