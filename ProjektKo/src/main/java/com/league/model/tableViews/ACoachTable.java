package com.league.model.tableViews;

import javafx.scene.control.Button;

import java.sql.Date;

public class ACoachTable {
    private int id;
    private Integer users_id;
    private String name;
    private String surname;
    private Button edit;
    private Button delete;

    public ACoachTable(int id, Integer users_id, String name, String surname, Button edit, Button delete) {
        this.id = id;
        this.users_id = users_id;
        this.name = name;
        this.surname = surname;
        this.edit = edit;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Integer users_id) {
        this.users_id = users_id;
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
