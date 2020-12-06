package pl.sda.MovieRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.MovieRental.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsername(String username);

    void delete(Optional<User> user);
}
