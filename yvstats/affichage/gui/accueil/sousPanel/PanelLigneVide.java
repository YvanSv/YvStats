package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Image;

public class PanelLigneVide extends JPanel{
    private JLabel tmp;
    public PanelLigneVide(int largeur, int hauteur) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setOpaque(false);
        this.tmp = new JLabel(new ImageIcon(new ImageIcon("../ressources/img/nothing.png").getImage().getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT)));
        this.add(this.tmp);
    }
}
