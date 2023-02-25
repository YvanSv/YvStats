package yvstats.utils;
import java.io.Serializable;
import java.time.LocalDate;

import yvstats.utils.exception.DateFormatException;

public class Date implements Serializable {
    private static final int[] nbJoursParMois = {31,28,31,30,31,30,31,31,30,31,30,31};
    private int jour;
    private int mois;
    private int annee;

    public Date(int jour, int mois, int annee) {
        if (jour == 0 && mois == 0 && annee == 0) {
            int date = Date.getToday().toInt();
            this.jour = date % 100;
            this.mois = date / 100 % 100;
            this.annee = date / 10000;
        }
        else {
            this.jour = jour;
            this.mois = mois;
            this.annee = annee;
        }
    }

    public Date(int date) {
        if (date == 0) {
            date = Date.getToday().toInt();
            this.jour = date % 100;
            this.mois = date / 100 % 100;
            this.annee = date / 10000;
        }
        else {
            this.jour = date % 100;
            this.mois = date / 100 % 100;
            this.annee = date / 10000;
        }
    }

    public Date(Date d, int diff) {
        try {
            for (int i = diff; i > 0; i--) d = d.next();
            for (int i = diff; i < 0; i++) d = d.previous();
        } catch(Exception e) { e.printStackTrace(); }
        int date = d.toInt();
        this.jour = date % 100;
        this.mois = date / 100 % 100;
        this.annee = date / 10000;
    }

    public int toInt() {
        return this.annee * 10000 + this.mois * 100 + this.jour;
    }

    public int compareTo(Date d2) {
        return this.toInt() - d2.toInt();
    }

    public static Date getToday() {
        LocalDate d = java.time.LocalDate.now();
        return new Date(d.getDayOfMonth(),d.getMonthValue(),d.getYear());
    }

    public Date next() throws DateFormatException {
        if (this.jour < 1 || this.jour > Date.nbJoursParMois[this.mois-1]) throw new DateFormatException("Jour invalide : " + this.jour);
        if (this.mois < 1 || this.mois > 12) throw new DateFormatException("Mois invalide : " + this.mois);
        int j = this.jour, m = this.mois, a = this.annee;
        if (j+1 > Date.nbJoursParMois[m-1]) {
            if (m+1 > 12) {
                a++;
                m = 1;
            }
            else m++;
            j = 1;
        }
        else j++;
        return new Date(j,m,a);
    }

    public Date previous() throws DateFormatException {
        if (this.jour < 1 || this.jour > Date.nbJoursParMois[this.mois-1]) throw new DateFormatException("Jour invalide : " + this.jour);
        if (this.mois < 1 || this.mois > 12) throw new DateFormatException("Mois invalide : " + this.mois);
        int j = this.jour, m = this.mois, a = this.annee;
        if (j-1 < 1) {
            if (m-1 < 1) {
                a--;
                m = 12;
            }
            else m--;
            j = Date.nbJoursParMois[m-1];
        }
        else j--;
        return new Date(j,m,a);
    }

    public String toString() {
        return this.jour + "/" + this.mois + "/" + this.annee;
    }
}
