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
    @Column(name = "genres")
    private String genres;
    @Column(name = "published")
    private boolean published;

    public Imdb() {
    }

    public Imdb(long id, String title, String genres) {
        this.id = id;
        this.title = title;
        this.genres = genres;
    }

    public Imdb(long id, String title, String genres, boolean published) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.published = published;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

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

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Imdb{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                ", published=" + published +
                '}';
    }
}

