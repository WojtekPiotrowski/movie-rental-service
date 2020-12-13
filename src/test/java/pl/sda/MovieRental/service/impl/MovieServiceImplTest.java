package pl.sda.MovieRental.service.impl;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import pl.sda.MovieRental.exception.MovieAlreadyExistsException;
import pl.sda.MovieRental.exception.MovieDoesNotExistsException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.CopyMovieService;
import pl.sda.MovieRental.service.MovieService;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class MovieServiceImplTest {


    @Autowired
    private MovieService movieService;

    @Autowired
    private CopyMovieService copyMovieService;

    private List<CopyMovie> copies;

    @Test
    void can_add_new_movie_to_rent() throws Exception {

        //given
        Movie movie = new Movie();
        movie.setTitle("Star Wars");


        //when
       Optional<Movie> addMovie = Optional.ofNullable(movieService.addMovie(movie));
        Optional<Movie> resultMovie = movieService.findByTitle(movie.getTitle());


        //then
       Assertions.assertThat(addMovie.hashCode()).isEqualTo(resultMovie.hashCode());
       //assertEquals(resultMovie.hashCode(), addMovie.hashCode());  // ten zapis też działa, tylko wykorzystuje inną klasę

    }

    @Test
    void cannot_add_movie_that_already_exists_to_rent() throws Exception {

        //given
        Movie movie = new Movie();
        movie.setTitle("Iron Man");


        //when
        movieService.addMovie(movie);

        //then
        assertThatThrownBy(()-> movieService.addMovie(movie))
                .isInstanceOf(MovieAlreadyExistsException.class)
                .hasMessageContaining("This movie already exists in our collection!");

     /*   assertThatExceptionOfType(MovieAlreadyExistsException.class)   //ten zapis nie działa ale nie wiem dlaczego
                .isThrownBy(()->movieService.addMovie(movie))
                .withMessage(" This movie already exists in our collection!");*/

    }

    @Test
    void can_find_movie_by_id() throws Exception {

        //given
        Movie movie = new Movie();
        movie.setTitle("Avatar");

        //when
        Long movieID = movieService.addMovie(movie).getId();
        movieService.findById(movieID);

        //then
        assertThat((movieService.findById(movieID)).isPresent());

    }



    @Test
    void can_find_movie_by_title() throws Exception{

        //given
        Movie movie = new Movie();
        movie.setTitle("Harry Potter");
        movie.setCopies(copyMovieService.findAll());

        //when
        Optional<Movie> movie1 = Optional.ofNullable(movieService.addMovie(movie));
        Optional<Movie> wantedMovie = movieService.findByTitle("Harry Potter");


        //then
        assertThat(movie1.hashCode()).isEqualTo(wantedMovie.hashCode());

    }




    @Test
    void can_find_all_movies_in_the_list() throws Exception{

        //give
        Movie input1 = new Movie();
        input1.setTitle("The Lord of the Rings");
        input1.setCopies(List.of());
        Movie input2 = new Movie();
        input2.setTitle("Last Samurai");
        input2.setCopies(List.of());




        List<Movie> movies;
        movies = movieService.findAll();
        movies.add(input1);
        movies.add(input2);


        //when
        Movie movie1 = movieService.addMovie(input1);
        Movie movie2 = movieService.addMovie(input2);
        List<Movie> result = movieService.findAll();


        //then
        assertEquals(movies.hashCode(), result.hashCode());


    }


    @Test
    void can_delete_movie_by_id_from_rental() throws Exception {

        //given
        Movie movie = new Movie();


        //when
        Long addedMovieId= movieService.addMovie(movie).getId();
        movieService.deleteById(addedMovieId);


         //then
        assertThat(movieService.findById(addedMovieId).isEmpty());


    }


    @Test
    void can_update_existing_movie() {

        //given
        Movie movie1 = new Movie();
        movie1.setTitle("Avatar");
        movieService.save(movie1);
        Long movieId = movie1.getId();

        //when
        Movie movie2 = new Movie();
        movie2.setId(movieId);
        movie2.setTitle("Star Wars");
        movieService.save(movie2);



        //then
        assertThat(movie1.getTitle()).isNotEqualTo(movie2.getTitle());
        assertThat(movie1.getId()).isEqualTo(movie2.getId());


    }




 /*   @Test
    void can_not_update_movie_which_not_exists() {


        if( movieService.findById(id).isPresent()) {
            movie.setId(id);
            movieService.save(movie);
            log.info("movie " + movie + "has been updated");
            return ResponseEntity
                    .noContent()
                    .build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/


       /* @Test
    void cannot_find_movie_by_id_which_not_exists() throws Exception {

        //given
        Movie movie = new Movie();


        assertThatThrownBy(()->movieService.findById(2L))                   //when
                .isInstanceOf(MovieDoesNotExistsException.class)            //then
                .hasMessageContaining("This movie not exists in our collection!");


    }*/

  /*  @Test
    void cannot_find_movie_by_title_which_not_exists() {
        //given
        Movie movie = new Movie();

        assertThatThrownBy(()->movieService.findByTitle("Avatar"))                   //when
                .isInstanceOf(MovieDoesNotExistsException.class)                     //then
                .hasMessageContaining("This movie not exists in our collection!");

    }*/
}