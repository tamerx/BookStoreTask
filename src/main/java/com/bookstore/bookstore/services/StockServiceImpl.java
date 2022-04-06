package com.bookstore.bookstore.services;

import com.bookstore.bookstore.exception.StockNotFoundException;
import com.bookstore.bookstore.model.Stock;
import com.bookstore.bookstore.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {


    private StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Iterable<Stock> listAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> getStockById(Integer id) {
        return stockRepository.findById(id);
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteStock(Integer id) {
        stockRepository.deleteById(id);

    }

    @Override
    public Stock updateStockCount(Integer discCount, Integer bookID) {
        Stock currentStock = stockRepository.findByBookId(bookID);
        if (Objects.isNull(currentStock)) {
            throw new StockNotFoundException("Stock not found for this bookId : " + bookID);
        }
        currentStock.setStockRemainingCount(currentStock.getStockRemainingCount() - discCount);
        return stockRepository.save(currentStock);
    }
}
