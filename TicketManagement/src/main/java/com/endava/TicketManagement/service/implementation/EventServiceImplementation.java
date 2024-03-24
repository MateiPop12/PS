package com.endava.TicketManagement.service.implementation;

import com.endava.TicketManagement.repository.EventRepository;
import com.endava.TicketManagement.service.EventService;
import com.endava.TicketManagement.service.dto.EventDto;
import com.endava.TicketManagement.service.mapper.EventToEventDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImplementation implements EventService{

    private final EventRepository eventRepository;
    @Autowired
    public EventServiceImplementation(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    @Override
    public EventDto findByEventName(String eventName) {
        return EventToEventDtoMapper.converter(eventRepository.findByEventName(eventName));
    }
    @Override
    public EventDto findByVenueVenueIDAndEventTypeEventTypeName(Long venueID, String eventType) {
        return EventToEventDtoMapper.converter(eventRepository.findByVenueVenueIDAndEventTypeEventTypeName(venueID,eventType));
    }
    @Override
    public List<EventDto> findAll() {
        return eventRepository.findAll().stream().map(EventToEventDtoMapper::converter).collect(Collectors.toList());
    }
}