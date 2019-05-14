package com.league.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private int users_id;

    @OneToOne
    @JoinColumn(name = "roles_id")
    private Roles role;

    @Column(name = "username")
    private String username;

    @Column(name = "passwrd")
    private String passwrd;

    ///////////////////////

    @OneToMany(mappedBy = "user")
    private Set<News> news;

    public Users () {}

    public Users(Roles role, String username, String passwrd) {
        this.role = role;
        this.username = username;
        this.passwrd = passwrd;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    public Set<News> getNews() {
        return news;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }
}
