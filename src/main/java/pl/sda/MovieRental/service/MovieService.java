package pl.sda.MovieRental.service;

import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;

import java.util.Optional;

public interface MovieService {
    Optional<Movie> findById(Long id);

    CopyMovie getCopy(Movie movie) throws NoMovieInStockException;
}
