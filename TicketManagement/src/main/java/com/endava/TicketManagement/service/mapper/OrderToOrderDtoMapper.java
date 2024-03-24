package com.endava.TicketManagement.service.mapper;

import com.endava.TicketManagement.repository.model.Order;
import com.endava.TicketManagement.service.dto.OrderDto;

import java.time.format.DateTimeFormatter;

public class OrderToOrderDtoMapper {
    /**
     * Converts an Order entity to an OrderDto object.
     *
     * @param order The Order entity to be converted.
     * @return The corresponding OrderDto object.
     */
    public static OrderDto converter(Order order){
        OrderDto orderDto = new OrderDto();
        String pattern = "dd-MM-yyyy HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        orderDto.setOrderID(order.getOrderID());
        orderDto.setEventDto(EventToEventDtoMapper.converter(order.getTicketCategory().getEvent()));
        orderDto.setOrderedAt(order.getOrderedAt().format(formatter));
        orderDto.setTicketCategory(order.getTicketCategory());
        orderDto.setNumberOfTickets(order.getNumberOfTickets());
        orderDto.setTotalPrice(order.getTotalPrice());
        return orderDto;
    }
}
