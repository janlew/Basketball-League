package com.league.model.tableViews;

import javafx.scene.control.Button;

public class APlayerStats {
    private int id;
    private int playerid;
    private int gameid;
    private int pts;
    private int ast;
    private int reb;
    private Button edit;
    private Button delete;

    public APlayerStats(int id, int playerid, int gameid, int pts, int ast, int reb, Button edit, Button delete) {
        this.id = id;
        this.playerid = playerid;
        this.gameid = gameid;
        this.pts = pts;
        this.ast = ast;
        this.reb = reb;
        this.edit = edit;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getReb() {
        return reb;
    }

    public void setReb(int reb) {
        this.reb = reb;
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
