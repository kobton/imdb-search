package com.example.imdbsearch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.imdbsearch.importer.TSVReader;
import com.example.imdbsearch.service.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.imdbsearch.model.Imdb;
import com.example.imdbsearch.repository.ImdbRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ImdbController {
    @Autowired
    ImdbRepository imdbRepository;
    ImdbService imdbService;

    @PostMapping("/imdb/import")
    public ResponseEntity<HttpStatus> importMovies() {
        try {
            imdbService.importer();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/imdb")
    public ResponseEntity<List<Imdb>> getAllMovies(@RequestParam(required = false) String title, String genres, String year) {
        try {
            List<Imdb> movies = new ArrayList<>();
            if (title == null && genres == null && year == null)
                movies.addAll(imdbRepository.findAll());
            else if (title != null)
                movies.addAll(imdbRepository.findByTitleContaining(title));
            else if (genres != null)
                movies.addAll(imdbRepository.findByGenresContaining(genres));
            else
                movies.addAll(imdbRepository.findByYearContaining(year));
            if (movies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/imdb/{id}")
    public ResponseEntity<Imdb> getMoviesById(@PathVariable("id") long id) {
        Optional<Imdb> moviesData = imdbRepository.findById(id);
        if (moviesData.isPresent()) {
            return new ResponseEntity<>(moviesData.get(), HttpStatus.OK);a
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/imdb")
    public ResponseEntity<Imdb> createMovie(@RequestBody Imdb imdb) {
        try {
            Imdb _imdb = imdbRepository
                    .save(new Imdb(imdb.getTitle(), imdb.getGenres(), imdb.getYear(), imdb.getType()));
            return new ResponseEntity<>(_imdb, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/imdb/{id}")
    public ResponseEntity<Imdb> updateMovie(@PathVariable("id") long id, @RequestBody Imdb imdb) {
        Optional<Imdb> tutorialData = imdbRepository.findById(id);
        if (tutorialData.isPresent()) {
            Imdb _imdb = tutorialData.get();
            _imdb.setTitle(imdb.getTitle());
            _imdb.setYear(imdb.getYear());
            _imdb.setGenres(imdb.getGenres());
            return new ResponseEntity<>(imdbRepository.save(_imdb), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/imdb/{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable("id") long id) {
        try {
            imdbRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/imdb")
    public ResponseEntity<HttpStatus> deleteAllMovies() {
        try {
            imdbRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/imdb/search")
    public ResponseEntity<List<Imdb>> findByTitle(@RequestParam String search) {
        try {
            return new ResponseEntity<>(imdbRepository.searchTitle(search), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/imdb/movies")
    public ResponseEntity<List<Imdb>> getMovies(){
        try {
         return new ResponseEntity<>(imdbRepository.findByTypeContaining("movie"), HttpStatus.OK);
         } catch (Exception e) {
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
    }

