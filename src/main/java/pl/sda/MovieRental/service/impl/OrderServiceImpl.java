package pl.sda.MovieRental.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.repository.OrderRepository;
import pl.sda.MovieRental.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderService) {
        this.orderRepository = orderService;
    }

    @Override
    public List<Order> findAllOrdersByUserId(Long userId) {
        return orderRepository.findAllOrdersByUserId(userId);
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        return orderRepository.findById(orderId);
    }
}
