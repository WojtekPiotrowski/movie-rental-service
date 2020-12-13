/*
package pl.sda.MovieRental.price;

import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.model.User;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PriceList {

    public BigDecimal countPrice(Movie movie, User user, Order order) {
        BigDecimal basePrice = movie.getPrice();
        return basePrice
                .multiply(getMultiplicationFactorForReleaseDay(movie))
                .multiply(getMultiplicationFactorForRentalTime(order))
                .multiply(getMultiplicationFactorForUserType(user));
    }

    private static BigDecimal getMultiplicationFactorForRentalTime(Order order) {
        long days = Duration.between(order.getCreateDate(), LocalDateTime.now()).toDays();
        if (days < 3) {
            return BigDecimal.valueOf(2);
        } else if (days < 6) {
            return BigDecimal.valueOf(1);
        } else return BigDecimal.valueOf(0.5);
    }

    private static BigDecimal getMultiplicationFactorForUserType(User user) {
        switch (user.getUserType()) {
            case GOLD:
                return BigDecimal.valueOf(0.95);
            case SILVER:
                return BigDecimal.valueOf(0.85);
            default:
                return BigDecimal.valueOf(0.7);
        }
    }

    private static BigDecimal getMultiplicationFactorForReleaseDay(Movie movie) {
        int days = (int) Duration.between(movie.getReleaseDate(), LocalDate.now()).toDays();

        if (days < 14) {
            return BigDecimal.valueOf(3);
        } else if (days < 90) {
            return BigDecimal.valueOf(2);
        } else if (days < 365) {
            return BigDecimal.valueOf(1);
        } else return BigDecimal.valueOf(0.5);
    }
}


*/
