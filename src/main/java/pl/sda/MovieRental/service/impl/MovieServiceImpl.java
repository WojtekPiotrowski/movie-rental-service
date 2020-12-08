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
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }


    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository
                .findById(id);
    }


    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }


    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }


    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
/*
        Long id = 1L;
        movieRepository.findById(id)
                .map(movie1 -> {
                    movie1.setTitle(movie.getTitle());
                    movie1.setReleaseDate(movie.getReleaseDate());
                    movie1.setGenre(movie.getGenre());
                    movie1.setDescription(movie.getDescription());
                    movie1.setRateNumbers(movie.getRateNumbers());
                    movie1.setAverageRate(movie.getAverageRate());
                    movie1.setTotalCopyNumbers(movie.getTotalCopyNumbers());
                    movie1.setAvailableCopyNumbers(movie.getAvailableCopyNumbers());
                    movie1.setPrice(movie.getPrice());
                    return movieRepository.save(movie1);
                })
                .orElseGet(()->{
                    movie.setId(id);
                    return movieRepository.save(movie);
                });*/
        //movie.getId().equals(movie.getId());

    }


}
