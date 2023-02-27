package yvstats.affichage.gui.accueil;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import yvstats.metier.Objet;
import yvstats.affichage.GUI;
import yvstats.affichage.gui.accueil.sousPanel.PanelCentre;
import yvstats.affichage.gui.accueil.sousPanel.PanelHaut;

public class PanelDroit extends JPanel {
    private PanelCentre pnlCentre;
    private PanelHaut pnlHaut;

    public PanelDroit(GUI gui) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.pnlHaut = new PanelHaut(gui);
        this.pnlCentre = new PanelCentre(gui);
        this.add(this.pnlHaut);
        this.add(this.pnlCentre);
    }

    public void setTaille() {
        this.pnlHaut.setTaille();
        this.pnlCentre.setTaille();
    }

    public void setClassement(ArrayList<Objet> al) {
        this.pnlCentre.setClassement(al);
    }

    public void setAccueil() {
        this.pnlCentre.setAccueil();
    }
}
