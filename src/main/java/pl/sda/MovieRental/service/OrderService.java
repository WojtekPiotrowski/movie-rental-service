package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> findById(Long orderId);

    Order save(Order order);
}
