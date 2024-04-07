package com.endava.TicketManagement.service.implementation;

import com.endava.TicketManagement.repository.CustomerRepository;
import com.endava.TicketManagement.repository.model.Customer;
import com.endava.TicketManagement.service.CustomerService;
import com.endava.TicketManagement.service.dto.CustomerDto;
import com.endava.TicketManagement.service.mapper.CustomerToCustomerDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImplementation(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto findByCustomerID(Long customerID) {
        return CustomerToCustomerDtoMapper.converter(customerRepository.findByCustomerID(customerID));
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream().toList();
    }

    @Override
    public void update(Long id) {
        System.out.println("Email sent");
    }

}
