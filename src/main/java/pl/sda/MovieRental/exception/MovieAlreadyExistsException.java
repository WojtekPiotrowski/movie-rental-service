package pl.sda.MovieRental.exception;

import lombok.NoArgsConstructor;
import pl.sda.MovieRental.model.Movie;

@NoArgsConstructor
public class MovieAlreadyExistsException extends Exception {

    public MovieAlreadyExistsException(String title){
        super(title + " This movie already exists in our collection!");
    }


}
