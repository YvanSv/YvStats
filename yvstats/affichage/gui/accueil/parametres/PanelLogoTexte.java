package yvstats.affichage.gui.accueil.parametres;

import javax.swing.JLabel;
import javax.swing.JPanel;

import yvstats.utils.Polices;

import java.awt.Color;
import java.awt.Font;

public class PanelLogoTexte extends JPanel {
    public JLabel lblLogo;
    public JLabel lblTexte;

    public PanelLogoTexte(String logo, String texte) {
        this.setOpaque(false);

        this.lblLogo = new JLabel(logo);
        this.lblLogo.setFont(new Font("serif",Font.BOLD,27));
        this.lblLogo.setForeground(Color.WHITE);

        this.lblTexte = new JLabel(texte);
        this.lblTexte.setFont(Polices.arista_pro_light_titre);
        this.lblTexte.setForeground(Color.WHITE);

        this.add(this.lblLogo);
        this.add(this.lblTexte);
    }
}
