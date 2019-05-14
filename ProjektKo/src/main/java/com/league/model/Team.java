package com.league.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int team_id;

    @OneToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @Column(name = "name")
    private String name;

    ///////////////////////

    @OneToMany(mappedBy = "team")
    private List<Training> trainings;

    @OneToMany(mappedBy = "team")
    private List<TeamPlayers> teamPlayers;

    @OneToMany(mappedBy = "home")
    private List<Game> homeGames;

    @OneToMany(mappedBy = "away")
    private List<Game> awayGames;

    public Team() {}

    public Team(Coach coach, String name) {
        this.coach = coach;
        this.name = name;
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

    public List<TeamPlayers> getTeamPlayers() {
        return teamPlayers;
    }

    public void setTeamPlayers(List<TeamPlayers> teamPlayers) {
        this.teamPlayers = teamPlayers;
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
}
