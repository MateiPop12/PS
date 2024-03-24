package com.endava.TicketManagement.service;

import com.endava.TicketManagement.service.dto.OrderDto;
import com.endava.TicketManagement.service.dto.OrderRequestDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderService {
    List<OrderDto> findByNumberOfTickets(int numberOfTickets);
    OrderDto findByCustomerCustomerID(Long customerID);
    List<OrderDto> findAll();
    OrderDto createOrder(OrderRequestDto orderDto, Long orderID);
    OrderDto updateOrder(Long orderID, Long newTicketCategoryID, int newNumberOfTickets);
    void deleteOrder(Long orderID);
}
