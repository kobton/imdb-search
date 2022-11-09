package com.example.imdbsearch;

import com.example.imdbsearch.importer.TSVReader;
import com.example.imdbsearch.model.Imdb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ImdbSearchApplication {
	public static void main(String[] args) {
		SpringApplication.run(ImdbSearchApplication.class, args);
	}
}
