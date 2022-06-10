package com.example.imdbsearch.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.imdbsearch.model.Imdb;

public interface ImdbRepository extends JpaRepository<Imdb, Long> {
    List<Imdb> findByTitleContaining(String title);
    List<Imdb> findByYearContaining(String year);

}
