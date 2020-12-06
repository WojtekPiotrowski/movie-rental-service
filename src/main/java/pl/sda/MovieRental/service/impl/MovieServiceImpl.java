package pl.sda.MovieRental.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.MovieRental.exception.NoMovieInStockException;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.repository.MovieRepository;
import pl.sda.MovieRental.service.MovieService;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public CopyMovie getCopy(Movie movie) throws NoMovieInStockException {
        throw new NoMovieInStockException();
        //TODO method to get an available copy of given movie, if there is no copy, throw exception
    }
}
