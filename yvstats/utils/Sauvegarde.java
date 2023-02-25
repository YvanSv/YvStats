package yvstats.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import yvstats.Controleur;
import yvstats.metier.Album;
import yvstats.metier.Artiste;
import yvstats.metier.Musique;
import yvstats.metier.Objet;

public class Sauvegarde {

    public static void sauvegarder(Objet a) {
        String link = "../ressources/", existants = "";
        if (a instanceof Artiste) link += "artistes.data";
        if (a instanceof Album) link += "albums.data";
        if (a instanceof Musique) link += "musiques.data";

        try {
            Scanner sc = new Scanner(new File(link));
            while (sc.hasNextLine()) existants += sc.nextLine() + "\n";
            sc.close();

            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(link)));
            pw.println(existants + a.toString());
            pw.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static void chargerObj(String s, Controleur ctrl) {
        try {
            System.out.println("Loading "+s+" datas... ");
            Scanner sc = new Scanner(new File("../ressources/"+s+".data"));
            while (sc.hasNextLine()) {
                String[] ts = sc.nextLine().split(" ##### ");
                Objet a = null;
                switch (s) {
                    case "artistes" : a = new Artiste(ts[1], Identifiant.creerIdentifiant(ts[0])); break;
                    case "albums" : a = new Album(ts[1], ctrl.getArtisteById(Identifiant.creerIdentifiant(ts[2])), null, Identifiant.creerIdentifiant(ts[0])); break;
                    case "musiques" : a = new Musique(ts[1], ctrl.getArtisteById(Identifiant.creerIdentifiant(ts[2])), Identifiant.creerIdentifiant(ts[0]));
                }
                Identifiant.newId();
                a.setClassement(Sauvegarde.deserialiser(ts[0]));
                ctrl.nouveau(a);
            }
            System.out.println("done\n");
        } catch (Exception e) {System.out.println("erreur : "); e.printStackTrace();}
    }

    public static void charger(Controleur ctrl) {
        Sauvegarde.chargerObj("artistes",ctrl);
        Sauvegarde.chargerObj("albums",ctrl);
        Sauvegarde.chargerObj("musiques",ctrl);
    }

    public static void serialiser(Identifiant id, HashMap<Integer,Integer> hm) {
        String link = "../ressources/classements/"+id.toString()+".ser";
        try {
            String s = "";
            for (Map.Entry<Integer, Integer> entry : hm.entrySet())
                s += entry.getKey() + " ##### " + entry.getValue() + "\n";

            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(link)));
            pw.println(s);
            pw.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static HashMap<Integer,Integer> deserialiser(String id) {
        System.out.print("Loading "+id+" datas... ");
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        try {
            File f = new File("../ressources/classements/"+id+".ser");
            if (!f.exists()) f.createNewFile();
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] ts = sc.nextLine().split(" ##### ");
                if (ts.length > 1) hm.put(Integer.parseInt(ts[0]), Integer.parseInt(ts[1]));
            }
            System.out.println("done");
            sc.close();
        } catch (Exception e) { e.printStackTrace(); }
        return hm;
    }
}
