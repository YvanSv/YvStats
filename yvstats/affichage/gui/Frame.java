package yvstats.affichage.gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import yvstats.affichage.GUI;
import yvstats.affichage.gui.accueil.PanelDroit;
import yvstats.affichage.gui.accueil.PanelGauche;
import yvstats.metier.Objet;
import yvstats.utils.Couleur;

public class Frame extends JFrame {
    public static int height = 0;
    public static int width = 0;
    private PanelDroit pnlDroit;

    public Frame(GUI gui) {
        this.setTitle("YvStats");
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        this.getContentPane().setBackground(Couleur.NOIR_12);
        Frame.setDefaultLookAndFeelDecorated(true);

        this.add(new PanelGauche(gui));
        this.pnlDroit = new PanelDroit(gui);
        this.add(this.pnlDroit);

        this.setVisible(true);
        this.pack();
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.toFront();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void setTaille() {
        this.pnlDroit.setTaille();
        Frame.height = this.getHeight();
        Frame.width = this.getWidth();
    }

    public void setClassement(ArrayList<Objet> al) {
        this.pnlDroit.setClassement(al);
        this.refresh();
    }

    public void setAccueil() {
        this.pnlDroit.setAccueil();
        this.refresh();
    }

    public void refresh() {
        this.invalidate();
        this.validate();
        this.repaint();
    }
}
