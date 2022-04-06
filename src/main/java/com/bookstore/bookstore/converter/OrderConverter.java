package com.bookstore.bookstore.converter;

import com.bookstore.bookstore.dto.OrderDto;
import com.bookstore.bookstore.exception.OrderException;
import com.bookstore.bookstore.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class OrderConverter implements Converter<Order, OrderDto> {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public Order toEntity(OrderDto currentDTO) {
        if (Objects.isNull(currentDTO)) {
            throw new OrderException("ORDER DTO CAN NOT BE NULL");
        }
        Order order = new Order();
        order.setCustomer(currentDTO.getCustomer());
        if (Objects.isNull(currentDTO.getId())) {
            LOGGER.info("ORDER Customer , name is " + currentDTO.getCustomer().getCustomerName() + ", is not set id");
        } else {
            order.setId(currentDTO.getId());
        }
        return order;
    }

    @Override
    public OrderDto toDTO(Order entity) {
        if (Objects.isNull(entity)) {
            throw new OrderException("ORDER ENTITY CAN NOT BE NULL");
        }
        if (Objects.isNull(entity.getId())) {
            throw new OrderException("ORDER , NAME IS " + entity.getCustomer().getCustomerName() + ", ID CAN NOT BE NULL");
        }
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomer(entity.getCustomer());
        if (Objects.isNull(entity.getId())) {
            LOGGER.info("ORDER Customer , name is " + entity.getCustomer().getCustomerName() + ", is not set id");
        } else {
            orderDto.setId(entity.getId());
        }
        return orderDto;
    }


}
