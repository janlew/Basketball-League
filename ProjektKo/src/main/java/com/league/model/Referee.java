package com.league.model;

import javax.persistence.*;
import java.sql.Ref;
import java.util.Set;

@Entity
@Table(name = "referee")
public class Referee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "referee_id")
    private int referee_id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    ///////////////////////

    @OneToMany(mappedBy = "referee")
    private Set<Game> refereeGames;

    public Referee () {}

    public Referee(String name, String surname, Set<Game> refereeGames) {
        this.name = name;
        this.surname = surname;
        this.refereeGames = refereeGames;
    }

    public int getReferee_id() {
        return referee_id;
    }

    public void setReferee_id(int referee_id) {
        this.referee_id = referee_id;
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

    public Set<Game> getRefereeGames() {
        return refereeGames;
    }

    public void setRefereeGames(Set<Game> refereeGames) {
        this.refereeGames = refereeGames;
    }
}

