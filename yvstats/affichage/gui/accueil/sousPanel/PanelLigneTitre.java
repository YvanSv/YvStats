package yvstats.affichage.gui.accueil.sousPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;

import yvstats.utils.Polices;

public class PanelLigneTitre extends JPanel {
    private JLabel lblTitreArtiste;
    private JLabel lblTitreAlbum;
    private JLabel lblTitreMusique;

    public PanelLigneTitre() {
        this.setOpaque(false);
        this.setLayout(new GridLayout(0,5,180,0));
        this.lblTitreArtiste = new JLabel("Artiste préféré");
        this.lblTitreAlbum = new JLabel("Album préféré");
        this.lblTitreMusique = new JLabel("Musique préférée");
        this.lblTitreArtiste.setForeground(Color.WHITE);
        this.lblTitreAlbum.setForeground(Color.WHITE);
        this.lblTitreMusique.setForeground(Color.WHITE);
        this.lblTitreArtiste.setFont(Polices.arista_pro_light_titre);
        this.lblTitreAlbum.setFont(Polices.arista_pro_light_titre);
        this.lblTitreMusique.setFont(Polices.arista_pro_light_titre);
        this.lblTitreArtiste.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblTitreAlbum.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblTitreMusique.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(new JLabel(""));
        this.add(this.lblTitreArtiste);
        this.add(this.lblTitreAlbum);
        this.add(this.lblTitreMusique);
        this.add(new JLabel(""));
    }
}
