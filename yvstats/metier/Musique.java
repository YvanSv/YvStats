package yvstats.metier;

import yvstats.utils.Date;
import yvstats.utils.Identifiant;

public class Musique extends Objet {
    private Album album;

    public Musique(String nom, Album a, Identifiant id) {
        super(nom,id);
        this.album = a;
        this.album.ajouterMusiques(this);
    }

    public void setAlbum(Album a) {
        this.album = a;
    }

    public Album getAlbum() {
        return this.album;
    }

    public Artiste getArtiste() {
        return this.album.getArtiste();
    }

    public void nouvelleEcoute(Date d) {
        Ecoute e = new Ecoute(d);
        this.listeEcoutes.add(e);
        this.album.nouvelleEcoute(e);
        this.album.getArtiste().nouvelleEcoute(e);
    }

    public String getLinkToPlay() {
        return this.id.toString()+"_"+this.nom;
    }

    public String toString() {
        return this.id + " ##### " + this.nom + " ##### " + this.album.getId();
    }
}