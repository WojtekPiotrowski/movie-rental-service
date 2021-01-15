package pl.sda.MovieRental.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserHandler {

    public static boolean isUserLoggedIn() {

        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        log.info("Login user " + currentUserName);
        return true; //TODO Implementacja logiki sprawdzającej zalogowanie użytkownika
    }

    public static boolean userRentedMovie(Long id) {
        return true; //TODO Implementacja logiki sprawdzającej wypożyczenie filmu przez użytkownika
    }
}
