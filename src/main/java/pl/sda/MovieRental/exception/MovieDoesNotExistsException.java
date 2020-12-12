package pl.sda.MovieRental.exception;

import lombok.NoArgsConstructor;


public class MovieDoesNotExistsException extends Exception{

    public MovieDoesNotExistsException(){
        super( "This movie not exists in our collection!");
    }

}
