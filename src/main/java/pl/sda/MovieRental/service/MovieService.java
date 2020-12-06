package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.Movie;

import java.util.List;


public interface MovieService {

    void save(Movie movie);

    //void addMovie(Movie movie); //ok

    Movie getById(Long id);  //ok

    List<Movie> getAll();  //ok

    void delete(Long id);  //ok

    void update (Movie movie);  //ok






}
