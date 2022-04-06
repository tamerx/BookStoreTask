package com.bookstore.bookstore.converter;

import com.bookstore.bookstore.dto.CustomerDto;
import com.bookstore.bookstore.exception.BookException;
import com.bookstore.bookstore.exception.CustomerException;
import com.bookstore.bookstore.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class CustomerConverter implements Converter<Customer, CustomerDto> {


    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public Customer toEntity(CustomerDto currentDTO) {

        if (Objects.isNull(currentDTO)) {
            throw new BookException("BOOK DTO CAN NOT BE NULL");
        }
        Customer customer = new Customer();
        customer.setCustomerName(currentDTO.getCustomerName());
        customer.setBirthDay(customer.getBirthDay());

        if (Objects.isNull(currentDTO.getId())) {
            LOGGER.info("current Customer , name is " + currentDTO.getCustomerName() + ", is not set id");
        } else {
            customer.setId(currentDTO.getId());
        }
        return customer;
    }

    @Override
    public CustomerDto toDTO(Customer entity) {

        if (Objects.isNull(entity)) {
            throw new CustomerException("CUSTOMER ENTITY CAN NOT BE NULL");
        }
        if (Objects.isNull(entity.getId())) {
            throw new CustomerException("CUSTOMER  NAME IS " + entity.getCustomerName() + ", ID CAN NOT BE NULL");
        }
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName(entity.getCustomerName());
        customerDto.setBirthDay(entity.getBirthDay());


        if (Objects.isNull(entity.getId())) {
            LOGGER.info("current Customer , name is " + entity.getCustomerName() + ", is not set id");
        } else {
            customerDto.setId(entity.getId());
        }
        return customerDto;
    }


}
