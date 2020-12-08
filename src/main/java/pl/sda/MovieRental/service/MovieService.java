package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {



    Movie addMovie(Movie movie); //ok

    Optional<Movie> findById(Long id);  //ok

    List<Movie> findAll();  //ok

    void delete(Long id);  //ok

    void save (Movie movie);  //ok






}
