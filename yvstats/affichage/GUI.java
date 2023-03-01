package yvstats.affichage;

import java.util.ArrayList;

import yvstats.Controleur;
import yvstats.affichage.gui.Frame;
import yvstats.metier.Album;
import yvstats.metier.Artiste;
import yvstats.metier.Musique;
import yvstats.metier.Objet;
import yvstats.utils.Identifiant;

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

    public void play(String s) {
        this.ctrl.play(s);
        this.frm.playing(this.ctrl.getMusiqueById(Identifiant.creerIdentifiant(s.split("_")[0])));
    }

    public void setVolume(float vol) {
        this.ctrl.setVolume(vol);
    }

    public void majAffichageProgression(int i) {
        this.frm.majAffichageProgression(i);
    }

    public void pause() {
        this.ctrl.pause();
    }

    public void unpause() {
        this.ctrl.unpause();
    }

    public void setTime(int i) {
        this.ctrl.setTime(i);
    }
}
