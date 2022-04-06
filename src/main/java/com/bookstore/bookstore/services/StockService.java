package com.bookstore.bookstore.services;

import com.bookstore.bookstore.model.Stock;

import java.util.Optional;

public interface StockService {


    Iterable<Stock> listAllStocks();

    Optional<Stock> getStockById(Integer id);

    Stock saveStock(Stock stock);

    void deleteStock(Integer id);

    Stock updateStockCount(Integer discCount, Integer bookID);


}
