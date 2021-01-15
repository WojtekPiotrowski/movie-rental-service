package pl.sda.MovieRental.exception;

import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.model.User;

public class NoUserInStockException extends Exception {

      public static final String DEFAULT_MESSAGE = "No user in stock";

    public NoUserInStockException() {
        super(DEFAULT_MESSAGE);
    }

    public NoUserInStockException(User user){
        super(String.format("No %s user in stock.", user.getUsername()));
    }
}
