package com.roshan092;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class DiscoveryService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCurrentTopGrossingMovie")
    public String getTopGrossingMovie(@PathVariable Integer year) {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090/movies/" + year).build().toUri();
        return restTemplate.getForObject(uri, String.class);
    }

    @HystrixCommand(fallbackMethod = "getCurrentTopGrossingSong")
    public String getTopGrossingSong(@PathVariable Integer year) {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9091/songs/" + year).build().toUri();
        return restTemplate.getForObject(uri, String.class);
    }

    public String getCurrentTopGrossingMovie(Integer year) {
        return "Beauty and the Beast";
    }

    public String getCurrentTopGrossingSong(Integer year) {
        return "One Dance";
    }

}
