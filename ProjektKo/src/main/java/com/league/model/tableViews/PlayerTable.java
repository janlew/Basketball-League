package com.league.model.tableViews;


import javafx.scene.control.Button;

public class PlayerTable {
    private String fullname;
    private String ppg;
    private String apg;
    private String rpg;
    private String teamName;
    private Button button;

    public PlayerTable(String fullname, String ppg, String apg, String rpg, String teamName, Button button) {
        this.fullname = fullname;
        this.ppg = ppg;
        this.apg = apg;
        this.rpg = rpg;
        this.teamName = teamName;
        this.button = button;
    }

    public PlayerTable(String ppg, String apg, String rpg) {
        this.ppg = ppg;
        this.apg = apg;
        this.rpg = rpg;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPpg() {
        return ppg;
    }

    public void setPpg(String ppg) {
        this.ppg = ppg;
    }

    public String getApg() {
        return apg;
    }

    public void setApg(String apg) {
        this.apg = apg;
    }

    public String getRpg() {
        return rpg;
    }

    public void setRpg(String rpg) {
        this.rpg = rpg;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
