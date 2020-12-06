package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.MovieService;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findById(Long id);



}
