package com.endava.TicketManagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateEventDto {
    private Long venueId;
    private Long eventTypeId;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
