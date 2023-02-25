package yvstats.affichage;

import yvstats.Controleur;
import yvstats.affichage.gui.Frame;

public class GUI extends Affichage{
    public GUI(Controleur ctrl) {
        super(ctrl);
    }

    public void lancer() {
        new Frame(this.ctrl);
    }

    public void afficher(String s) {
        throw new UnsupportedOperationException("Unimplemented method 'afficher'");
    }

    public char lireChar() {
        throw new UnsupportedOperationException("Unimplemented method 'lireChar'");
    }

    public String lireString() {
        throw new UnsupportedOperationException("Unimplemented method 'lireString'");
    }
}
