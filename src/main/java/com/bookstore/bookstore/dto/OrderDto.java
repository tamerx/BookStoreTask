package com.bookstore.bookstore.dto;

import com.bookstore.bookstore.model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class OrderDto {

    private Long id;
    private Customer customer;
    private boolean orderStatus;
    private List<BookDto> bookDtoList;


}
