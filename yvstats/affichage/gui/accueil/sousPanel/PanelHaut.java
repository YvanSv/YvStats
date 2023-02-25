package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;

import yvstats.utils.Polices;

public class PanelHaut extends JPanel implements ActionListener,MouseListener {
    private JButton btnArtistes;
    private JButton btnAlbums;
    private JButton btnMusiques;
    // private JLabel lblInvisible;

    public PanelHaut() {
        this.setBackground(new Color(5,5,5));
        this.setLayout(new GridLayout(3,3,150,0));
        // this.lblInvisible = new JLabel("invisible");
        this.btnArtistes = new JButton("Artistes");
        this.btnAlbums = new JButton("Albums");
        this.btnMusiques = new JButton("Musiques");
        this.btnArtistes.setFont(Polices.arista_pro_light);
        this.btnAlbums.setFont(Polices.arista_pro_light);
        this.btnMusiques.setFont(Polices.arista_pro_light);
        this.btnArtistes.setForeground(Color.WHITE);
        this.btnAlbums.setForeground(Color.WHITE);
        this.btnMusiques.setForeground(Color.WHITE);
        this.btnArtistes.setOpaque(false);
        this.btnArtistes.setContentAreaFilled(false);
        this.btnArtistes.setBorderPainted(false);
        this.btnAlbums.setOpaque(false);
        this.btnAlbums.setContentAreaFilled(false);
        this.btnAlbums.setBorderPainted(false);
        this.btnMusiques.setOpaque(false);
        this.btnMusiques.setContentAreaFilled(false);
        this.btnMusiques.setBorderPainted(false);
        this.btnArtistes.addMouseListener(this);
        this.btnAlbums.addMouseListener(this);
        this.btnMusiques.addMouseListener(this);
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(this.btnArtistes);
        this.add(this.btnAlbums);
        this.add(this.btnMusiques);
        for (int i = 0; i < 3; i++)
            this.add(new JLabel(""));
    }

    public void actionPerformed(ActionEvent e) {
    }
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.btnArtistes)
            this.btnArtistes.setForeground(new Color(30,215,96));
        if (e.getSource() == this.btnAlbums)
            this.btnAlbums.setForeground(new Color(30,215,96));
        if (e.getSource() == this.btnMusiques)
            this.btnMusiques.setForeground(new Color(30,215,96));
            
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.btnArtistes)
            this.btnArtistes.setForeground(Color.WHITE);
        if (e.getSource() == this.btnAlbums)
            this.btnAlbums.setForeground(Color.WHITE);
        if (e.getSource() == this.btnMusiques)
            this.btnMusiques.setForeground(Color.WHITE);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
