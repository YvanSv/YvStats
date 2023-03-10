package yvstats;

import java.util.ArrayList;

import yvstats.affichage.Affichage;
import yvstats.affichage.GUI;
import yvstats.affichage.TUI;
import yvstats.metier.Album;
import yvstats.metier.Artiste;
import yvstats.metier.Audio;
import yvstats.metier.Metier;
import yvstats.metier.Musique;
import yvstats.metier.Objet;
import yvstats.utils.Identifiant;

public class Controleur {
    private Affichage affichage;
    private Metier metier;
    private Audio audio;

    public Controleur() {
        this.metier = new Metier();
        // this.audio = new Audio(this);
    }

    public void lancer(int tuigui) {
        switch (tuigui) {
            case 1 : this.affichage = new TUI(this); break;
            case 2 : this.affichage = new GUI(this);
        }
        this.affichage.lancer();
    }

    public void nouveau(Objet o) {
        this.metier.ajouter(o);
    }

    public Artiste getArtisteById(Identifiant id) {
        return this.metier.getArtisteById(id);
    }

    public Artiste getArtisteByName(String name) {
        return this.metier.getArtisteByName(name);
    }

    public Album getAlbumByNameAndArtiste(String name, Artiste a) {
        return this.metier.getAlbumByNameAndArtiste(name,a);
    }

    public Album getAlbumById(Identifiant id) {
        return this.metier.getAlbumById(id);
    }

    public Musique getMusiqueById(Identifiant id) {
        return this.metier.getMusiqueById(id);
    }

    public ArrayList<Artiste> getArtistes() {
        return this.metier.getArtistes();
    }

    public ArrayList<Album> getAlbums() {
        return this.metier.getAlbums();
    }

    public ArrayList<Musique> getMusiques() {
        return this.metier.getMusiques();
    }

    public Artiste getMeilleurArtiste() {
        return this.metier.getMeilleurArtiste();
    }
    public Album getMeilleurAlbum() {
        return this.metier.getMeilleurAlbum();
    }
    public Musique getMeilleurMusique() {
        return this.metier.getMeilleurMusique();
    }

    public void play(String s) {
        if (this.audio != null) this.audio.arreter();
        this.audio = new Audio(this);
        this.audio.setLink(s);
        this.audio.start();
    }

    public void setVolume(float vol) {
        if (this.audio != null) this.audio.setVolume(vol);
    }

    public void majAffichageProgression(int i) {
        this.affichage.majAffichageProgression(i);
    }

    public void pause() {
        if (this.audio != null) this.audio.pause();
    }

    public void unpause() {
        if (this.audio != null) this.audio.unpause();
    }

    public void setTime(int i) {
        if (this.audio != null) this.audio.setTime(i);
    }
}
