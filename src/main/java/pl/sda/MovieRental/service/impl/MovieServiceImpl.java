package pl.sda.MovieRental.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import pl.sda.MovieRental.exception.MovieAlreadyExistsException;
import pl.sda.MovieRental.exception.MovieDoesNotExistsException;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Genre;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.repository.MovieRepository;
import pl.sda.MovieRental.service.MovieService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }




    @Override
    public Movie addMovie(Movie movie) throws MovieAlreadyExistsException {


        if (movieRepository.findByTitle(movie.getTitle()).isPresent()) {
            throw new MovieAlreadyExistsException(movie.getTitle());
        }
        return movieRepository.save(movie);
    }


    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }



    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);

}


    @Override
    public void save(Movie movie) {
            movieRepository.save(movie);

    }

    @Override
    public CopyMovie getCopy(Movie movie) throws NoMovieInStockException {
        List<CopyMovie> copies = movie.getCopies();
        Optional<CopyMovie> availableCopy = copies.stream()
                                                .filter(CopyMovie::isAvailable)
                                                .findFirst();

        if (availableCopy.isPresent()){
            return availableCopy.get();
        }

        throw new NoMovieInStockException(movie);
    }

    @Override
    public List<Movie> findAllByGenre(Genre genre) {
        return movieRepository.findAllByGenre(genre);
    }

/*       if (movies.isPresent()) {
        return Optional.of(movies.get());
    } else {
        return Optional.empty();
    }*/

    @Override
    public List<Movie> findByReleaseDateBetween(LocalDate releaseDate1, LocalDate releaseDate2) {
        return movieRepository.findByReleaseDateBetween(releaseDate1, releaseDate2);
    }




}



