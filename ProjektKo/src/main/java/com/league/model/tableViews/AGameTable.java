package com.league.model.tableViews;

import javafx.scene.control.Button;

import java.sql.Date;

public class AGameTable {
    private int id;
    private Integer ref_id;
    private int homeid;
    private int awayid;
    private Date termin;
    private int homePts;
    private int awayPts;
    private Button edit;
    private Button delete;

    public AGameTable(int id, Integer ref_id, int homeid, int awayid, Date termin, int homePts, int awayPts, Button edit, Button delete) {
        this.id = id;
        this.ref_id = ref_id;
        this.homeid = homeid;
        this.awayid = awayid;
        this.termin = termin;
        this.homePts = homePts;
        this.awayPts = awayPts;
        this.edit = edit;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRef_id() {
        return ref_id;
    }

    public void setRef_id(Integer ref_id) {
        this.ref_id = ref_id;
    }

    public int getHomeid() {
        return homeid;
    }

    public void setHomeid(int homeid) {
        this.homeid = homeid;
    }

    public int getAwayid() {
        return awayid;
    }

    public void setAwayid(int awayid) {
        this.awayid = awayid;
    }

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
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
