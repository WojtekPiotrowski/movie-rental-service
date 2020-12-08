package pl.sda.MovieRental.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.MovieRental.model.CopyMovie;

import java.util.Optional;

@Repository
public interface CopyMovieRepository extends JpaRepository<CopyMovie, Long> {



   Optional<CopyMovie> findById(Long id);



}
