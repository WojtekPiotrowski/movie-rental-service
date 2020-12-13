package pl.sda.MovieRental.service;

import pl.sda.MovieRental.exception.MovieAlreadyInCartException;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.exception.NoMoviesInCartException;
import pl.sda.MovieRental.model.Movie;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CartService {

    void addMovie(Movie movie) throws MovieAlreadyInCartException;

    void removeMovie(Movie movie);

    List<Movie> getMoviesInCart();

    Optional<List<NoMovieInStockException>> checkout() throws NoMovieInStockException, NoMoviesInCartException, NoMoviesInCartException;

    BigDecimal getTotal();
}