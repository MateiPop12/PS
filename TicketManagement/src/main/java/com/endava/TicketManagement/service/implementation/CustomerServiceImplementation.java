package com.endava.TicketManagement.service.implementation;

import com.endava.TicketManagement.repository.CustomerRepository;
import com.endava.TicketManagement.repository.model.Customer;
import com.endava.TicketManagement.service.CustomerService;
import com.endava.TicketManagement.service.SubscriberService;
import com.endava.TicketManagement.service.dto.CustomerDto;
import com.endava.TicketManagement.service.mapper.CustomerToCustomerDtoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService, SubscriberService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImplementation(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    /**
     * Retrieves a customer DTO by customer ID.
     *
     * @param customerID The ID of the customer to retrieve.
     * @return The CustomerDto corresponding to the provided customer ID.
     */
    @Override
    public CustomerDto findByCustomerID(Long customerID) {
        if(customerID == null)
            throw new IllegalArgumentException("CustomerID cannot be null");

        Customer customer = customerRepository.findByCustomerID(customerID);
        if (customer == null) {
            throw new EntityNotFoundException("Customer not found with ID: " + customerID);
        }

        return CustomerToCustomerDtoMapper.converter(customer);
    }

    /**
     * Retrieves all customers.
     *
     * @return A list of Customer objects representing all customers.
     */
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll().stream().toList();
    }

    /**
     * Updates a customer's information.
     *
     * @param id The ID of the customer to update.
     */
    @Override
    public void updateSubscriber(Long id) {
        System.out.println("Emails sent");
    }
}
