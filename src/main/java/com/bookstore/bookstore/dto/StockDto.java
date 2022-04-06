package com.bookstore.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDto {


    private Long id;
    private Integer stockRemainingCount;
    private BookDto bookDto;


}
