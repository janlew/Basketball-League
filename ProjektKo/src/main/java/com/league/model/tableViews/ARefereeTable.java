package com.league.model.tableViews;


import javafx.scene.control.Button;

public class ARefereeTable {
    private int id;
    private String name;
    private String surname;
    private Button edit;
    private Button delete;

    public ARefereeTable(int id, String name, String surname, Button edit, Button delete) {
        this.id = id;
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
