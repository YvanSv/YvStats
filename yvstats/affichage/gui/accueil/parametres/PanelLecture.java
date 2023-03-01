package yvstats.affichage.gui.accueil.parametres;

import javax.swing.JLabel;
import javax.swing.JPanel;

import yvstats.affichage.GUI;
import yvstats.utils.Couleur;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelLecture extends JPanel implements MouseListener {
        private GUI gui;
        private JLabel lblPrecedent;
        private JLabel lblPause;
        private JLabel lblProchain;
        private boolean playing;
    
        public PanelLecture(GUI gui) {
            this.setOpaque(false);

            this.gui = gui;
            this.playing = false;
    
            this.lblPrecedent = new JLabel("⏮  ");
            this.lblPrecedent.setFont(new Font("serif",Font.BOLD,30));
            this.lblPrecedent.setForeground(Color.WHITE);
            this.lblPrecedent.addMouseListener(this);

            this.lblPause = new JLabel("  ⏸  ");
            this.lblPause.setFont(new Font("serif",Font.BOLD,30));
            this.lblPause.setForeground(Color.WHITE);
            this.lblPause.addMouseListener(this);

            this.lblProchain = new JLabel("  ⏭");
            this.lblProchain.setFont(new Font("serif",Font.BOLD,30));
            this.lblProchain.setForeground(Color.WHITE);
            this.lblProchain.addMouseListener(this);

            this.add(this.lblPrecedent);
            this.add(this.lblPause);
            this.add(this.lblProchain);
        }
    
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == this.lblPrecedent) doNothing();
            if (e.getSource() == this.lblPause) {
                if (playing) {
                    this.gui.pause();
                    this.lblPause.setText("  ⏵  ");
                }
                else {
                    this.gui.unpause();
                    this.lblPause.setText("  ⏸  ");
                }
                playing = !playing;
            }
            if (e.getSource() == this.lblProchain) doNothing();
        }
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == this.lblPrecedent) this.lblPrecedent.setForeground(Couleur.VERT);
            if (e.getSource() == this.lblPause) this.lblPause.setForeground(Couleur.VERT);
            if (e.getSource() == this.lblProchain) this.lblProchain.setForeground(Couleur.VERT);
        }
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == this.lblPrecedent) this.lblPrecedent.setForeground(Color.WHITE);
            if (e.getSource() == this.lblPause) this.lblPause.setForeground(Color.WHITE);
            if (e.getSource() == this.lblProchain) this.lblProchain.setForeground(Color.WHITE);
        }
        private void doNothing() {}
}
