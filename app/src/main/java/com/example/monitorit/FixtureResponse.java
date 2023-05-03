package com.example.monitorit;

import java.util.Date;

public class FixtureResponse {

    private String strHomeTeam;
    private String strAwayTeam;
    private Date dateEvent;

    private int intAwayScore;
    private int intHomeScore;
    //
    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public int getIntAwayScore() {
        return intAwayScore;
    }

    public int getIntHomeScore() {
        return intHomeScore;
    }
}

