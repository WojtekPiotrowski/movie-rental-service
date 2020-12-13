package pl.sda.MovieRental.Utils;

import org.springframework.stereotype.Component;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.MovieService;

@Component
public class CartHandler {

    private final MovieService movieService;

    public CartHandler(MovieService movieService) {
        this.movieService = movieService;
    }

    public Movie findMovieById(Long id) {
        if (movieService.findById(id).isPresent()) {
            return movieService.findById(id).get();
        }
        else {
            return null;
        }
    }
}
