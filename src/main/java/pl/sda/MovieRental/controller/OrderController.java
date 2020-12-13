package pl.sda.MovieRental.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.MovieRental.Utils.OrderHandler;
import pl.sda.MovieRental.model.Order;
import pl.sda.MovieRental.service.OrderService;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class OrderController {

    private final OrderService orderService;
    OrderHandler orderHandler;

    public OrderController(OrderService orderService, OrderHandler orderHandler) {
        this.orderService = orderService;
        this.orderHandler = orderHandler;
    }

    @GetMapping("/user/{userId}/orders")
    ResponseEntity<?> getAllOrdersForUser (@PathVariable("userId") Long userId){
        log.info("reading all orders for given user");
        return orderHandler.findAllOrdersForUser(userId);
    }

    @GetMapping("/order/{orderId}")
    ResponseEntity<?> getOrderById (@PathVariable("orderId") Long orderId) {
        log.info("reading given order");
        return orderService.findById(orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/order/{orderId}", params = "!delivery")
    ResponseEntity<?> updateOrderStatus (@PathVariable("orderId") Long orderId, @RequestParam("status") String status) {
        if (orderService.findById(orderId).isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        } else {
            return orderHandler.updateOrderStatus(orderId, status);
        }
    }

    @PutMapping(path = "/order/{orderId}", params = "!status")
    ResponseEntity<?> updateOrderDeliveryMethod (@PathVariable("orderId") Long orderId, @RequestParam("delivery") String delivery) {
        if (orderService.findById(orderId).isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        } else {
            return orderHandler.updateOrderDeliveryMethod(orderId, delivery);
        }
    }
}
