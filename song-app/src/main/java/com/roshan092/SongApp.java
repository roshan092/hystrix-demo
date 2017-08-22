package com.roshan092;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SongApp {

    @GetMapping("/songs/{year}")
    String getTopGrossingSongs(@PathVariable Integer year) {
        switch (year) {
            case 2014:
                return "Happy";
            case 2013:
                return "Thrift Shop";
            case 2012:
                return "Somebody That I Used to Know";
            case 2011:
                return "Rolling in the Deep";
            case 2010:
                return "Tik Tok";
            case 2009:
                return "Boom Boom Pow";
            case 2008:
                return "Low";
            case 2007:
                return "Irreplaceable";
            default:
                throw new IllegalArgumentException("Boom!");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SongApp.class, args);
    }
}

