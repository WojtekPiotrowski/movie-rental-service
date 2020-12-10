package pl.sda.MovieRental.service;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    Movie addMovie(Movie movie) throws Exception;
  
    Optional<Movie> findById(Long id) throws Exception;

    List<Movie> findAll();

    //void delete(Movie movie) throws Exception;
    void deleteById(Long id) throws Exception;

    void save (Movie movie);

    CopyMovie getCopy(Movie movie) throws NoMovieInStockException;

    Optional<Movie> findByTitle(String title) throws Exception;


}
