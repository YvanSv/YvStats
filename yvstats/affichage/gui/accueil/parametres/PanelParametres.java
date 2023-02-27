package yvstats.affichage.gui.accueil.parametres;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicSliderUI;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import yvstats.utils.Couleur;
import yvstats.utils.PanelLabel;

public class PanelParametres extends JPanel implements ChangeListener,MouseListener {
    private static final int SON_MIN = 0, SON_MAX = 100, SON_INIT = 50;
    private PanelLabel pnlRoue;
    private JLabel lblSon;
    private JSlider sldSon;
    private boolean muted;

    public PanelParametres() {
        this.setOpaque(false);

        this.muted = false;

        this.pnlRoue = new PanelLabel("⚙  ", new Font("serif",Font.BOLD,30));
        this.pnlRoue.lbl.addMouseListener(this);

        this.sldSon = new JSlider(JSlider.HORIZONTAL, SON_MIN, SON_MAX, SON_INIT);
        this.sldSon.setUI(new CustomSliderUI(this.sldSon));
        this.sldSon.addChangeListener(this);
        this.sldSon.setOpaque(false);

        this.lblSon = new JLabel("  🔉");
        this.lblSon.setFont(new Font("serif",Font.BOLD,30));
        this.lblSon.setForeground(Color.WHITE);
        this.lblSon.addMouseListener(this);

        this.add(this.pnlRoue);
        this.add(this.lblSon);
        this.add(this.sldSon);
    }

    public void stateChanged(ChangeEvent e) {
        if (this.sldSon.getValue() < 1) this.lblSon.setText("  🔇");
        else if (this.sldSon.getValue() < 51) this.lblSon.setText("  🔉");
        else this.lblSon.setText("  🔊");
        this.muted = false;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.lblSon) {
            if (this.muted)
                if (this.sldSon.getValue() < 1) doNothing();
                else if (this.sldSon.getValue() < 51) this.lblSon.setText("  🔉");
                else this.lblSon.setText("  🔊");
            else this.lblSon.setText("  🔇");
            this.muted = !this.muted;
        }
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.lblSon) this.lblSon.setForeground(Couleur.VERT);
        if (e.getSource() == this.pnlRoue.lbl) this.pnlRoue.lbl.setForeground(Couleur.VERT);
    }
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.lblSon) this.lblSon.setForeground(Color.WHITE);
        if (e.getSource() == this.pnlRoue.lbl) this.pnlRoue.lbl.setForeground(Color.WHITE);
    }
    private void doNothing() {}

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