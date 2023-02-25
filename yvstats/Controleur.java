package yvstats;

import java.util.ArrayList;

import yvstats.affichage.Affichage;
import yvstats.affichage.GUI;
import yvstats.affichage.TUI;
import yvstats.metier.Album;
import yvstats.metier.Artiste;
import yvstats.metier.Metier;
import yvstats.metier.Musique;
import yvstats.metier.Objet;
import yvstats.utils.Identifiant;

public class Controleur {
    private Affichage affichage;
    private Metier metier;

    public Controleur() {
        this.metier = new Metier();
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

    public Album getAlbumById(Identifiant id) {
        return this.metier.getAlbumById(id);
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

    public Objet[] getMeilleurs() {
        return this.metier.getMeilleurs();
    }
}
