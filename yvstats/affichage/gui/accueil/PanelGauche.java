package yvstats.affichage.gui.accueil;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import yvstats.Controleur;
import yvstats.affichage.gui.accueil.parametres.PanelParametres;
import yvstats.utils.PanelVide;

public class PanelGauche extends JPanel{

    public PanelGauche(Controleur ctrl) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new PanelVide(348, 1));
        this.add(new PanelParametres());
    }
}
