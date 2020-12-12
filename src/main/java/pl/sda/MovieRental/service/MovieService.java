package pl.sda.MovieRental.service;
import pl.sda.MovieRental.exception.MovieAlreadyExistsException;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    Movie addMovie(Movie movie) throws MovieAlreadyExistsException;
  
    Optional<Movie> findById(Long id);

    List<Movie> findAll();

    Optional<Movie> findByTitle(String title);

    void deleteById(Long id);

    void save (Movie movie);

    CopyMovie getCopy(Movie movie) throws NoMovieInStockException;



}
