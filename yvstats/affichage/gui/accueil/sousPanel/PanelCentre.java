package yvstats.affichage.gui.accueil.sousPanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import yvstats.Controleur;

public class PanelCentre extends JPanel {
    public PanelCentre(Controleur ctrl) {
        this.setBackground(new Color(10,10,10));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        this.add(new PanelLigneVide(1,200));
        this.add(new PanelLigneTitre());
        this.add(new PanelLigneVide(1,75));
        this.add(new PanelLigneMeilleur(ctrl));
        this.add(new PanelLigneVide(1,300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth(), h = getHeight();
        Color color1 = new Color(10,10,10);
        Color color2 = new Color(5,5,5);
        GradientPaint gp = new GradientPaint(0, 0, color1, w, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
