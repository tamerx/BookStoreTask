package com.bookstore.bookstore.controller;


import com.bookstore.bookstore.converter.BookConverter;
import com.bookstore.bookstore.dto.BookDto;
import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@Api(value = "Book Controller")
public class BookController {

    private BookService bookService;
    private BookConverter bookConverter;

    public BookController(BookService bookService, BookConverter bookConverter) {
        this.bookService = bookService;
        this.bookConverter = bookConverter;
    }

    @GetMapping
    @ApiOperation(value = "Book List Method")
    public ResponseEntity<List<BookDto>> getAll() {
        List<Book> bookEntityList = IterableUtils.toList(bookService.listAllBooks());
        return ResponseEntity.ok(bookConverter.toDtoList(bookEntityList));
    }


    @PostMapping
    @ApiOperation(value = "New Book adding method")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return ResponseEntity.ok(book);
    }


}
