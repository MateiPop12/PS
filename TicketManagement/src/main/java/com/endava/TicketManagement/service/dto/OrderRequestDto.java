package com.endava.TicketManagement.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonDeserialize
public class OrderRequestDto {
    private Long eventID;
    private Long ticketCategoryID;
    private int numberOfTickets;
}
