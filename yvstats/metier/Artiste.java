package yvstats.metier;

import java.util.ArrayList;

import yvstats.utils.Identifiant;

public class Artiste extends Objet {
    private ArrayList<Album> albums;

    public Artiste(String nom, Identifiant id) {
        super(nom, id);
    }

    public void ajouterAlbum(Album a) {
        this.albums.add(a);
    }

    public void supprimerAlbum(Album a) {
        this.albums.remove(a);
    }

    public String toString() {
        return this.id + " ##### " + this.nom;
    }

    public Artiste getArtiste() {
        return this;
    }
}
