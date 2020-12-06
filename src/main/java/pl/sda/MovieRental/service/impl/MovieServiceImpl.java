package pl.sda.MovieRental.service.impl;


import org.springframework.stereotype.Service;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.repository.MovieRepository;
import pl.sda.MovieRental.service.MovieService;

import java.util.List;


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
    public Movie getById(Long id) {
        return movieRepository
                .findById(id)
                .orElse(null);
    }


    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }


    @Override
    public void delete(Long id) {
        Movie movie = getById(id);

        if(movie != null){
            movieRepository.delete(movie);
        }
    }


    @Override
    public void update(Movie movie) {
        movieRepository.save(movie);
    }
}
