package pl.sda.MovieRental.service;

import pl.sda.MovieRental.exception.MovieAlreadyInCartException;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.model.CopyMovie;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    void addMovie(CopyMovie copyMovie) throws MovieAlreadyInCartException;

    void removeMovie(CopyMovie copyMovie);

    List<CopyMovie> getMoviesInCart();

    void checkout() throws NoMovieInStockException;

    BigDecimal getTotal();
}