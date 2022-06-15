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
    @Column(name = "year")
    private String year;

    public Imdb() {
    }

    public Imdb(String title, String genres, String year) {
        this.title = title;
        this.genres = genres;
        this.year = year;
    }

    public long getId() {
        return id;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Imdb {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                ", year=" + year +
                '}';
    }
}

