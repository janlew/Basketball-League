package com.league.model;

import javax.persistence.*;

@Entity
@Table(name = "stadium")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stadium_id")
    private int stadium_id;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "name")
    private String name;

    @Column(name = "cap")
    private int cap;

    ///////////////////////

    public Stadium() {}

    public Stadium(Address address, String name, int cap) {
        this.address = address;
        this.name = name;
        this.cap = cap;
    }

    public int getStadium_id() {
        return stadium_id;
    }

    public void setStadium_id(int stadium_id) {
        this.stadium_id = stadium_id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

}
