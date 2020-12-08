package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.MovieRental.exception.MovieAlreadyInCartException;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.CartService;
import pl.sda.MovieRental.service.MovieService;

import java.util.List;

@RestController
@Slf4j
public class CartController {

    private final CartService cartService;

    private final MovieService movieService;

    public CartController(CartService cartService, MovieService movieService) {
        this.cartService = cartService;
        this.movieService = movieService;
    }

    @GetMapping("/cart")
    ResponseEntity<List<CopyMovie>> cartContent(){
        log.info("reading cart contents");
        return ResponseEntity.ok(cartService.getMoviesInCart());
    }

    @GetMapping("/cart/addMovie/{id}")
    ResponseEntity<List<CopyMovie>> addMovieToCart(@PathVariable("id") Long id) throws NoMovieInStockException, MovieAlreadyInCartException {
        log.info("adding movie to cart");
        Movie movie = new Movie();
        movieService.findById(id).ifPresent(addMovie -> movie.setId(addMovie.getId()));
        cartService.addMovie(movieService.getCopy(movie));
        return cartContent();
    }

    @GetMapping("/cart/removeMovie/{id}")
    ResponseEntity<List<CopyMovie>> removeMovieFromCart(@PathVariable("id") Long id) throws NoMovieInStockException {
        log.info("removing movie to cart");
        Movie movie = new Movie();
        movieService.findById(id).ifPresent(removeMovie -> movie.setId(removeMovie.getId()));
        cartService.removeMovie(movieService.getCopy(movie));
        return cartContent();
    }

    @GetMapping("/cart/checkout")
    ResponseEntity<List<CopyMovie>> checkout() throws NoMovieInStockException {
        cartService.checkout();
        return cartContent();
    }
}
