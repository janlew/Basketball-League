package com.league.model.tableViews;


import javafx.scene.control.Button;

import java.sql.Date;

public class GameStatsTable {
    private String fullname;
    private String team;
    private int points;
    private int asissts;
    private int rebounds;
    private Date date;
    private Button button;

    public GameStatsTable(String fullname, String team, int points, int asissts, int rebounds, Button button) {
        this.fullname = fullname;
        this.team = team;
        this.points = points;
        this.asissts = asissts;
        this.rebounds = rebounds;
        this.button = button;
    }

    public GameStatsTable(String team, int points, int asissts, int rebounds, Date date) {
        this.team = team;
        this.points = points;
        this.asissts = asissts;
        this.rebounds = rebounds;
        this.date = date;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getAsissts() {
        return asissts;
    }

    public void setAsissts(int asissts) {
        this.asissts = asissts;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
