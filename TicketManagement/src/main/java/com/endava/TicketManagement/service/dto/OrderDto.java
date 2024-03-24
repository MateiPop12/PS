package com.endava.TicketManagement.service.dto;

import com.endava.TicketManagement.repository.model.TicketCategory;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonSerialize
public class OrderDto {
    private Long orderID;
    private EventDto eventDto;
    private String orderedAt;
    private TicketCategory ticketCategory;
    private int numberOfTickets;
    private float totalPrice;
}
