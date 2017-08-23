package com.roshan092;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MovieApp {
    @GetMapping("/movies/{year}")
    String getTopGrossingMovie(@PathVariable Integer year) {
        switch (year) {
            case 2016:
                return "Finding Dory";
            case 2015:
                return "The Force Awakens";
            case 2014:
                return "Guardians of the Galaxy";
            case 2013:
                return "Iron Man 3";
            case 2012:
                return "The Avengers";
            case 2011:
                return "Harry Potter and the Deathly Hallows Part 2";
            case 2010:
                return "Toy Story 3";
            case 2009:
                return "Terminator";
            default:
                throw new IllegalArgumentException("Boom!");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieApp.class, args);
    }
}

