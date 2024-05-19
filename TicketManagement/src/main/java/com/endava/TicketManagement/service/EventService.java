package com.endava.TicketManagement.service;

import com.endava.TicketManagement.repository.model.Event;
import com.endava.TicketManagement.service.dto.CreateEventDto;
import com.endava.TicketManagement.service.dto.EventDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EventService {
    EventDto findByEventName(String name);
    EventDto findByVenueVenueIDAndEventTypeEventTypeName(Long venueID,String eventType);
    List<EventDto> findAll();
    Event createEvent(CreateEventDto createEventDto);
    void deleteEvent(Long eventId);
}
