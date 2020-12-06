package pl.sda.MovieRental.service.impl;


import org.springframework.stereotype.Service;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.repository.MovieRepository;
import pl.sda.MovieRental.service.MovieService;

import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }



    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }


    @Override
    public Optional<Movie> getById(Long id) {
        return movieRepository
                .findById(id);
    }


    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }


    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }


    @Override
    public void update(Movie movie) {
        movieRepository.save(movie);
    }
}
