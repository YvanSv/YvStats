package yvstats.affichage;

import java.util.ArrayList;

import yvstats.Controleur;
import yvstats.metier.Album;
import yvstats.metier.Artiste;
import yvstats.metier.Musique;
import yvstats.metier.Objet;
import yvstats.utils.Date;
import yvstats.utils.Identifiant;
import yvstats.utils.Lecteur;
import yvstats.utils.MesMaths;
import yvstats.utils.Sauvegarde;

public class TUI extends Affichage {
    public TUI(Controleur ctrl) {
        super(ctrl);
    }

    protected void afficher(String s) {
        System.out.print(s);
    }

    protected char lireChar() {
        String s = this.lireString();
        if (s.length() > 0) return s.charAt(0);
        else return '#';
    }

    protected String lireString() {
        return Lecteur.lire();
    }

    public void lancer() {
        char choix = 'a';
        do {
            this.afficher("\n\n[a] pour ajouter de nouvelles stats;\n");
            this.afficher("[b] pour consulter des stats;\n");
            this.afficher("[c] pour ajouter de nouveaux objets;\n");
            this.afficher("[f] pour afficher les listes;\n");
            this.afficher("[q] pour quitter;\n");
            this.afficher("Choix : ");
            choix = this.lireChar();
            switch (choix) {
                case 'a' : this.miniMenu('a'); break;
                case 'b' : this.miniMenu('b'); break;
                case 'c' : this.miniMenu('c'); break;
                case 'f' : this.miniMenu('f');
            }
        } while(choix != 'q');
    }

    private void miniMenu(char c) {
        char choix;
        do {
            this.afficher("\n\n[a] pour les artistes;\n");
            this.afficher("[b] pour les albums;\n");
            this.afficher("[m] pour les musiques;\n");
            this.afficher("[q] pour quitter ce menu;\n");
            this.afficher("Choix : ");
            choix = this.lireChar();

            switch(c) {
                case 'a' : nstats(choix); break;
                case 'b' : sstats(choix); break;
                case 'c' : nobjets(choix); break;
                case 'f' : aobjets(choix);
            }
        } while (choix != 'q');
    }

    private void nstats(char choix) {
        switch(choix) {
            case 'a' : this.statsObjet(" artiste"); break;
            case 'b' : this.statsObjet(" album"); break;
            case 'm' : this.statsObjet("e musique"); break;
        }
    }

    private void statsObjet(String s) {
        this.afficher("\n\nDonner des stats à un"+s+" :\n");
        ArrayList<Objet> al = this.remplirObjet(s);

        for (int i = 0; i < al.size(); i++)
            this.afficher("\t- ["+i+"] " + al.get(i).getNom() + "\n");
        this.afficher("Choix : ");
        int choix = Integer.parseInt(this.lireString());

        this.afficher("\n\nVous avez choisi " + al.get(choix).getNom() + ", attribuez lui :\nUne date (jj mm aaaa OU x pour ojd + x jours) : ");
        int date = 20230101;
        String[] tab = this.lireString().split(" ");
        try { date = new Date(Integer.parseInt(tab[0]), Integer.parseInt(tab[1]), Integer.parseInt(tab[2])).toInt(); }
        catch(Exception e) { date = new Date(Date.getToday(),Integer.parseInt(tab[0])).toInt(); }

        this.afficher("Un classement : ");
        int classement = Integer.parseInt(this.lireString());

        al.get(choix).setClassement(date,classement);
    }

    private void sstats(char choix) {
        switch(choix) {
            case 'a' : this.showStatsObjet(" artiste"); break;
            case 'b' : this.showStatsObjet(" album"); break;
            case 'm' : this.showStatsObjet("e musique");
        }
    }

    private void showStatsObjet(String s) {
        this.afficher("\n\nAfficher les stats d'un"+s+" :\n");
        ArrayList<Objet> al = this.remplirObjet(s);

        for (int i = 0; i < al.size(); i++)
            this.afficher("\t- ["+i+"] " + al.get(i).getNom() + "\n");
        this.afficher("Choix : ");
        int choix = Integer.parseInt(this.lireString());
        Objet a = al.get(choix);
        this.afficher("\n\nVous avez choisi " + a.getNom() + ", voici ses stats :\n");
        this.afficher(MesMaths.graphe(a));
    }

