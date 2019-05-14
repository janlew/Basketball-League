package com.league.model;

import javax.persistence.*;

@Entity
@Table(name = "TeamPlayers")
public class TeamPlayers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamPlayers_id")
    private int teamPlayers_id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    ////////////////////////////

    public TeamPlayers() {}

    public TeamPlayers(Team team, Player player) {
        this.team = team;
        this.player = player;
    }

    public int getTeamPlayers_id() {
        return teamPlayers_id;
    }

    public void setTeamPlayers_id(int teamPlayers_id) {
        this.teamPlayers_id = teamPlayers_id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
