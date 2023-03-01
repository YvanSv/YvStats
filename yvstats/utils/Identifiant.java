package yvstats.utils;

public class Identifiant {
    private static Identifiant identifiant;
    private int ind0;
    private char c0;
    private int ind1;
    private char c1;

    private Identifiant() {
        this.ind0 = 0;
        this.c0 = 'A';
        this.ind1 = 0;
        this.c1 = 'A';
    }

    private Identifiant(int i0, char c0, int i1, char c1) {
        this.ind0 = i0;
        this.c0 = c0;
        this.ind1 = i1;
        this.c1 = c1;
    }

    public String toString() {
        return "" + this.ind0 + this.c0 + this.ind1 + this.c1;
    }

    public boolean equals(Identifiant i) {
        if (this.toString().equals(i.toString())) return true;
        else return false;
    }

    private Identifiant next() {
        this.c1++;
        if ((int)this.c1 > (int)'A' + 25) {
            this.ind1++;
            this.c1 = 'A';
        }
        if (this.ind1 > 9) {
            this.c0++;
            this.ind1 = 0;
        }
        if ((int)this.c0 > (int)'A' + 25) {
            this.ind0++;
            this.c0 = 'A';
        }

        return new Identifiant(this.ind0, this.c0, this.ind1, this.c1);
    }

    public static Identifiant nextID() {
        return Identifiant.identifiant.next();
    }

    public static void creerIdentifiant() {
        Identifiant.identifiant = new Identifiant();
    }

    public static Identifiant creerIdentifiant(String s) {
        int i0 = Integer.parseInt(s.charAt(0) + "");
        char c0 = s.charAt(1);
        int i1 = Integer.parseInt(s.charAt(2) + "");
        char c1 = s.charAt(3);
        return new Identifiant(i0, c0, i1, c1);
    }
}
