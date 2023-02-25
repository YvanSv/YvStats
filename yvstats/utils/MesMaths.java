package yvstats.utils;

import yvstats.metier.Objet;
import yvstats.utils.exception.DateFormatException;

public class MesMaths {
    private static int nbDates = 20;
    private static int nbLignesMax = 10;

    public static String graphe(Objet o) {
        int longueurBottom = String.valueOf(o.getPirePlace()).length();
        int[] places = getTabPlacesARegarder(o.getMeilleurePlace(),o.getPirePlace());
        int[] dates = getTabDates(0);
        
        String graphe = '┌' + newLigne('─',longueurBottom) + '┬' + newLigne('─',nbDates) + "┐\n";
        graphe       += '├' + newLigne('─',longueurBottom) + '┼' + newLigne('─',nbDates) + "┤\n";

        for (int i = 0; i < places.length; i++) {
            graphe += String.format("│%"+longueurBottom+"s│",places[i]);
            for (int d : dates) {
                if (o.getClassementLe(d) >  places[i] - getMarge(places) &&
                    o.getClassementLe(d) <= places[i] + getMarge(places) &&
                    o.getClassementLe(d) != 0 ||
                    o.getClassementLe(d) == places[i])
                    graphe += "+";
                else graphe += " ";
            }
            graphe += "│\n";
        }
        graphe += '└' + newLigne('─',longueurBottom) + '┴' + newLigne('─',nbDates) + "┘\n";
        return graphe;
    }

    public static int[] getTabPlacesARegarder(int x, int y) {
        int nbLignes = nbLignesMax;
        if (y-x < nbLignesMax) nbLignes = y-x + 1;
        int[] tabPlaces = new int[nbLignes];
        double accu = Math.ceil((y-x) / nbLignes), cpt = x;
        if (accu < 1) accu = 1;

        for (int i = 0; i < nbLignes; i++) {
            tabPlaces[i] = (int) cpt;
            cpt += accu;
        }

        return tabPlaces;
    }

    private static String newLigne(char c, int longueur) {
        String s = "";
        for (int i = 0; i < longueur; i++) s += c;
        return s;
    }

    private static float getMarge(int[] places) {
        if (places.length < 2) return 0;
        
        int x = places[0];
        int y = places[1];
        return (y-x)/2;
    }

    private static int[] getTabDates(int decalage) {
        int[] tab = new int[nbDates];

        Date date = Date.getToday();

        try {
            for (int i = decalage; i < 0; i++) date = date.previous();
            for (int i = decalage; i > 0; i--) date = date.next();

            for (int i = nbDates; i > 0; i--) {
                tab[i-1] = date.toInt();
                date = date.previous();
            }
        } catch(DateFormatException e) { System.out.println("ici"); e.printStackTrace(); }

        return tab;
    }
}
