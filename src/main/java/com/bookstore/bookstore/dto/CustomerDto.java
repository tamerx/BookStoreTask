package com.bookstore.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String customerName;
    private Date birthDay;
    private List<OrderDto> orderList= new ArrayList<>();
}