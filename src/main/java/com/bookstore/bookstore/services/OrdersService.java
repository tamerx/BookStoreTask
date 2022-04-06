package com.bookstore.bookstore.services;

import com.bookstore.bookstore.model.Order;

import java.util.Optional;

public interface OrdersService {

    Iterable<Order> listOrders();

    Optional<Order> getOrderById(Integer id);

    Order saveOrder(Order order);

    void deleteOrder(Integer id);
}
