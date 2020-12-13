package pl.sda.MovieRental.Utils;

import org.springframework.stereotype.Component;

@Component
public class UserHandler {

    public static boolean isUserLoggedIn() {
        return true; //TODO Implementacja logiki sprawdzającej zalogowanie użytkownika
    }

    public static boolean userRentedMovie(Long id) {
        return true; //TODO Implementacja logiki sprawdzającej wypożyczenie filmu przez użytkownika
    }
}
