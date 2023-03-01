package yvstats.affichage.gui.accueil.classement;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import yvstats.affichage.GUI;
import yvstats.metier.Album;
import yvstats.metier.Musique;
import yvstats.metier.Objet;
import yvstats.utils.Couleur;
import yvstats.utils.Date;
import yvstats.utils.PanelLabel;
import yvstats.utils.PanelImage;
import yvstats.utils.Polices;

public class PanelLigne extends JPanel implements MouseListener {
    private GUI gui;
    private JLabel lblPlay;
    // private PanelLabel lblNom;
    private Objet o;
    private JLabel lblSupplement;

    public PanelLigne(GUI gui, Objet o, int indice) {
        this.gui = gui;
        this.o = o;

        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        this.lblPlay = new JLabel("  ⏵");
        this.lblPlay.setFont(new Font("serif",Font.BOLD,27));
        this.lblPlay.setForeground(Color.WHITE);
        this.lblPlay.addMouseListener(this);

        // this.lblNom = new PanelLabel(o.getNom(),Polices.T27);

        JLabel lblIndice = new JLabel(indice+"  ");
        lblIndice.setForeground(Color.WHITE);
        lblIndice.setFont(new Font("serif",Font.BOLD,27));

        this.lblSupplement = new JLabel();
        if (o instanceof Musique)
            this.lblSupplement.setText(o.getArtiste().getNom() + " ("+o.getArtiste().getClassementLe(Date.getToday().toInt())+")");
        else if (o instanceof Album)
            this.lblSupplement.setText(o.getArtiste().getNom() + " ("+o.getArtiste().getClassementLe(Date.getToday().toInt())+")");

        this.add(new PanelImage(30, 20, PanelImage.VIDE));
        this.add(lblIndice);
        this.add(this.lblPlay);
        // this.add(this.lblNom);
        this.add(new PanelLabel(o.getNom(),Polices.T27));
        // this.add(new PanelImage(30, 20, PanelImage.VIDE));
    }
    
    public void mouseClicked(MouseEvent e) {
        this.gui.play(this.o.getLinkToPlay());
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.lblPlay) this.lblPlay.setForeground(Couleur.VERT);
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.lblPlay) this.lblPlay.setForeground(Color.WHITE);
    }
}

