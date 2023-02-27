package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import yvstats.affichage.GUI;
import yvstats.affichage.gui.accueil.classement.PanelClassement;
import yvstats.affichage.gui.accueil.meilleur.PanelLigneMeilleur;
import yvstats.metier.Objet;
import yvstats.utils.Couleur;
import yvstats.utils.PanelImage;

public class PanelCentre extends JPanel {
    private PanelLigneMeilleur pnlMeilleur;
    private JPanel pnlActuel;
    private PanelImage v1;
    private PanelImage v2;

    public PanelCentre(GUI gui) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.v1 = new PanelImage(1,230, PanelImage.VIDE);
        this.v2 = new PanelImage(1,259, PanelImage.VIDE);
        this.pnlMeilleur = new PanelLigneMeilleur(gui);
        this.pnlActuel = this.pnlMeilleur;

        this.add(this.v1);
        this.add(this.pnlActuel);
        this.add(this.v2);
    }

    public void setClassement(ArrayList<Objet> al) {
        this.remove(this.v2);
        this.remove(this.pnlActuel);
        this.remove(this.v1);
        this.pnlActuel = new PanelClassement(al);
        this.add(this.pnlActuel);
    }

    public void setAccueil() {
        this.remove(this.pnlActuel);
        this.pnlActuel = this.pnlMeilleur;
        this.add(this.v1);
        this.add(this.pnlActuel);
        this.add(this.v2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();
        Color color1 = Couleur.NOIR_16;
        Color color2 = Couleur.NOIR_5;
        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
