package pl.sda.MovieRental.exception;

import pl.sda.MovieRental.model.Movie;

import java.util.List;

public class NoMovieInStockException extends Exception {

    //TODO

    public static final String DEFAULT_MESSAGE = "No movies in stock";

    public NoMovieInStockException() {
        super(DEFAULT_MESSAGE);
    }

    public NoMovieInStockException(Movie movie){
        super(String.format("No %s movie in stock.", movie.getTitle()));
    }
}
