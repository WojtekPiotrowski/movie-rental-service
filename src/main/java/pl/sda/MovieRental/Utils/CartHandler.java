package pl.sda.MovieRental.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.exception.NoMovieInStockExceptionCollection;
import pl.sda.MovieRental.exception.NoMoviesInCartException;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.MovieService;
import pl.sda.MovieRental.service.impl.CartServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CartHandler {

    private final MovieService movieService;
    private final CartServiceImpl cartService;

    private List<String> messages = new ArrayList<>();

    public CartHandler(MovieService movieService, CartServiceImpl cartService) {
        this.movieService = movieService;
        this.cartService = cartService;
    }

    public Movie findMovieById(Long id) {
        if (movieService.findById(id).isPresent()) {
            return movieService.findById(id).get();
        } else {
            return null;
        }
    }

    public ResponseEntity<?> checkoutErrorHandler() {
        Optional<List<NoMovieInStockException>> errors;
        List<String> errorMessages = new ArrayList<>();
        try {
            errors = cartService.checkout();
            if(errors.isPresent()){
                errorMessages = errors
                        .get()
                        .stream()
                        .map(Throwable::getMessage)
                        .collect(Collectors.toList());
                }
        } catch (NoMoviesInCartException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
        if (!errorMessages.isEmpty()){
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorMessages);
        }
        return ResponseEntity
                .ok(cartService.getMoviesInCart());
    }
}

