package yvstats.metier;

import yvstats.utils.Date;

public class Ecoute {
    private Date date;
    public Ecoute(Date d) {
        this.date = d;
    }

    public Date getDate() {
        return this.date;
    }
}
