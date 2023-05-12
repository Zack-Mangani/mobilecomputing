package com.example.monitorit;

import java.util.Date;

public class FixtureResponse {

    private String strHomeTeam; // Represents the name of the home team
    private String strAwayTeam; // Represents the name of the away team
    private Date dateEvent; // Represents the date of the event

    private int intAwayScore; // Represents the score of the away team
    private int intHomeScore; // Represents the score of the home team

    // Getter methods for accessing private member variables
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