    private void nobjets(char choix) {
        switch(choix) {
            case 'a' : this.newArtiste(); break;
            case 'b' : this.newAlbum(); break;
            case 'm' : this.newMusique();
        }
    }

    private void newArtiste() {
        ArrayList<Artiste> al = this.ctrl.getArtistes();
        String[] noms;
        this.afficher("\n\nCréer un nouvel artiste :\n");
        this.afficher("[nom1 %% ... %% nomN] : ");
        noms = this.lireString().split(" %% ");
        for (String s : noms) {
            al.add(new Artiste(s,Identifiant.nextID()));
            Sauvegarde.sauvegarder(al.get(al.size()-1));
        }
    }

    private void newAlbum() {
        ArrayList<Album> al = this.ctrl.getAlbums();
        this.afficher("\n\nCréer un nouvel album :\n\n");
        this.afficher("Nom de l'album : ");
        String nomAlbum = this.lireString();

        this.afficher("Nom de l'artiste : ");
        String nomArtiste = this.lireString();
        Artiste a = this.ctrl.getArtisteByName(nomArtiste);
        if (a == null) a = new Artiste(nomAlbum, Identifiant.nextID());
        
        Album alb = new Album(nomAlbum,a,Identifiant.nextID());

        this.afficher("[musique1 %% musique2 %% ... %% musiqueN] : ");
        String[] nomsMusiques = this.lireString().split(" %% ");
        Musique[] ms = new Musique[nomsMusiques.length];
        for (int i = 0; i < ms.length; i++)
            ms[i] = new Musique(nomsMusiques[i],alb,Identifiant.nextID());

        al.add(alb);
        Sauvegarde.sauvegarder(al.get(al.size()-1));

        for (Musique m : ms) {
            this.ctrl.nouveau(a);
            Sauvegarde.sauvegarder(m);
        }
    }

    private void newMusique() {
        ArrayList<Musique> al = this.ctrl.getMusiques();
        String nomM;
        this.afficher("\n\nCréer une nouvelle musique :\n\n");
        this.afficher("Nom de la musique : ");
        nomM = this.lireString();
        this.afficher("Nom de l'artiste : ");
        Artiste a = this.ctrl.getArtisteByName(this.lireString());
        this.afficher("Nom de l'album : ");
        Album b = this.ctrl.getAlbumByNameAndArtiste(this.lireString(),a);
        al.add(new Musique(nomM,b,Identifiant.nextID()));
        Sauvegarde.sauvegarder(al.get(al.size()-1));
    }

    private void aobjets(char choix) {
        switch(choix) {
            case 'a' : this.afficherArtistes(); break;
            case 'b' : this.afficherAlbum(); break;
            case 'm' : this.afficherMusiques();
        }
    }

    private void afficherArtistes() {
        String s = "";
        for (Artiste a : this.ctrl.getArtistes())
            s += "\t - " + a.getNom() + "\n";

        this.afficher(s);
    }

    private void afficherAlbum() {
        String s = "";
        for (Album a : this.ctrl.getAlbums())
            s += "\t - " + a.getNom() + "\n";

        this.afficher(s);
    }

    private void afficherMusiques() {
        String s = "";
        for (Musique m : this.ctrl.getMusiques())
            s += "\t - " + m.getNom() + "\n";

        this.afficher(s);
    }

    private ArrayList<Objet> remplirObjet(String s) {
        ArrayList<Objet> al = new ArrayList<Objet>();
        if (s.equals(" artiste")) for (Objet o : this.ctrl.getArtistes()) al.add(o);
        if (s.equals(" album")) for (Objet o : this.ctrl.getAlbums()) al.add(o);
        if (s.equals("e musique")) for (Objet o : this.ctrl.getMusiques()) al.add(o);
        return al;
    }

    public void majAffichageProgression(int i) {}
}
