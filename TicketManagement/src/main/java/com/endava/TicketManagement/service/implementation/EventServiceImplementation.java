package com.endava.TicketManagement.service.implementation;

import com.endava.TicketManagement.repository.EventRepository;
import com.endava.TicketManagement.repository.model.Event;
import com.endava.TicketManagement.service.EventService;
import com.endava.TicketManagement.service.dto.EventDto;
import com.endava.TicketManagement.service.mapper.EventToEventDtoMapper;
import jakarta.persistence.EntityNotFoundException;
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

    @Override
    public EventDto createEvent(EventDto eventDto) {
        return null;
    }

    @Override
    public void deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            eventRepository.delete(event);
        }else {
            throw new EntityNotFoundException("Event with id " + eventId + " not found");
        }
    }
}