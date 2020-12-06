package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.Movie;

import java.util.Optional;

public interface MovieService {
    Optional<Movie> findById(Long id);
}
