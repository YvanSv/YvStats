package yvstats.metier;

import java.util.ArrayList;

import yvstats.utils.Identifiant;

public class Album  extends Objet {
    private Artiste artiste;
    private ArrayList<Musique> musiques;

    public Album(String nom, Artiste a, Identifiant id) {
        super(nom, id);
        this.artiste = a;
        this.artiste.ajouterAlbum(this);
        this.musiques = new ArrayList<Musique>();
    }

    public void ajouterMusiques(Musique... ms) {
        for (Musique m : ms) {
            this.musiques.add(m);
            m.setAlbum(this);
        }
    }

    public void retirerMusiques(Musique... ms) {
        for (Musique m : ms) {
            m.setAlbum(null);
            this.musiques.remove(m);
        }
    }

    public Artiste getArtiste() {
        return this.artiste;
    }

    public String getLinkToPlay() {
        return this.musiques.get(0).getLinkToPlay();
    }

    public String toString() {
        return this.id + " ##### " + this.nom + " ##### " + this.artiste.getId();
    }
}
