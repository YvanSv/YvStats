package yvstats.affichage;

import java.util.ArrayList;

import yvstats.Controleur;
import yvstats.affichage.gui.Frame;
import yvstats.metier.Album;
import yvstats.metier.Artiste;
import yvstats.metier.Musique;
import yvstats.metier.Objet;

public class GUI extends Affichage{
    private Frame frm;
    public GUI(Controleur ctrl) {
        super(ctrl);
    }

    public void lancer() {
        this.frm = new Frame(this);
        this.frm.setTaille();
    }

    public void setClassementArtiste() {
        ArrayList<Artiste> al = this.ctrl.getArtistes();
        ArrayList<Objet> tmp = new ArrayList<>();
        for (Object o : al)
            tmp.add((Objet) o);
        this.frm.setClassement(tmp);
    }

    public void setClassementAlbums() {
        ArrayList<Album> al = this.ctrl.getAlbums();
        ArrayList<Objet> tmp = new ArrayList<>();
        for (Object o : al)
            tmp.add((Objet) o);
        this.frm.setClassement(tmp);
    }

    public void setClassementMusiques() {
        ArrayList<Musique> al = this.ctrl.getMusiques();
        ArrayList<Objet> tmp = new ArrayList<>();
        for (Object o : al)
            tmp.add((Objet) o);
        this.frm.setClassement(tmp);
    }

    public void setAccueil() { this.frm.setAccueil(); }
    public void refresh() { this.frm.refresh(); }

    public Artiste getMeilleurArtiste() { return this.ctrl.getMeilleurArtiste(); }
    public Album getMeilleurAlbum() { return this.ctrl.getMeilleurAlbum(); }
    public Musique getMeilleurMusique() { return this.ctrl.getMeilleurMusique(); }
}
