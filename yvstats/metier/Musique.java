package yvstats.metier;

import yvstats.utils.Date;
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

    public void nouvelleEcoute(Date d) {
        Ecoute e = new Ecoute(d);
        this.listeEcoutes.add(e);
        this.album.nouvelleEcoute(e);
        this.artiste.nouvelleEcoute(e);
    }

    public String getLinkToPlay() {
        return this.id.toString()+"_"+this.nom;
    }

    public String toString() {
        return this.id + " ##### " + this.nom + " ##### " + this.album.getId();
    }
}