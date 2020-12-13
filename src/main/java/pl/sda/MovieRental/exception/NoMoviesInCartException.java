package pl.sda.MovieRental.exception;

public class NoMoviesInCartException extends Exception {

    public static final String DEFAULT_MESSAGE = "No movies in cart, can't checkout";

    public NoMoviesInCartException() {
        super(DEFAULT_MESSAGE);
    }
}
