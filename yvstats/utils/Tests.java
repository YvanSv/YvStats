package yvstats.utils;

public class Tests {
    public static void main(String[] args) {
        int min = 1, max = 100;
        System.out.println(" res : " + Tests.nbPlacesParLigne(min, max));
    }

    private static int nbPlacesParLigne(int x, int y) {
        int tmp = y - x, cpt = 0;
        System.out.println("y : " + y + " | x : " + x);
        System.out.println(tmp);
        while (tmp > 9) {
            tmp = tmp - 10;
            System.out.println(tmp);
            cpt++;
        }
        return cpt;
    }
}
