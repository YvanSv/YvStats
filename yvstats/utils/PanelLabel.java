package yvstats.utils;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

// public class PanelLabel extends JPanel implements MouseListener {
//     private JLabel lbl;

//     public PanelLabel(String label) {
//         this.setOpaque(false);
//         this.lbl = new JLabel(label);
//         this.lbl.setFont(Polices.arista_pro_light);
//         this.lbl.setForeground(Color.WHITE);
//         this.lbl.setHorizontalAlignment(SwingConstants.CENTER);
//         this.lbl.addMouseListener(this);
//         this.add(this.lbl);
//     }

//     public PanelLabel(String label, Font font) {
//         this.setOpaque(false);
//         this.lbl = new JLabel(label);
//         this.lbl.setFont(font);
//         this.lbl.setForeground(Color.WHITE);
//         this.lbl.setHorizontalAlignment(SwingConstants.CENTER);
//         this.lbl.addMouseListener(this);
//         this.add(this.lbl);
//     }

//     public void mouseClicked(MouseEvent e) {}
//     public void mousePressed(MouseEvent e) {}
//     public void mouseReleased(MouseEvent e) {}
//     public void mouseEntered(MouseEvent e) { this.lbl.setForeground(Couleur.VERT); }
//     public void mouseExited(MouseEvent e) { this.lbl.setForeground(Color.WHITE); }

//     public void setText(String text) {
//         this.lbl.setText(text);
//     }
// }

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