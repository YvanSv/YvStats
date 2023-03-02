package yvstats.affichage.gui.classement;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.util.ArrayList;

import yvstats.affichage.GUI;
import yvstats.metier.Objet;
import yvstats.utils.PanelImage;

public class PanelClassement extends JPanel {
    private ArrayList<PanelLigne> alLabel;

    public PanelClassement(GUI gui, ArrayList<Objet> al) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.alLabel = new ArrayList<PanelLigne>();

        for (int i = 0; i < al.size(); i++)
            this.alLabel.add(new PanelLigne(gui,al.get(i),i));

        for (PanelLigne a : this.alLabel) {
            this.add(a);
            this.add(new PanelImage(1552, 1, PanelImage.CUBE));
        }
    }
}
