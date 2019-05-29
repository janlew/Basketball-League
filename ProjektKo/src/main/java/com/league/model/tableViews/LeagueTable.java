package com.league.model.tableViews;


import javafx.scene.control.Button;

public class LeagueTable {
    private int standing;
    private String name;
    private int matchesPlayed;
    private int wins;
    private int loses;
    private int ptsGained;
    private int ptsLosed;
    private String winPerc;
    private int pts;
    private Button button;

    public LeagueTable(int wins, int loses) {
        this.wins = wins;
        this.loses = loses;
    }

    public LeagueTable(int standing, String name, int matchesPlayed, int wins, int loses, int ptsGained, int ptsLosed, String winPerc, int pts, Button button) {
        this.standing = standing;
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.loses = loses;
        this.ptsGained = ptsGained;
        this.ptsLosed = ptsLosed;
        this.winPerc = winPerc;
        this.pts = pts;
        this.button = button;
    }

    public int getStanding() {
        return standing;
    }

    public void setStanding(int standing) {
        this.standing = standing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getPtsLosed() {
        return ptsLosed;
    }

    public void setPtsLosed(int ptsLosed) {
        this.ptsLosed = ptsLosed;
    }

    public int getPtsGained() {
        return ptsGained;
    }

    public void setPtsGained(int ptsGained) {
        this.ptsGained = ptsGained;
    }

    public String getWinPerc() {
        return winPerc;
    }

    public void setWinPerc(String winPerc) {
        this.winPerc = winPerc;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
