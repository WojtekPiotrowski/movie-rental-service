package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<List<Order>> findAllOrdersByUserId(Long userId);

    Optional<Order> findByUserIdAndOrderId(Long userId, Long orderId);

    Optional<List<Order>> findAll();
}
