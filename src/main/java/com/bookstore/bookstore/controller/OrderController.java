package com.bookstore.bookstore.controller;


import com.bookstore.bookstore.converter.OrderConverter;
import com.bookstore.bookstore.model.Order;
import com.bookstore.bookstore.services.OrdersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Api(value = "Orders Controller")
public class OrderController {


    private OrdersService ordersService;
    private OrderConverter orderConverter;

    public OrderController(OrdersService ordersService, OrderConverter orderConverter) {
        this.ordersService = ordersService;
        this.orderConverter = orderConverter;
    }

    @GetMapping
    @ApiOperation(value = "Order List Method")
    public ResponseEntity getAll() {
        List<Order> orderEntitiyList = IterableUtils.toList(ordersService.listOrders());
        return ResponseEntity.ok(orderConverter.toDtoList(orderEntitiyList));
    }


    @PostMapping
    @ApiOperation(value = "New Order adding method")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        ordersService.saveOrder(order);
        return ResponseEntity.ok(order);
    }

}
