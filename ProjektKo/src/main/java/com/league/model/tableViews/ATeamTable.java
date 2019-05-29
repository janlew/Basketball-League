package com.league.model.tableViews;

import javafx.scene.control.Button;

public class ATeamTable {
    private int id;
    private Integer coachid;
    private String name;
    private Button edit;
    private Button delete;

    public ATeamTable(int id, Integer coachid, String name, Button edit, Button delete) {
        this.id = id;
        this.coachid = coachid;
        this.name = name;
        this.edit = edit;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        this.coachid = coachid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
