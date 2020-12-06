package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.User;

public interface UserService {
    User findByUsername(String username);
    void save(User user);
    void deleteById(Long id);
}
