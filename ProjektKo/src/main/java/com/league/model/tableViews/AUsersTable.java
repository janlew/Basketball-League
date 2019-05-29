package com.league.model.tableViews;

import javafx.scene.control.Button;

public class AUsersTable {
    private int id;
    private int roleid;
    private String username;
    private String password;
    private Button edit;
    private Button delete;

    public AUsersTable(int id, int roleid, String username, String password, Button edit, Button delete) {
        this.id = id;
        this.roleid = roleid;
        this.username = username;
        this.password = password;
        this.edit = edit;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
