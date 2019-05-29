package com.league.model.tableViews;

import javafx.scene.control.Button;

import java.sql.Date;

public class APlayerTable {
    private int id;
    private int playerPosition_id;
    private int team_id;
    private String name;
    private String surname;
    private Date birth;
    private float height;
    private float weight;
    private int jerseyNum;
    private Button edit;
    private Button delete;

    public APlayerTable(int id, int playerPosition_id, int team_id, String name, String surname, Date birth, float height, float weight, int jerseyNum, Button edit, Button delete) {
        this.id = id;
        this.playerPosition_id = playerPosition_id;
        this.team_id = team_id;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.height = height;
        this.weight = weight;
        this.jerseyNum = jerseyNum;
        this.edit = edit;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerPosition_id() {
        return playerPosition_id;
    }

    public void setPlayerPosition_id(int playerPosition_id) {
        this.playerPosition_id = playerPosition_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getJerseyNum() {
        return jerseyNum;
    }

    public void setJerseyNum(int jerseyNum) {
        this.jerseyNum = jerseyNum;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }
}
