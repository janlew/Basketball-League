package com.league.model;

import javax.persistence.*;

@Entity
@Table(name = "playerStats")
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerStats_id")
    private int playerStats_id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Column(name = "pts")
    private int pts;

    @Column(name = "ast")
    private int ast;

    @Column(name = "reb")
    private int reb;

    ///////////////////////

    public PlayerStats() {}

    public PlayerStats(Player player, Game game, int pts, int ast, int reb) {
        this.player = player;
        this.game = game;
        this.pts = pts;
        this.ast = ast;
        this.reb = reb;
    }

    public int getPlayerStats_id() {
        return playerStats_id;
    }

    public void setPlayerStats_id(int playerStats_id) {
        this.playerStats_id = playerStats_id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getReb() {
        return reb;
    }

    public void setReb(int reb) {
        this.reb = reb;
    }
}
