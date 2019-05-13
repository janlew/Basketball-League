package com.league.model;

import javax.persistence.*;

@Entity
@Table(name = "playerStats")
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_id")
    private int stat_id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Column(name = "minutes")
    private float minutes;

    @Column(name = "pts")
    private int pts;

    @Column(name = "reb")
    private int reb;

    @Column(name = "ast")
    private int ast;

    @Column(name = "stl")
    private int stl;

    @Column(name = "blk")
    private int blk;

    @Column(name = "fgm")
    private int fgm;

    @Column(name = "fga")
    private int fga;

    @Column(name = "tfgm")
    private int tfgm;

    @Column(name = "tfga")
    private int tfga;

    @Column(name = "ftm")
    private int ftm;

    @Column(name = "fta")
    private int fta;

    @Column(name = "turno")
    private int turno;

    @Column(name = "fouls")
    private int fouls;

    ///////////////////////

    public PlayerStats() {}

    public PlayerStats(Player player, Game game, float minutes, int pts, int reb, int ast, int stl, int blk, int fgm, int fga, int tfgm, int tfga, int ftm, int fta, int turno, int fouls) {
        this.player = player;
        this.game = game;
        this.minutes = minutes;
        this.pts = pts;
        this.reb = reb;
        this.ast = ast;
        this.stl = stl;
        this.blk = blk;
        this.fgm = fgm;
        this.fga = fga;
        this.tfgm = tfgm;
        this.tfga = tfga;
        this.ftm = ftm;
        this.fta = fta;
        this.turno = turno;
        this.fouls = fouls;
    }

    public int getStat_id() {
        return stat_id;
    }

    public void setStat_id(int stat_id) {
        this.stat_id = stat_id;
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

    public float getMinutes() {
        return minutes;
    }

    public void setMinutes(float minutes) {
        this.minutes = minutes;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getReb() {
        return reb;
    }

    public void setReb(int reb) {
        this.reb = reb;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getStl() {
        return stl;
    }

    public void setStl(int stl) {
        this.stl = stl;
    }

    public int getBlk() {
        return blk;
    }

    public void setBlk(int blk) {
        this.blk = blk;
    }

    public int getFgm() {
        return fgm;
    }

    public void setFgm(int fgm) {
        this.fgm = fgm;
    }

    public int getFga() {
        return fga;
    }

    public void setFga(int fga) {
        this.fga = fga;
    }

    public int getTfgm() {
        return tfgm;
    }

    public void setTfgm(int tfgm) {
        this.tfgm = tfgm;
    }

    public int getTfga() {
        return tfga;
    }

    public void setTfga(int tfga) {
        this.tfga = tfga;
    }

    public int getFtm() {
        return ftm;
    }

    public void setFtm(int ftm) {
        this.ftm = ftm;
    }

    public int getFta() {
        return fta;
    }

    public void setFta(int fta) {
        this.fta = fta;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }
}
