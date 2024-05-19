package com.endava.TicketManagement.orderService;

import com.endava.TicketManagement.repository.OrderRepository;
import com.endava.TicketManagement.repository.model.Customer;
import com.endava.TicketManagement.repository.model.Event;
import com.endava.TicketManagement.repository.model.Order;
import com.endava.TicketManagement.repository.model.TicketCategory;
import com.endava.TicketManagement.service.dto.OrderDto;
import com.endava.TicketManagement.service.implementation.OrderServiceImplementation;
import com.endava.TicketManagement.service.mapper.OrderToOrderDtoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FindByNumberOfTicketsTests {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private Customer customer;
    @Mock
    private TicketCategory ticketCategory;
    @Mock
    private Event event;

    @InjectMocks
    private OrderServiceImplementation orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByNumberOfTickets_WhenOrdersFound() {
        int numberOfTickets = 2;
        List<Order> orders = Arrays.asList(
                new Order(1L, null, 1, 0,customer,ticketCategory),
                new Order(2L, null, 2, 0, customer, ticketCategory),
                new Order(3L, null, 3, 0, customer, ticketCategory)
        );
        when(orderRepository.findByNumberOfTickets(numberOfTickets)).thenReturn(orders);

        when(ticketCategory.getEvent()).thenReturn(event);

        List<OrderDto> result = orderService.findByNumberOfTickets(numberOfTickets);

        assertEquals(orders.size(), result.size());
        for (int i = 0; i < orders.size(); i++) {
            assertEquals(OrderToOrderDtoMapper.converter(orders.get(i)), result.get(i));
        }
    }

    @Test
    public void testFindByNumberOfTickets_WhenNoOrdersFound() {
        int numberOfTickets = 2;
        when(orderRepository.findByNumberOfTickets(numberOfTickets)).thenReturn(Collections.emptyList());

        List<OrderDto> result = orderService.findByNumberOfTickets(numberOfTickets);

        assertEquals(0, result.size());
    }
}
