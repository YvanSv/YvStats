package yvstats.affichage.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import yvstats.Controleur;
import yvstats.affichage.gui.accueil.PanelAccueil;

public class Frame extends JFrame {
    private JPanel panel;
    private Controleur ctrl;

    public Frame(Controleur ctrl) {
        this.ctrl = ctrl;
        this.panel = new PanelAccueil(this.ctrl);
        this.add(this.panel);
        this.pack();
        Frame.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setTitle("YvStats");
        this.setVisible(true);
        this.toFront();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
