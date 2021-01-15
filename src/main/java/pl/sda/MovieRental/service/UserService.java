package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long userId);

    Optional<User> findByUsername(String username);

    User save(User user);

    void deleteById(Long id);

}
