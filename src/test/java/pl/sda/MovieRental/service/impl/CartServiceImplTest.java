package pl.sda.MovieRental.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.MovieRental.exception.MovieAlreadyInCartException;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.CartService;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartServiceImplTest {

    @Autowired private CartService cartService;

    @Test
    void can_add_new_movie_to_cart() throws MovieAlreadyInCartException {
        //given
        Movie movie = new Movie();
        movie.setTitle("Avatar");
        CopyMovie copyMovie = new CopyMovie();
        copyMovie.setMovie(movie);

        //when
        cartService.addMovie(copyMovie);
        Movie resultMovie = cartService.getMoviesInCart().get(0).getMovie();

        //then
        assertEquals(movie, resultMovie);
    }
    @Test
    void can_not_add_movie_that_is_already_in_cart() throws MovieAlreadyInCartException {
        //given
        Movie movie = new Movie();
        movie.setTitle("Avatar");
        CopyMovie copyMovie = new CopyMovie();
        copyMovie.setMovie(movie);

        //when
        cartService.addMovie(copyMovie);

        //then;
        assertThatThrownBy(() -> cartService.addMovie(copyMovie))
                .isInstanceOf(MovieAlreadyInCartException.class)
                .hasMessageContaining("Avatar is already in cart");
    }

    @Test
    void can_remove_Movie_from_cart() throws MovieAlreadyInCartException {
        //given
        Movie movie = new Movie();
        movie.setTitle("Avatar");
        CopyMovie copyMovie = new CopyMovie();
        copyMovie.setMovie(movie);

        //when
        cartService.addMovie(copyMovie);
        cartService.removeMovie(copyMovie);

        //then
        assertThat(cartService.getMoviesInCart()).isEmpty();
    }

    @Test
    void can_get_Movies_In_Cart() throws MovieAlreadyInCartException {
        //given
        Movie movie = new Movie();
        movie.setTitle("Avatar");
        CopyMovie copyMovie = new CopyMovie();
        copyMovie.setMovie(movie);

        //when
        cartService.addMovie(copyMovie);

        //then
        assertEquals(List.of(copyMovie), cartService.getMoviesInCart());
    }

    @Test
    void checkout() {
        //TODO checkout test implementation
    }

    @Test
    void get_total_price_of_movies_in_cart() throws MovieAlreadyInCartException {
        //given
        BigDecimal price = BigDecimal.valueOf(24.99);
        Movie movie = new Movie();
        movie.setPrice(price);
        CopyMovie copyMovie = new CopyMovie();
        copyMovie.setMovie(movie);

        //when
        cartService.addMovie(copyMovie);
        BigDecimal totalPrice = cartService.getTotal();

        //then
        assertEquals(price, totalPrice);

    }
}