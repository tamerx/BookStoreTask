package com.bookstore.bookstore.services;


import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    private BookRepository bookRepository;


    @Autowired
    public void setCustomerRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Iterable<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {

        bookRepository.deleteById(id);

    }
}
