package yvstats.affichage.gui.accueil;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicSliderUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Image;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.geom.RoundRectangle2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.io.File;

import yvstats.affichage.GUI;
import yvstats.affichage.gui.accueil.parametres.PanelLecture;
import yvstats.affichage.gui.accueil.parametres.PanelParametres;
import yvstats.metier.Musique;
import yvstats.affichage.gui.accueil.parametres.PanelLogoTexte;
import yvstats.utils.Couleur;
import yvstats.utils.PanelLabel;
import yvstats.utils.PanelImage;
import yvstats.utils.Polices;

public class PanelGauche extends JPanel implements MouseListener {
    private static final int PROG_MIN = 0, PROG_MAX = 600, PROG_INIT = 0;
    private GUI gui;
    private PanelLogoTexte pnlRetourAccueil;
    private PanelLogoTexte pnlRechercher;
    private PanelLabel pnlTitreSon;
    private PanelLabel pnlNomArtiste;
    private JLabel imgLecture;
    private JSlider sldProgressionLecture;
    private JMenuBar mbar;

    public PanelGauche(GUI gui) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.gui = gui;

        this.setOpaque(true);
        this.setBackground(Couleur.NOIR_12);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.mbar = new JMenuBar();
        this.mbar.setBorderPainted(false);
        this.mbar.setOpaque(false);

        JMenu menu = new JMenu("H");
        menu.setFont(Polices.arista_pro_icons_light);
        menu.setForeground(Color.WHITE);
        menu.setOpaque(false);

        this.mbar.add(menu);

        this.pnlRetourAccueil = new PanelLogoTexte("🏡"," Revenir à l'acceuil");
        this.pnlRetourAccueil.lblLogo.addMouseListener(this);
        this.pnlRetourAccueil.lblTexte.addMouseListener(this);

        this.pnlRechercher = new PanelLogoTexte("🔎"," Rechercher");
        this.pnlRechercher.lblLogo.addMouseListener(this);
        this.pnlRechercher.lblTexte.addMouseListener(this);

        this.pnlTitreSon = new PanelLabel("Inconnu",Polices.T27);
        this.pnlTitreSon.lbl.addMouseListener(this);

        this.pnlNomArtiste = new PanelLabel("Inconnu",Polices.T20);
        this.pnlNomArtiste.lbl.addMouseListener(this);

        this.imgLecture = new JLabel(new ImageIcon(new ImageIcon("../ressources/img/Inconnu.png").getImage().getScaledInstance(330, 330, Image.SCALE_DEFAULT)));
        this.imgLecture.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.sldProgressionLecture = new JSlider(JSlider.HORIZONTAL, PROG_MIN, PROG_MAX, PROG_INIT);
        this.sldProgressionLecture.setUI(new CustomSliderUI(this.sldProgressionLecture));
        this.sldProgressionLecture.addMouseListener(this);
        this.sldProgressionLecture.setOpaque(false);

