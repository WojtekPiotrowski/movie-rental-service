package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {



    Movie addMovie(Movie movie); //ok

    Optional<Movie> getById(Long id);  //ok

    List<Movie> getAll();  //ok

    void delete(Long id);  //ok

    void update (Movie movie);  //ok






}
