package com.bookstore.bookstore.repositories;

import com.bookstore.bookstore.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByBookId(Integer bookID);
}