package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Color;

import yvstats.metier.Musique;
import yvstats.utils.Polices;

public class PanelMeilleurMusique extends JPanel {
    private JLabel img;
    private JLabel lblNom;
    private JLabel lblNomArtiste;

    public PanelMeilleurMusique(Musique a) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        String nom = "Inconnu", nomArtiste = "Inconnu";
        if (a != null) {
            nom = a.getNom();
            nomArtiste = a.getArtiste().getNom();
        }

        this.img = new JLabel(new ImageIcon("../ressources/img/"+nom+".png"));
        this.lblNom = new JLabel(nom);
        this.lblNomArtiste = new JLabel(nomArtiste);
        this.lblNom.setForeground(Color.WHITE);
        this.lblNomArtiste.setForeground(Color.WHITE);
        this.lblNom.setFont(Polices.arista_pro_light);
        this.lblNomArtiste.setFont(Polices.arista_pro_light_30);
        this.img.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblNom.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblNomArtiste.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(this.img);
        this.add(new PanelLigneVide(1, 10));
        this.add(this.lblNom);
        this.add(this.lblNomArtiste);
    }
}
