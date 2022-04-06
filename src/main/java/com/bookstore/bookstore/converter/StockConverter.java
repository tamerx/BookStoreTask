package com.bookstore.bookstore.converter;

import com.bookstore.bookstore.dto.StockDto;
import com.bookstore.bookstore.exception.StockException;
import com.bookstore.bookstore.model.Stock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class StockConverter implements Converter<Stock, StockDto> {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public Stock toEntity(StockDto currentDTO) {
        if (Objects.isNull(currentDTO)) {
            throw new StockException("STOCK DTO CAN NOT BE NULL");
        }
        Stock stock = new Stock();
        stock.setStockRemainingCount(currentDTO.getStockRemainingCount());


        if (Objects.isNull(currentDTO.getId())) {
            LOGGER.info("STOCK Bookname is " + stock.getBook().getStock() + ", is not set id");
        } else {
            stock.setId(currentDTO.getId());
        }
        return stock;
    }

    @Override
    public StockDto toDTO(Stock entity) {
        if (Objects.isNull(entity)) {
            throw new StockException("STOCK ENTITY CAN NOT BE NULL");
        }
        if (Objects.isNull(entity.getId())) {
            throw new StockException("STOCK Bookname IS " + entity.getBook().getBookName() + ", ID CAN NOT BE NULL");
        }
        StockDto stockDto = new StockDto();
        stockDto.setStockRemainingCount(entity.getStockRemainingCount());
        if (Objects.isNull(entity.getId())) {
            LOGGER.info("STOCK Customer , name is " + entity.getBook().getBookName() + ", is not set id");
        } else {
            stockDto.setId(entity.getId());
        }
        return stockDto;
    }
}
