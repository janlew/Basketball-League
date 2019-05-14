package com.league.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int player_id;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users user;

    @OneToOne
    @JoinColumn(name = "playerPosition_id")
    private PlayerPosition playerPosition;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "height")
    private float height;

    @Column(name = "weight")
    private float weight;

    @Column(name = "jerseyNum")
    private int jerseyNum;

    ///////////////////////

    @OneToMany(mappedBy = "player")
    private List<TeamPlayers> teamPlayers;

    @OneToMany(mappedBy = "player")
    private List<PlayerStats> playerStats;

    public Player() {}

    public Player(Users user, PlayerPosition playerPosition, String name, String surname, Date birth, float height, float weight, int jerseyNum) {
        this.user = user;
        this.playerPosition = playerPosition;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.height = height;
        this.weight = weight;
        this.jerseyNum = jerseyNum;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public PlayerPosition getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(PlayerPosition playerPosition) {
        this.playerPosition = playerPosition;
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

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getJerseyNum() {
        return jerseyNum;
    }

    public void setJerseyNum(int jerseyNum) {
        this.jerseyNum = jerseyNum;
    }

    public List<TeamPlayers> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<TeamPlayers> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }

    public List<PlayerStats> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(List<PlayerStats> playerStats) {
        this.playerStats = playerStats;
    }


}
