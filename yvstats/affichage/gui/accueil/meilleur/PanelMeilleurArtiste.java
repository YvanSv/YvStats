package yvstats.affichage.gui.accueil.meilleur;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.MouseEvent;

import yvstats.metier.Artiste;
import yvstats.utils.Couleur;
import yvstats.utils.Polices;

public class PanelMeilleurArtiste extends PanelMeilleur {
    private JLabel lblNbEcoutes;

    public PanelMeilleurArtiste(Artiste a) {
        super(a,"Artiste");

        this.lblNbEcoutes = new JLabel(" écoutes");
        this.lblNbEcoutes.setForeground(Color.WHITE);
        this.lblNbEcoutes.setFont(Polices.arista_pro_light_30);
        this.lblNbEcoutes.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblNbEcoutes.addMouseListener(this);

        this.add(this.lblNbEcoutes);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getSource());
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.lblNom)
            this.lblNom.setForeground(Couleur.VERT);
        if (e.getSource() == this.lblNbEcoutes)
            this.lblNbEcoutes.setForeground(Couleur.VERT);
            
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.lblNom)
            this.lblNom.setForeground(Color.WHITE);
        if (e.getSource() == this.lblNbEcoutes)
            this.lblNbEcoutes.setForeground(Color.WHITE);
    }
}
