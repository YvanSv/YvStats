package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.JPanel;
import java.awt.GridLayout;

import yvstats.Controleur;
import yvstats.metier.Objet;

public class PanelCentre extends JPanel {
    private Controleur ctrl;

    public PanelCentre(Controleur ctrl) {
        this.ctrl = ctrl;
        this.setLayout(new GridLayout(0,3));
        for (Objet o : this.ctrl.getMeilleurs())
            this.add(new PanelMeilleur(o));
    }
}
