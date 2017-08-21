package movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class MovieApp {

    private final MovieService movieService;

    public MovieApp(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/{year}")
    String getTopGrossingMovie(@PathVariable Integer year) {
        return movieService.getTopGrossingMovie(year);
    }

    public static void main(String[] args) {
        SpringApplication.run(MovieApp.class, args);
    }
}

