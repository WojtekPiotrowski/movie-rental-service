package pl.sda.MovieRental.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.model.StatusOrder;
import pl.sda.MovieRental.model.User;
import pl.sda.MovieRental.service.OrderService;
import pl.sda.MovieRental.service.UserService;

import java.util.List;
import java.util.Optional;

@Component
public class OrderHandler {

    private final OrderService orderService;
    private final UserService userService;

    public OrderHandler(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    public Order save(List<CopyMovie> movies){
        Order order = new Order();
        order.setCopyMovies(movies);
        return orderService.save(order);
    }

    public ResponseEntity<?> findAllOrdersForUser(Long userId) {
        return userService.findById(userId)
                .map(user -> ResponseEntity
                        .ok(user.getOrders()))
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }

    public ResponseEntity<?> updateOrderStatus(Long orderId, String status) {
        Order orderUpdated = orderService.findById(orderId).get();
        orderUpdated.setId(orderId);
        orderUpdated.setStatusOrder(StatusOrder.valueOf(status));
        return ResponseEntity
                .noContent()
                .build();
    }
}
