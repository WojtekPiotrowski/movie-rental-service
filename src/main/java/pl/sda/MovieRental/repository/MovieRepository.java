package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.MovieService;

@Repository
public interface MovieRepository extends MovieService, JpaRepository<Movie, Long> {
}
