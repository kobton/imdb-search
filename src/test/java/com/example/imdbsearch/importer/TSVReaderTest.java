package com.example.imdbsearch.importer;

import com.example.imdbsearch.model.Imdb;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TSVReaderTest {

    @Test
    void readTSV() {
       List<Imdb> movies = new ArrayList<>();
       movies =TSVReader.readTSV("sample.tsv");
       System.out.println(movies.get(16));
    }

    @Test
    void createImdb() {
    }
}