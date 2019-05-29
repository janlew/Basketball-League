package com.league.model.tableViews;

import javafx.scene.control.Button;

import java.sql.Date;

public class TeamGamesTable {
    private String homeName;
    private int homePts;
    private int awayPts;
    private String awayName;
    private Date date;
    private Button button;

    public TeamGamesTable(String awayName, Date date) {
        this.awayName = awayName;
        this.date = date;
    }

    public TeamGamesTable(String homeName, String awayName, Date date) {
        this.homeName = homeName;
        this.awayName = awayName;
        this.date = date;
    }

    public TeamGamesTable(String homeName, int homePts, int awayPts, String awayName, Date date, Button button) {
        this.homeName = homeName;
        this.homePts = homePts;
        this.awayPts = awayPts;
        this.awayName = awayName;
        this.date = date;
        this.button = button;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public int getHomePts() {
        return homePts;
    }

    public void setHomePts(int homePts) {
        this.homePts = homePts;
    }

    public int getAwayPts() {
        return awayPts;
    }

    public void setAwayPts(int awayPts) {
        this.awayPts = awayPts;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
