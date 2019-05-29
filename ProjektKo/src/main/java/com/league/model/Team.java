package com.league.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int team_id;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @Column(name = "name")
    private String name;

    @Column(name = "gamesPlayed")
    private int gamesPlayed;

    @Column(name = "wins")
    private int wins;

    @Column(name = "loses")
    private int loses;

    @Column(name = "winP")
    private String winP;

    @Column(name = "ptsGained")
    private int ptsGained;

    @Column(name = "ptsLosed")
    private int ptsLosed;

    @Column(name = "pts")
    private int pts;

    ///////////////////////

    @OneToMany(mappedBy = "team", cascade = {CascadeType.REMOVE})
    private List<Player> teamPlayers;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.REMOVE})
    private List<Training> trainings;


    @OneToMany(mappedBy = "home", cascade = {CascadeType.REMOVE})
    private List<Game> homeGames;

    @OneToMany(mappedBy = "away", cascade = {CascadeType.REMOVE})
    private List<Game> awayGames;

    public Team() {}

    public Team(Coach coach, String name) {
        this.coach = coach;
        this.name = name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public String getWinP() {
        return winP;
    }

    public void setWinP(String winP) {
        this.winP = winP;
    }

    public int getPtsGained() {
        return ptsGained;
    }

    public void setPtsGained(int ptsGained) {
        this.ptsGained = ptsGained;
    }

    public int getPtsLosed() {
        return ptsLosed;
    }

    public void setPtsLosed(int ptsLosed) {
        this.ptsLosed = ptsLosed;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    public List<Game> getHomeGames() {
        return homeGames;
    }

    public void setHomeGames(List<Game> homeGames) {
        this.homeGames = homeGames;
    }

    public List<Game> getAwayGames() {
        return awayGames;
    }

    public void setAwayGames(List<Game> awayGames) {
        this.awayGames = awayGames;
    }

    public List<Player> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<Player> teamPlayers) {
        this.teamPlayers = teamPlayers;
    }
}
