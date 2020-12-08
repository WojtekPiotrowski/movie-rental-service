package pl.sda.MovieRental.service;

import pl.sda.MovieRental.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAllOrdersByUserId(Long userId);

    List<Order> findAll();

    Optional<Order> findById(Long orderId);
}
