package pl.sda.MovieRental.Utils;

import pl.sda.MovieRental.model.CopyMovie;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.service.OrderService;

import java.util.List;

public class OrderHandler {

    private final OrderService orderService;

    public OrderHandler(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order save(List<CopyMovie> movies){
        Order order = new Order();
        order.setCopyMovies(movies);
        return orderService.save(order);
    }
}
