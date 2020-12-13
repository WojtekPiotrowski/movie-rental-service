package pl.sda.MovieRental.price;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.model.User;
import pl.sda.MovieRental.service.MovieService;
import pl.sda.MovieRental.service.OrderService;
import pl.sda.MovieRental.service.UserService;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PriceServiceTest {

    @Autowired
    private PriceService priceService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Test
    void count_price_for_gold_type_user() {

        //given basePrice = 10
        //userType = SILVER
        //rentalDays = 69
        //movieType = 'classic'
        Movie movie = movieService.findById(100L).get();
        User user = userService.findById(1L).get();
        Order order = orderService.findById(1000L).get();

        //when
        BigDecimal price = priceService.countPrice(movie, user, order);

        //then
        assertThat(price).isEqualTo(BigDecimal.valueOf(146.63));
    }


    @Test
    void count_price_for_silver_type_user() {

        //given basePrice = 10
        //userType = GOLD
        //rentalDays = 7
        //movieType = 'premiere'
        Movie movie = movieService.findById(600L).get();
        User user = userService.findById(2L).get();
        Order order = orderService.findById(2000L).get();

        //when
        BigDecimal price = priceService.countPrice(movie, user, order);

        //then
        assertThat(price).isEqualTo(BigDecimal.valueOf(136.80));
    }
}
