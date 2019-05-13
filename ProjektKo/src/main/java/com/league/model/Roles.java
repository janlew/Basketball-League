package com.league.model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roles_id")
    private int roles_id;

    @Column(name = "name")
    private String name;

    ///////////////////////

    public Roles () {}

    public Roles(String name) {
        this.name = name;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
