package com.league.model;

import javax.persistence.*;

@Entity
@Table(name = "coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private int coach_id;

    @OneToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "users_id")
    private Users user;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    ///////////////////////

    @OneToOne(mappedBy = "coach")
    private Team team;

    public Coach() {}

    public Coach(Users user, String name, String surname) {
        this.user = user;
        this.name = name;
        this.surname = surname;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


}
