package yvstats.utils;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class PanelLabel extends JPanel {
    public JLabel lbl;

    public PanelLabel(String label) {
        this.setOpaque(false);
        this.lbl = new JLabel(label);
        this.lbl.setFont(Polices.arista_pro_light);
        this.lbl.setForeground(Color.WHITE);
        this.lbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.lbl);
    }

    public PanelLabel(String label, int taille) {
        this.setOpaque(false);
        this.lbl = new JLabel(label);
        switch(taille) {
            case 20 : this.lbl.setFont(Polices.arista_pro_light_20); break;
            case 27 : this.lbl.setFont(Polices.arista_pro_light_titre); break;
            case 30 : this.lbl.setFont(Polices.arista_pro_light_30); break;
            case 45 : this.lbl.setFont(Polices.arista_pro_light); break;
            default : this.lbl.setFont(Polices.arista_pro_light_20);
        }
        this.lbl.setForeground(Color.WHITE);
        this.lbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.lbl);
    }

    public PanelLabel(String label, Font font) {
        this.setOpaque(false);
        this.lbl = new JLabel(label);
        this.lbl.setFont(font);
        this.lbl.setForeground(Color.WHITE);
        this.lbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(this.lbl);
    }

    public void setText(String text) {
        this.lbl.setText(text);
    }
}
