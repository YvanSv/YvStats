package yvstats.metier;

import java.util.ArrayList;
import java.util.HashMap;

import yvstats.utils.Date;
import yvstats.utils.Identifiant;
import yvstats.utils.Sauvegarde;

public abstract class Objet {
    protected Identifiant id;
    protected String nom;
    protected HashMap<Integer,Integer> classement;
    protected ArrayList<Ecoute> listeEcoutes;

    public Objet(String nom, Identifiant id) {
        this.nom = nom;
        this.id = id;
        this.classement = new HashMap<Integer,Integer>();
        this.listeEcoutes = new ArrayList<Ecoute>();
    }

    public Identifiant getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setClassement(int date, int place) {
        this.classement.put(date, place);
        Sauvegarde.serialiser(this.id, this.classement);
    }

    public void setClassement(HashMap<Integer,Integer> hm) {
        this.classement = hm;
    }

    public int getMeilleurePlace() {
        int meilleur = -1;
        for(Integer i : this.classement.values())
            if (meilleur == -1) meilleur = i;
            else if (i < meilleur) meilleur = i;

        return meilleur;
    }

    public int getPirePlace() {
        int pire = -1;
        for(Integer i : this.classement.values())
            if (pire == -1) pire = i;
            else if (i > pire) pire = i;

        return pire;
    }

    public int getClassementLe(int d) {
        int x = 0;
        try { x = this.classement.get(d); }
        catch(Exception e) {}
        return x;
    }

    public String getListeClassement() {
        String s = "Liste des classements de " + this.nom + " : \n";

        for(Integer i : this.classement.values())
            s += "\t-" + i + "\n";

        return s;
    }

    public int getNbEcoute() {
        return this.listeEcoutes.size();
    }

    public int getNbEcouteApres(Date d) {
        int nb = 0;

        for (Ecoute e : this.listeEcoutes)
            if (e.getDate().compareTo(d) > 1)
                nb++;

        return nb;
    }

    public void nouvelleEcoute(Ecoute e) {
        this.listeEcoutes.add(e);
    }

    public ArrayList<Ecoute> getEcoutes() {
        return this.listeEcoutes;
    }

    public abstract String getLinkToPlay();

    public abstract Artiste getArtiste();
    public abstract String toString();
}
