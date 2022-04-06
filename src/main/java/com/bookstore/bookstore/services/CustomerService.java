package com.bookstore.bookstore.services;

import com.bookstore.bookstore.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Iterable<Customer> listAllCustomer();

    Optional<Customer> getCustomerById(Integer id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
