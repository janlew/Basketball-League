package com.league.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int team_id;

    @OneToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    @Column(name = "name")
    private String name;

    @Column(name = "wins")
    private int wins;

    @Column(name = "loss")
    private int loss;

    ///////////////////////

    @OneToOne(mappedBy="team")
    private Coach coach;

    @OneToMany(mappedBy = "team")
    private Set<Player> players;


    public Team() {}

    public Team(Stadium stadium, String name, int wins, int loss, Coach coach, Set<Player> players) {
        this.stadium = stadium;
        this.name = name;
        this.wins = wins;
        this.loss = loss;
        this.coach = coach;
        this.players = players;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

}
