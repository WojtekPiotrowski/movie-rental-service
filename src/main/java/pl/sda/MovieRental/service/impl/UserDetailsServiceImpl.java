package pl.sda.MovieRental.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.MovieRental.model.Role;
import pl.sda.MovieRental.model.User;
import pl.sda.MovieRental.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDB = userRepository.findByUsername(username);
        List<String> roleLIst = new ArrayList<>();
        for (Role role : userDB.get().getRoles()) {
            roleLIst.add(role.getName());
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(userDB.get().getUsername())
                .password(userDB.get().getPassword())
                .roles(roleLIst.toArray(new String[0]))
                .build();
    }
}