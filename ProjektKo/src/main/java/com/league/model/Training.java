package com.league.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "training")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private int training_id;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    @Column(name = "termin")
    private Date termin;

    ///////////////////

    public Training() {}

    public Training(Team team, Date termin) {
        this.team = team;
        this.termin = termin;
    }

    public int getTraining_id() {
        return training_id;
    }

    public void setTraining_id(int training_id) {
        this.training_id = training_id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Date getTermin() {
        return termin;
    }

    public void setTermin(Date termin) {
        this.termin = termin;
    }
}
