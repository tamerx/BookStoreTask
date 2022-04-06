package com.bookstore.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class BookDto {
    private Long id;
    private String bookName;
    private String isbn;


}
