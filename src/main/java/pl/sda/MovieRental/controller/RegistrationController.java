package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.MovieRental.model.User;
import pl.sda.MovieRental.service.UserService;

import java.net.URI;

@Slf4j
@RestController
public class RegistrationController {


    private final UserService userService;


    public RegistrationController(final UserService userService) {
        this.userService = userService;

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/registration")
    public ResponseEntity<User> registerUserAccount(@RequestBody final User user) {

        if (userService.findByUsername(user.getUsername()).isEmpty()) {
            User newUser = userService.save(user);
            newUser.setAddress(user.getAddress());
            log.info("Registered user");
            return ResponseEntity
                    .created(URI.create("/" + newUser.getId()))
                    .body(newUser);
        }
        return ResponseEntity
                .status(HttpStatus.ALREADY_REPORTED)
                .build();
    }


}

