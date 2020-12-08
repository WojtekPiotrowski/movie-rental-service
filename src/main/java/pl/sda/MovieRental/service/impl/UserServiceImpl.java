package pl.sda.MovieRental.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sda.MovieRental.model.User;
import pl.sda.MovieRental.repository.UserRepository;
import pl.sda.MovieRental.service.UserService;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }


    @Override
    public void deleteById(Long id) {
        log.info("Deleting user with all inner objects");
        userRepository.deleteById(id);
    }
}
