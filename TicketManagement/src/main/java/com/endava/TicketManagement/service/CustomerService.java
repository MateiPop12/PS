package com.endava.TicketManagement.service;

import com.endava.TicketManagement.repository.model.Customer;
import com.endava.TicketManagement.service.dto.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerService{
    CustomerDto findByCustomerID(Long customerID);
    List<Customer> findAll();
}
