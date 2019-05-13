package com.league.model;

import javax.persistence.*;

@Entity
@Table(name = "playerPosition")
public class PlayerPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playerPosition_id")
    private int playerPosition_id;

    @Column(name = "name")
    private String name;

    @Column(name = "abbrev")
    private String abbrev;

    ///////////////////////

    public PlayerPosition() {}

    public PlayerPosition(String name, String abbrev) {
        this.name = name;
        this.abbrev = abbrev;
    }

    public int getPlayerPosition_id() {
        return playerPosition_id;
    }

    public void setPlayerPosition_id(int playerPosition_id) {
        this.playerPosition_id = playerPosition_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }
}
