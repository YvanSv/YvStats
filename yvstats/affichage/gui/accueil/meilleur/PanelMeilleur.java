package yvstats.affichage.gui.accueil.meilleur;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.io.File;
import java.awt.event.MouseEvent;

import yvstats.metier.Objet;
import yvstats.utils.PanelImage;
import yvstats.utils.Polices;

public abstract class PanelMeilleur extends JPanel implements MouseListener{
    protected JLabel lblTitre;
    protected JLabel img;
    protected JLabel lblNom;
    protected JLabel lblNomArtiste;

    public PanelMeilleur(Objet a, String type) {
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        String nom = "Inconnu";
        if (a != null)
            nom = a.getNom();

        this.lblTitre = new JLabel(type+" préféré");
        File f = new File("../ressources/img/"+nom+".png");
        String link;
        if (!f.exists()) link = "../ressources/img/Inconnu.png";
        else link = "../ressources/img/"+nom+".png";
        this.img = new JLabel(new ImageIcon(link));
        this.lblNom = new JLabel(nom);
        this.lblTitre.setForeground(Color.WHITE);
        this.lblNom.setForeground(Color.WHITE);
        this.lblTitre.setFont(Polices.arista_pro_light_titre);
        this.lblNom.setFont(Polices.arista_pro_light);
        this.lblTitre.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.img.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblNom.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.lblNom.addMouseListener(this);

        this.add(this.lblTitre);
        this.add(new PanelImage(1, 100, PanelImage.VIDE));
        this.add(this.img);
        this.add(new PanelImage(1, 10, PanelImage.VIDE));
        this.add(this.lblNom);

        if (!type.equals("Artiste")) {
            String nomArtiste = "Inconnu";
            if (a != null)
                if (a.getArtiste() != null)
                    nomArtiste = a.getArtiste().getNom();
            this.lblNomArtiste = new JLabel(nomArtiste);
            this.lblNomArtiste.setForeground(Color.WHITE);
            this.lblNomArtiste.setFont(Polices.arista_pro_light_30);
            this.lblNomArtiste.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.lblNomArtiste.addMouseListener(this);
            this.add(this.lblNomArtiste);
        }
    }

    public abstract void mouseClicked(MouseEvent e);
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public abstract void mouseEntered(MouseEvent e);
    public abstract void mouseExited(MouseEvent e);
}
