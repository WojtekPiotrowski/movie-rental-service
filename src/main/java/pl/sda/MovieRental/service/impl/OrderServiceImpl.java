package pl.sda.MovieRental.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderService orderService;

    public OrderServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Optional<List<Order>> findAllOrdersByUserId(Long userId) {
        return orderService.findAll();
    }

    @Override
    public Optional<Order> findByUserIdAndOrderId(Long userId, Long orderId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Order>> findAll() {
        return orderService.findAll();
    }
}
