package com.league.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private int users_id;

    @OneToOne
    @JoinColumn(name = "roles_id")
    private Roles role;

    @Column(name = "username")
    private String username;

    @Column(name = "passwrd")
    private String passwrd;

    ///////////////////////

    @OneToOne(mappedBy = "user", cascade = {CascadeType.REMOVE})
    private Coach coach;

    public Users () {}

    public Users(Roles role, String username, String passwrd) {
        this.role = role;
        this.username = username;
        this.passwrd = passwrd;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
