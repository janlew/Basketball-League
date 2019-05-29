package com.league.model.tableViews;

import javafx.scene.control.Button;

import java.sql.Date;

public class ATrainingTable {
    private int id;
    private int teamid;
    private Date termin;
    private Button edit;
    private Button delete;

    public ATrainingTable(int id, int teamid, Date termin, Button edit, Button delete) {
        this.id = id;
        this.teamid = teamid;
        this.termin = termin;
        this.edit = edit;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        this.teamid = teamid;
    }

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
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
