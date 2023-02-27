package yvstats.metier;

import java.util.ArrayList;

import yvstats.utils.Identifiant;

public class Album  extends Objet {
    private Artiste artiste;
    private ArrayList<Musique> musiques;

    public Album(String nom, Artiste artiste, Musique[] musiques, Identifiant id) {
        super(nom, id);
        this.artiste = artiste;
        this.musiques = new ArrayList<Musique>();
        if (musiques != null)
            for (Musique m : musiques) {
                this.musiques.add(m);
                m.setAlbum(this);
            }
        this.artiste.ajouterAlbum(this);
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
