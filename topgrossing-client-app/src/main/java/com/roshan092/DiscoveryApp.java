package com.roshan092;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class DiscoveryApp {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private DiscoveryService discoveryService;

    @GetMapping("/topgrossing/{year}")
    public TopGrossing getTopGrossingMovie(@PathVariable Integer year) {
        return TopGrossing.builder()
                .movie(discoveryService.getTopGrossingMovie(year))
                .song(discoveryService.getTopGrossingSong(year))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApp.class, args);
    }
}

