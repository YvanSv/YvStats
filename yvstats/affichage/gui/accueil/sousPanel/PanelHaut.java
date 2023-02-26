package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

import yvstats.utils.PanelLabel;

public class PanelHaut extends JPanel {
    public PanelHaut() {
        this.setBackground(new Color(16,16,16));
        this.setLayout(new GridLayout(3,3));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new PanelLabel("Artistes"));
        this.add(new PanelLabel("Albums"));
        this.add(new PanelLabel("Musiques"));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
    }
}
