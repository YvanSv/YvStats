package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import yvstats.Controleur;
import yvstats.affichage.gui.accueil.meilleur.PanelLigneMeilleur;
import yvstats.utils.Couleur;
import yvstats.utils.PanelVide;

public class PanelCentre extends JPanel {
    public PanelCentre(Controleur ctrl) {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.add(new PanelVide(1,230));
        this.add(new PanelLigneMeilleur(ctrl));
        this.add(new PanelVide(1,259));
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
