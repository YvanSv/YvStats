package yvstats.utils;

import java.util.Scanner;

public class Lecteur {
    private static Lecteur scan;
    private Scanner sc;
    private Lecteur() {
        this.sc = new Scanner(System.in);
    }

    private String lireSc() {
        return sc.nextLine();
    }

    public static void creerLecteur() {
        Lecteur.scan = new Lecteur();
    }

    public static String lire() {
        return Lecteur.scan.lireSc();
    }

    public static void fermer() {
        Lecteur.scan.fermerScanner();
    }

    private void fermerScanner() {
        this.sc.close();
    }
}
