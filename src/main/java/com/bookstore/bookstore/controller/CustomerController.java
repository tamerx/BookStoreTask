package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.converter.CustomerConverter;
import com.bookstore.bookstore.model.Customer;
import com.bookstore.bookstore.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer")
@Api(value = "Customer Controller")
public class CustomerController {


    private CustomerService customerService;
    private CustomerConverter customerConverter;


    public CustomerController(CustomerService customerService, CustomerConverter customerConverter) {
        this.customerService = customerService;
        this.customerConverter = customerConverter;
    }


    @GetMapping
    @ApiOperation(value = "Customer List Method")
    public ResponseEntity getAll() {
        List<Customer> customerEntityList = IterableUtils.toList(customerService.listAllCustomer());
        return ResponseEntity.ok(customerConverter.toDtoList(customerEntityList));
    }


    @PostMapping
    @ApiOperation(value = "New Customer adding method")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return ResponseEntity.ok(customer);
    }

}
