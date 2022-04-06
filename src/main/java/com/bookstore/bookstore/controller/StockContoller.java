package com.bookstore.bookstore.controller;


import com.bookstore.bookstore.converter.StockConverter;
import com.bookstore.bookstore.model.Stock;
import com.bookstore.bookstore.services.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@Api(value = "Stock Controller")
public class StockContoller {


    private StockService stockService;
    private StockConverter stockConverter;

    public StockContoller(StockService stockService, StockConverter stockConverter) {
        this.stockService = stockService;
        this.stockConverter = stockConverter;
    }

    @GetMapping
    @ApiOperation(value = "Stock List Method")
    public ResponseEntity getAll() {
        List<Stock> stockEntityList = IterableUtils.toList(stockService.listAllStocks());
        return ResponseEntity.ok(stockConverter.toDtoList(stockEntityList));
    }


    @PostMapping
    @ApiOperation(value = "New Stock adding method")
    public ResponseEntity<Stock> saveStock(@RequestBody Stock stock) {
        stockService.saveStock(stock);
        return ResponseEntity.ok(stock);
    }


    @PutMapping
    @ApiOperation(value = " Stock update method")
    public ResponseEntity<Stock> updateStockCount(@RequestBody Integer disCount, @RequestBody Integer bookID) {
        Stock stock = stockService.updateStockCount(disCount, bookID);
        return ResponseEntity.ok(stock);
    }


}
