package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.MovieRental.Utils.CartHandler;
import pl.sda.MovieRental.exception.MovieAlreadyInCartException;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.exception.NoMoviesInCartException;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.CartService;
import pl.sda.MovieRental.service.MovieService;

import java.util.List;

@RestController
@Slf4j
public class CartController {

    private final CartService cartService;
    private final MovieService movieService;
    private final CartHandler cartHandler;

    public CartController(CartService cartService, MovieService movieService, CartHandler cartHandler) {
        this.cartService = cartService;
        this.movieService = movieService;
        this.cartHandler = cartHandler;
    }

    @GetMapping("/cart")
    ResponseEntity<List<Movie>> cartContent(){
        log.info("reading cart contents");
        return ResponseEntity.ok(cartService.getMoviesInCart());
    }

    @GetMapping("/cart/addMovie/{id}")
    ResponseEntity<List<Movie>> addMovieToCart(@PathVariable("id") Long id) throws MovieAlreadyInCartException {
        log.info("adding movie to cart");
        Movie movie = cartHandler.findMovieById(id);
        if (movie == null) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        cartService.addMovie(movie);
        return cartContent();
    }

    @GetMapping("/cart/removeMovie/{id}")
    ResponseEntity<List<Movie>> removeMovieFromCart(@PathVariable("id") Long id){
        log.info("removing movie from cart");
        Movie movie = cartHandler.findMovieById(id);
        if (movie != null) cartService.removeMovie(movie);
        return cartContent();
    }

    @GetMapping("/cart/checkout")
    ResponseEntity<?> checkout() {
        ResponseEntity<?> response = cartHandler.checkoutErrorHandler();
        return response;
    }
}
