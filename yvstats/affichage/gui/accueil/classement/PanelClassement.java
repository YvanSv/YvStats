package yvstats.affichage.gui.accueil.classement;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.util.ArrayList;

import yvstats.affichage.gui.accueil.PanelDroit;
import yvstats.metier.Objet;
import yvstats.utils.PanelImage;

public class PanelClassement extends JPanel {
    private ArrayList<PanelLigne> alLabel;

    public PanelClassement(ArrayList<Objet> al) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.alLabel = new ArrayList<PanelLigne>();

        for (Objet o : al)
            this.alLabel.add(new PanelLigne(o));
        int size = 0, max = PanelDroit.HEIGHT;
        for (PanelLigne a : this.alLabel) {
            this.add(a);
            this.add(new PanelImage(1554, 4, PanelImage.CUBE));
            size += a.getHeight() + 4;
        }

        
        if (size < max)
            this.add(new PanelImage(1, max - size, PanelImage.VIDE));
    }
}