package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import yvstats.metier.Objet;

public class PanelMeilleur extends JPanel {
    public PanelMeilleur(Objet o) {
        String nom = "inconnu";
        if (o != null) nom = o.getNom();
        this.setLayout(new GridLayout(2,0));
        ImageIcon img = new ImageIcon("../ressources/img/"+nom+".png");
        this.add(new JLabel(img));
        this.add(new JLabel(nom));
    }
}
