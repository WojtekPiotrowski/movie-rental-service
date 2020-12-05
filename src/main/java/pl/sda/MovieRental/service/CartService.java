package pl.sda.MovieRental.service;

import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    void addMovie(Movie movie);

    void removeMovie(Movie movie);

    List<CopyMovie> getMoviesInCart();

    void checkout() throws NoMovieInStockException;

    BigDecimal getTotal();
}
