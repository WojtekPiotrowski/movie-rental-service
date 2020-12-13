package pl.sda.MovieRental.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import pl.sda.MovieRental.Utils.OrderHandler;
import pl.sda.MovieRental.exception.MovieAlreadyInCartException;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.exception.NoMoviesInCartException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.service.CartService;
import pl.sda.MovieRental.service.CopyMovieService;
import pl.sda.MovieRental.service.MovieService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
@Slf4j
public class CartServiceImpl implements CartService {

    private final MovieService movieService;
    private final CopyMovieService copyMovieService;
    private final OrderHandler orderHandler;

    private List<Movie> movies = new ArrayList<>();

    @Autowired
    public CartServiceImpl(MovieService movieService, CopyMovieService copyMovieService, OrderHandler orderHandler) {
        this.movieService = movieService;
        this.copyMovieService = copyMovieService;
        this.orderHandler = orderHandler;
    }

    /**
     * If CopyMovie is already in the list, throw MovieAlreadyInCartException.
     * If CopyMovie is not in the list, add it
     *
     * @param movie
     * @throws MovieAlreadyInCartException
     */
    @Override
    public void addMovie(Movie movie) throws MovieAlreadyInCartException {
        if (movies.contains(movie)){
            throw new MovieAlreadyInCartException(movie);
        } else {
            movies.add(movie);
        }
    }

    /**
     * If CopyMovie is in the list, remove it.
     *
     * @param movie
     */
    @Override
    public void removeMovie(Movie movie)  {
        if (movies.contains(movie)){
            movies.remove(movie);
        }
    }

    /**
     * @return unmodifiable list of movie copies
     */
    @Override
    public List<Movie> getMoviesInCart() {
        return Collections.unmodifiableList(movies);
    }

    /**
     * Checkout will rollback if some movies are not in stock.
     *
     * @throws NoMovieInStockException
     * @return
     */
    @Override
    public Optional<List<NoMovieInStockException>> checkout() throws NoMoviesInCartException{
        if (movies.isEmpty()) throw new NoMoviesInCartException();
        List<Movie> moviesToRemoveFromCart = new ArrayList<>();
        List<NoMovieInStockException> unavailableMovies = new ArrayList<>();
        List<CopyMovie> checkoutList = new ArrayList<>();
        for (Movie entry : movies) {
            try {
                CopyMovie copyMovie = movieService.getCopy(entry);
                checkoutList.add(copyMovie);
                copyMovie.setAvailable(false);
            } catch (NoMovieInStockException e) {
                moviesToRemoveFromCart.add(entry);
                unavailableMovies.add(e);
            }
        }
        for (Movie movie : moviesToRemoveFromCart){
            movies.remove(movie);
        }
        if (!unavailableMovies.isEmpty()) {
            return Optional.of(unavailableMovies);
        }
        Order order = orderHandler.save(checkoutList);
        copyMovieService.saveAll(checkoutList);
        copyMovieService.flush();
        movies.clear();
        return Optional.empty();
    }

    @Override
    public BigDecimal getTotal() {
        return movies.stream()
                .map(Movie::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
