package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.MovieRental.model.Role;
import pl.sda.MovieRental.model.User;
import pl.sda.MovieRental.service.AutoLoginService;
import pl.sda.MovieRental.service.RoleService;
import pl.sda.MovieRental.service.UserService;


import java.net.URI;
import java.util.Arrays;

@Slf4j
@RestController
public class RegistrationController {


    private final UserService userService;
    private final RoleService roleService;
    private final AutoLoginService autoLoginService;

    public RegistrationController(final UserService userService, final RoleService roleService, final AutoLoginService autoLoginService) {
        this.userService = userService;
        this.roleService = roleService;
        this.autoLoginService = autoLoginService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/registration")
    public ResponseEntity<User> registerUserAccount(@RequestBody final User user) {

        if (userService.findByUsername(user.getUsername()).isEmpty()) {
            Role role = roleService.findByName("USER");
            user.setRoles(Arrays.asList(role));
            user.setId(user.getId());
            userService.save(user);
            log.info("Registered user: " + user.getUsername());
            autoLoginService.autoLogin(user.getUsername(),user.getPassword());

            return ResponseEntity
                    .created(URI.create("/" + user.getId()))
                    .body(user);
        }
        return ResponseEntity
                .status(HttpStatus.IM_USED)
                .build();
    }
}

