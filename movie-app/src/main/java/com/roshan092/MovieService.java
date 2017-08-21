package com.roshan092;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
class MovieService {

    @HystrixCommand(fallbackMethod = "getCurrentTopGrossingMovie")
    String getTopGrossingMovie(Integer year) {
        switch (year) {
            case 2016: return "Finding Dory";
            case 2015: return "The Force Awakens";
            case 2014: return "Guardians of the Galaxy";
            case 2013: return "Iron Man 3";
            case 2012: return "The Avengers";
            case 2011: return "Harry Potter and the Deathly Hallows Part 2";
            case 2010: return "Toy Story 3";
            case 2009: return "Terminator";
            case 2008: return "Transformers";
            case 2007: return "The Matrix";
            default: throw new IllegalArgumentException("Boom!");
        }
    }

    String getCurrentTopGrossingMovie(Integer year) {
        return "Beauty and the Beast";
    }
}
