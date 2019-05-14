package com.league.model;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    private int news_id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    ///////////////////////

    public News () {}

    public News(Users user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