        this.add(new PanelImage(368, 8, PanelImage.VIDE));
        this.add(this.mbar);
        this.add(this.pnlRetourAccueil);
        this.add(this.pnlRechercher);
        this.add(new PanelImage(1, 304, PanelImage.VIDE));
        this.add(this.pnlTitreSon);
        this.add(this.pnlNomArtiste);
        this.add(this.imgLecture);
        this.add(new PanelImage(1, 20, PanelImage.VIDE));
        this.add(this.sldProgressionLecture);
        this.add(new PanelImage(1, 10, PanelImage.VIDE));
        this.add(new PanelLecture(gui));
        this.add(new PanelImage(1, 30, PanelImage.VIDE));
        this.add(new PanelParametres(gui));
        this.add(new PanelImage(1, 10, PanelImage.VIDE));
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.pnlRetourAccueil.lblLogo || e.getSource() == this.pnlRetourAccueil.lblTexte) this.gui.setAccueil();
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == this.sldProgressionLecture) {
            this.gui.setTime(this.sldProgressionLecture.getValue());
        }
    }
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.pnlRetourAccueil.lblLogo || e.getSource() == this.pnlRetourAccueil.lblTexte) {
            this.pnlRetourAccueil.lblLogo.setForeground(Couleur.VERT);
            this.pnlRetourAccueil.lblTexte.setForeground(Couleur.VERT);
        }
        else if (e.getSource() == this.pnlRechercher.lblLogo || e.getSource() == this.pnlRechercher.lblTexte) {
            this.pnlRechercher.lblLogo.setForeground(Couleur.VERT);
            this.pnlRechercher.lblTexte.setForeground(Couleur.VERT);
        }
        else if (e.getSource() == this.pnlTitreSon.lbl) this.pnlTitreSon.lbl.setForeground(Couleur.VERT);
        else if (e.getSource() == this.pnlNomArtiste.lbl) this.pnlNomArtiste.lbl.setForeground(Couleur.VERT);
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.pnlRetourAccueil.lblLogo || e.getSource() == this.pnlRetourAccueil.lblTexte) {
            this.pnlRetourAccueil.lblLogo.setForeground(Color.WHITE);
            this.pnlRetourAccueil.lblTexte.setForeground(Color.WHITE);
        }
        else if (e.getSource() == this.pnlRechercher.lblLogo || e.getSource() == this.pnlRechercher.lblTexte) {
            this.pnlRechercher.lblLogo.setForeground(Color.WHITE);
            this.pnlRechercher.lblTexte.setForeground(Color.WHITE);
        }
        else if (e.getSource() == this.pnlTitreSon.lbl) this.pnlTitreSon.lbl.setForeground(Color.WHITE);
        else if (e.getSource() == this.pnlNomArtiste.lbl) this.pnlNomArtiste.lbl.setForeground(Color.WHITE);
    }

    public void playing(Musique m) {
        this.pnlNomArtiste.lbl.setText(m.getArtiste().getNom());
        this.pnlTitreSon.lbl.setText(m.getNom());
        String link = "../ressources/img/"+m.getId()+".jpg";
        File f = new File("../ressources/img/"+m.getId()+".jpg");
        if (!f.exists()) link = "../ressources/img/Inconnu.png";
        this.imgLecture.setIcon(new ImageIcon(new ImageIcon(link).getImage().getScaledInstance(330, 330, Image.SCALE_DEFAULT)));
    }

    public void majAffichageProgression(int i) {
        this.sldProgressionLecture.setValue(i);
    }
    private static class CustomSliderUI extends BasicSliderUI {
        private static final int TRACK_HEIGHT = 8;
        private static final int TRACK_ARC = 5;
        private static final Dimension THUMB_SIZE = new Dimension(20, 20);
        private final RoundRectangle2D.Float trackShape = new RoundRectangle2D.Float();

        public CustomSliderUI(final JSlider b) {
            super(b);
        }

        @Override
        protected void calculateTrackRect() {
            super.calculateTrackRect();
            trackRect.y = trackRect.y + (trackRect.height - TRACK_HEIGHT) / 2;
            trackRect.height = TRACK_HEIGHT;
            trackShape.setRoundRect(trackRect.x, trackRect.y, trackRect.width, trackRect.height, TRACK_ARC, TRACK_ARC);
        }

        @Override
        protected void calculateThumbLocation() {
            super.calculateThumbLocation();
            thumbRect.y = trackRect.y + (trackRect.height - thumbRect.height) / 2;
        }

        @Override
        protected Dimension getThumbSize() {
            return THUMB_SIZE;
        }

        @Override
        public void paint(final Graphics g, final JComponent c) {
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            super.paint(g, c);
        }

        @Override
        public void paintTrack(final Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            Shape clip = g2.getClip();

            // Paint shadow.
            g2.setColor(Couleur.GRIS_CLAIR);
            g2.fill(trackShape);

            // Paint track background.
            g2.setColor(Couleur.GRIS_CLAIR);
            g2.setClip(trackShape);
            trackShape.y += 1;
            g2.fill(trackShape);
            trackShape.y = trackRect.y;

            g2.setClip(clip);

            int thumbPos = thumbRect.x + thumbRect.width / 2;
            g2.clipRect(0, 0, thumbPos, slider.getHeight());
            g2.setColor(Couleur.VERT);
            g2.fill(trackShape);
            g2.setClip(clip);
        }

        @Override
        public void paintThumb(final Graphics g) {
            g.setColor(null);
            g.fillOval(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
        }

        @Override
        public void paintFocus(final Graphics g) {}
    }
}
