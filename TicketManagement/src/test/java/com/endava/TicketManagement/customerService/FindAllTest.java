package com.endava.TicketManagement.customerService;

import com.endava.TicketManagement.repository.CustomerRepository;
import com.endava.TicketManagement.repository.model.Customer;
import com.endava.TicketManagement.service.implementation.CustomerServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FindAllTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImplementation customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll_WhenCustomersFound() {
        List<Customer> customers = Arrays.asList(
                new Customer(1L, "John","email1@gmail.com"),
                new Customer(2L, "Alice","email2@gmail.com"),
                new Customer(3L, "Bob","email3@gmail.com")
        );
        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> result = customerService.findAll();

        assertEquals(customers.size(), result.size());
        for (int i = 0; i < customers.size(); i++) {
            assertEquals(customers.get(i), result.get(i));
        }
    }

    @Test
    public void testFindAll_WhenNoCustomersFound() {
        when(customerRepository.findAll()).thenReturn(Collections.emptyList());

        List<Customer> result = customerService.findAll();

        assertEquals(0, result.size());
    }

}
