package com.endava.TicketManagement.service.dto;

import com.endava.TicketManagement.repository.model.TicketCategory;
import com.endava.TicketManagement.repository.model.Venue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonSerialize
public class EventDto {
    private Long eventID;
    private Venue venue;
//    private String type;
    private String eventDescription;
    private String eventName;
    private String eventStartDate;
    private String eventEndDate;
    private List<TicketCategory> ticketCategoryList;
}
