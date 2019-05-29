package com.league.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int game_id;

    @OneToOne
    @JoinColumn(name = "referee_id")
    private Referee referee;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Team home;

    @ManyToOne
    @JoinColumn(name = "away_id")
    private Team away;

    @Column(name = "termin")
    private Date termin;

    @Column(name = "team1pts")
    private int team1pts;

    @Column(name = "team2pts")
    private int team2pts;

    ///////////////////////

    @OneToMany(mappedBy = "game", cascade = {CascadeType.REMOVE})
    private List<PlayerStats> playerStats;

    public Game() {}

    public Game(Referee referee, Team home, Team away, Date termin, int team1pts, int team2pts) {
        this.referee = referee;
        this.home = home;
        this.away = away;
        this.termin = termin;
        this.team1pts = team1pts;
        this.team2pts = team2pts;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
    }

    public int getTeam1pts() {
        return team1pts;
    }

    public void setTeam1pts(int team1pts) {
        this.team1pts = team1pts;
    }

    public int getTeam2pts() {
        return team2pts;
    }

    public void setTeam2pts(int team2pts) {
        this.team2pts = team2pts;
    }

    public List<PlayerStats> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(List<PlayerStats> playerStats) {
        this.playerStats = playerStats;
    }
}
