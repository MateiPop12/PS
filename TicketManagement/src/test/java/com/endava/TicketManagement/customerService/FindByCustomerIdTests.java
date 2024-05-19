package com.endava.TicketManagement.customerService;

import com.endava.TicketManagement.repository.CustomerRepository;
import com.endava.TicketManagement.repository.model.Customer;
import com.endava.TicketManagement.service.dto.CustomerDto;
import com.endava.TicketManagement.service.implementation.CustomerServiceImplementation;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

public class FindByCustomerIdTests {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImplementation customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByCustomerID_WhenCustomerFound() {
        Long customerId = 1L;
        Customer customer = new Customer(customerId, "John","email@gmail.com");
        when(customerRepository.findByCustomerID(customerId)).thenReturn(customer);

        CustomerDto result = customerService.findByCustomerID(customerId);

        assertEquals(customerId, result.getCustomerID());
        assertEquals(customer.getCustomerName(), result.getCustomerName());
    }

    @Test
    public void testFindByCustomerID_WhenCustomerNotFound() {
        Long customerId = 1L;
        when(customerRepository.findByCustomerID(customerId)).thenReturn(null);

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            customerService.findByCustomerID(customerId);
        });

        assertEquals("Customer not found with ID: " + customerId, exception.getMessage());
    }

    @Test
    public void testFindByCustomerID_WithNullID() {
        Long customerId = null;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            customerService.findByCustomerID(customerId);
        });

        assertEquals("CustomerID cannot be null", exception.getMessage());
    }
}
