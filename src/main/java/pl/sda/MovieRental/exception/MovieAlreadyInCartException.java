package pl.sda.MovieRental.exception;

import pl.sda.MovieRental.model.Movie;

public class MovieAlreadyInCartException extends Throwable {

    public static final String DEFAULT_MESSAGE = "This movie is already in cart";

    public  MovieAlreadyInCartException() {
        super(DEFAULT_MESSAGE);
    }

    public MovieAlreadyInCartException(Movie movie) {
        super(String.format("%s is already in cart",movie.getTitle()));
    }
}
