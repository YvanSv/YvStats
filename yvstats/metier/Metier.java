package yvstats.metier;

import java.util.ArrayList;

import yvstats.utils.Date;
import yvstats.utils.Identifiant;
import yvstats.utils.Sauvegarde;

public class Metier {
    private ArrayList<Artiste> artistes;
    private ArrayList<Album> albums;
    private ArrayList<Musique> musiques;

    public Metier() {
        this.artistes = new ArrayList<Artiste>();
        this.albums = new ArrayList<Album>();
        this.musiques = new ArrayList<Musique>();
    }

    public void ajouter(Objet o) {
        if (o instanceof Artiste) this.artistes.add((Artiste) o);
        if (o instanceof Album) this.albums.add((Album) o);
        if (o instanceof Musique) this.musiques.add((Musique) o);
    }

    public Artiste getArtisteById(Identifiant id) {
        for (Artiste a : this.artistes)
            if (a.getId().equals(id)) {
                return a;
            }
        return null;
    }

    public Album getAlbumById(Identifiant id) {
        for (Album a : this.albums)
            if (a.getId().equals(id)) {
                return a;
            }
        return null;
    }

    public Artiste getArtisteByName(String nom) {
        for (Artiste a : this.artistes)
            if (a.getNom().equals(nom)) return a;
        
        Artiste a = new Artiste(nom,Identifiant.newId());
        this.artistes.add(a);
        Sauvegarde.sauvegarder(this.artistes.get(this.artistes.size()-1));
        return a;
    }

    public ArrayList<Artiste> getArtistes() {
        return this.artistes;
    }

    public ArrayList<Album> getAlbums() {
        return this.albums;
    }

    public ArrayList<Musique> getMusiques() {
        return this.musiques;
    }

    public Objet[] getMeilleurs() {
        Objet[] meilleurs = new Objet[3];

        for (Artiste a : this.artistes)
            if (a.getClassementLe(Date.getToday().toInt()) == 1) {
                meilleurs[0] = a;
                break;
            }
        for (Album a : this.albums)
            if (a.getClassementLe(Date.getToday().toInt()) == 1) {
                meilleurs[1] = a;
                break;
            }
        for (Musique a : this.musiques)
            if (a.getClassementLe(Date.getToday().toInt()) == 1) {
                meilleurs[2] = a;
                break;
            }

        return meilleurs;
    }
}
