package com.example.imdbsearch.importer;

import com.example.imdbsearch.model.Imdb;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TSVReader {

    public static List<Imdb> readTSV(String fileName) {
        List<Imdb> movies = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader

        try (BufferedReader br = Files.newBufferedReader(pathToFile))  {
            String line = br.readLine();


            while (line != null){

                String[] attributes = line.split("\t");

                Imdb imdb = createImdb(attributes);

                movies.add(imdb);

                line = br.readLine();


            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return movies;
    }

    public static Imdb createImdb (String[] attributes) {
        String title = attributes[2];
        String genres = attributes[8];
        String year = attributes[5];

        return new Imdb(title, genres, year);


    }

}
