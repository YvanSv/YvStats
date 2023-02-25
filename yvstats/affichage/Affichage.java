package yvstats.affichage;

import yvstats.Controleur;

public abstract class Affichage {
    protected Controleur ctrl;
    public Affichage(Controleur ctrl) {
        this.ctrl = ctrl;
    }

    public abstract void lancer();
}