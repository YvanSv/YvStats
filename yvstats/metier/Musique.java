package yvstats.metier;

import yvstats.utils.Identifiant;

public class Musique extends Objet {
    private Album album;
    private Artiste artiste;

    public Musique(String nom, Artiste artiste, Identifiant id) {
        super(nom,id);
        this.artiste = artiste;
    }

    public void setAlbum(Album a) {
        this.album = a;
    }

    public Album getAlbum() {
        return this.album;
    }

    public Artiste getArtiste() {
        return this.artiste;
    }

    public String toString() {
        return this.id + " %}`/!§ " + this.nom + " %}`/!§ " + this.album.getId();
    }
}