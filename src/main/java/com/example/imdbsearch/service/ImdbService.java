package com.example.imdbsearch.service;

import com.example.imdbsearch.importer.TSVReader;
import com.example.imdbsearch.model.Imdb;
import com.example.imdbsearch.repository.ImdbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


public class ImdbService {
    @Autowired
    ImdbRepository imdbRepository;
    public void importer() throws Exception{
        try {
            List<Imdb> movies = TSVReader.readTSV("sample.tsv");
            for (Imdb m : movies) {
                imdbRepository.save(m);
            }
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
