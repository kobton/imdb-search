package com.example.imdbsearch.model;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Imdb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String descrition;
    @Column(name = "published")
    private boolean published;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ImdbModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", descrition='" + descrition + '\'' +
                ", published=" + published +
                '}';
    }
}

