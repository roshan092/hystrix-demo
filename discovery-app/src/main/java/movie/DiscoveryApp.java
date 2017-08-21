package movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@SpringBootApplication
@RestController
public class DiscoveryApp {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/topgrossing/{year}")
    String getTopGrossingMovie(@PathVariable Integer year) {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080/movies/" + year).build().toUri();
        return restTemplate.getForObject(uri, String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApp.class, args);
    }
}

