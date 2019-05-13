package com.league.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "coach")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private int coach_id;

    @OneToOne
    @JoinColumn(name="team_id")
    private Team team;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth")
    private Date birth;

    ///////////////////////

    public Coach() {}

    public Coach(Team team, String name, String surname, Date birth) {
        this.team = team;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
