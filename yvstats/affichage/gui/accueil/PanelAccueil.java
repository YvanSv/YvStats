package yvstats.affichage.gui.accueil;

import javax.swing.JPanel;

import java.awt.Color;

import yvstats.Controleur;

public class PanelAccueil extends JPanel {
    public PanelAccueil(Controleur ctrl) {
        this.setBackground(new Color(12,12,12));
        this.add(new PanelGauche(ctrl));
        this.add(new PanelDroit(ctrl));
    }
}
