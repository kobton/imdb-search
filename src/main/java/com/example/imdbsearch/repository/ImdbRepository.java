package com.example.imdbsearch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.imdbsearch.model.Imdb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImdbRepository extends JpaRepository<Imdb, Long> {
    List<Imdb> findByTitleContaining(String title);
    List<Imdb> findByYearContaining(String year);
    List<Imdb> findByGenresContaining(String genres);


    //@Query("SELECT year FROM movies year WHERE fts(:title) = true")
    //List<Imdb> search(@Param("title") String title);

}
