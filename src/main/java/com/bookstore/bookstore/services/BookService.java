package com.bookstore.bookstore.services;

import com.bookstore.bookstore.model.Book;

import java.util.Optional;

public interface BookService {

    Iterable<Book> listAllBooks();

    Optional<Book> getBookById(Integer id);

    Book saveBook(Book book);

    void deleteBook(Integer id);

}
