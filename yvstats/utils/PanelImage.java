package yvstats.utils;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Image;

public class PanelImage extends JPanel {
    public static final String VIDE = "nothing.png";
    public static final String CUBE = "cube.png";
    private JLabel tmp;
    public PanelImage(int largeur, int hauteur, String nom) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setOpaque(false);
        this.tmp = new JLabel(new ImageIcon(new ImageIcon("../ressources/img/"+nom).getImage().getScaledInstance(largeur, hauteur, Image.SCALE_DEFAULT)));
        this.add(this.tmp);
    }
}
