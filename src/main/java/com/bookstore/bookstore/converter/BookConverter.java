package com.bookstore.bookstore.converter;

import com.bookstore.bookstore.dto.BookDto;
import com.bookstore.bookstore.exception.BookException;
import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.repositories.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Objects;


public class BookConverter implements Converter<Book, BookDto> {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public Book toEntity(BookDto currentDTO) {
        if (Objects.isNull(currentDTO)) {
            throw new BookException("BOOK DTO CAN NOT BE NULL");
        }
        Book book = new Book();
        book.setBookName(currentDTO.getBookName());
        book.setIsbn(currentDTO.getIsbn());
        if (Objects.isNull(currentDTO.getId())) {
            LOGGER.info("current Book , name is " + currentDTO.getBookName() + ", is not set id");
        } else {
            book.setId(currentDTO.getId());
        }
        return book;
    }

    @Override
    public BookDto toDTO(Book entity) {
        if (Objects.isNull(entity)) {
            throw new BookException("BOOK ENTITY CAN NOT BE NULL");
        }
        if (Objects.isNull(entity.getId())){
            throw new BookException("BOOK , NAME IS "+entity.getBookName()+", ID CAN NOT BE NULL");
        }
        BookDto bookDto = new BookDto();
        bookDto.setBookName(entity.getBookName());
        bookDto.setIsbn(entity.getIsbn());

        if (Objects.isNull(entity.getId())) {
            LOGGER.info("current Book , name is " + entity.getBookName() + ", is not set id");
        } else {
            bookDto.setId(entity.getId());
        }
        return bookDto;
    }
}
