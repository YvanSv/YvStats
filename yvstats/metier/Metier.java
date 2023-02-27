package yvstats.metier;

import java.util.ArrayList;

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

    public Musique getMusiqueById(Identifiant id) {
        for (Musique a : this.musiques)
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

    public Artiste getMeilleurArtiste() {
        Artiste m = null;
        for (Artiste a : this.artistes)
            if (m == null) m = a;
            else if (a.getNbEcoute() > m.getNbEcoute())
                m = a;
    return m;
    }

    public Album getMeilleurAlbum() {
        Album m = null;
        for (Album a : this.albums)
            if (m == null) m = a;
            else if (a.getNbEcoute() > m.getNbEcoute())
                m = a;
        return m;
    }

    public Musique getMeilleurMusique() {
        Musique m = null;
        for (Musique a : this.musiques)
            if (m == null) m = a;
            else if (a.getNbEcoute() > m.getNbEcoute())
                m = a;
        return m;
    }
}
