package com.bookstore.bookstore.config;

import com.bookstore.bookstore.converter.BookConverter;
import com.bookstore.bookstore.converter.CustomerConverter;
import com.bookstore.bookstore.converter.OrderConverter;
import com.bookstore.bookstore.converter.StockConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanGenerator {
    @Bean
    public BookConverter bookConverter() {
        return new BookConverter();
    }

    @Bean
    public CustomerConverter customerConverter() {
        return new CustomerConverter();
    }

    @Bean
    public OrderConverter orderConverter() {
        return new OrderConverter();
    }

    @Bean
    public StockConverter stockConverter() {
        return new StockConverter();
    }


}
