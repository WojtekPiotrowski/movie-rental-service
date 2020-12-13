package pl.sda.MovieRental.price;

import org.springframework.stereotype.Component;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.model.User;
import pl.sda.MovieRental.model.UserTypeEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class PriceService {

    public BigDecimal countPrice(Movie movie, User user, Order order) {
        long days = ChronoUnit.DAYS.between(order.getCreateDate().toLocalDate(), LocalDate.now());

        BigDecimal basePrice = movie.getPrice();
        BigDecimal price = basePrice.multiply(getMultiplicationFactorForReleaseDay(movie))
                .multiply(getMultiplicationFactorForRentalTime(order))
                .multiply(getMultiplicationFactorForUserType(user))
                .multiply(BigDecimal.valueOf(days));

        return price.setScale(2, RoundingMode.CEILING);
    }

    public BigDecimal getMultiplicationFactorForRentalTime(Order order) {
        long days = Duration.between(order.getCreateDate(), LocalDateTime.now()).toDays();
        if (days < 3) {
            return BigDecimal.valueOf(2);
        } else if (days < 6) {
            return BigDecimal.valueOf(1);
        } else return BigDecimal.valueOf(0.5);
    }

    public BigDecimal getMultiplicationFactorForUserType(User user) {
        UserTypeEnum orders = user.getUserType();

        if (orders.equals(UserTypeEnum.SILVER)) {
            return BigDecimal.valueOf(0.95);
        } else if (orders.equals(UserTypeEnum.GOLD))
            return BigDecimal.valueOf(0.85);
        else
            return BigDecimal.valueOf(0.7);
    }

    public BigDecimal getMultiplicationFactorForReleaseDay(Movie movie) {
        long days = ChronoUnit.DAYS.between(movie.getReleaseDate(), LocalDate.now());
        if (days < 14) {
            return BigDecimal.valueOf(3);
        } else if (days < 90) {
            return BigDecimal.valueOf(2);
        } else if (days < 365) {
            return BigDecimal.valueOf(1);
        } else return BigDecimal.valueOf(0.5);
    }

    public long days(Order order) {
        return ChronoUnit.DAYS.between(order.getCreateDate().toLocalDate(), LocalDate.now());
    }
}
