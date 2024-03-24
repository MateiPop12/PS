package com.endava.TicketManagement.service.dto;

import lombok.Data;

@Data
public class OrderUpdateDto {
    private Long orderId;
    private Long ticketCategoryId;
    private int numberOfTickets;
}
