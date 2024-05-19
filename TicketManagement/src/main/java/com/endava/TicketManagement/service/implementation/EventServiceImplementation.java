package com.endava.TicketManagement.service.implementation;

import com.endava.TicketManagement.repository.EventRepository;
import com.endava.TicketManagement.repository.model.Event;
import com.endava.TicketManagement.repository.model.EventType;
import com.endava.TicketManagement.repository.model.Venue;
import com.endava.TicketManagement.service.EventService;
import com.endava.TicketManagement.service.EventTypeService;
import com.endava.TicketManagement.service.VenueService;
import com.endava.TicketManagement.service.dto.CreateEventDto;
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
    private final VenueService venueService;
    private final EventTypeService eventTypeService;

    @Autowired
    public EventServiceImplementation(EventRepository eventRepository, VenueService venueService, EventTypeService eventTypeService){
        this.eventRepository = eventRepository;
        this.venueService = venueService;
        this.eventTypeService = eventTypeService;
    }

    /**
     * Finds an event by its name.
     *
     * @param eventName the name of the event
     * @return the EventDto representing the event
     */
    @Override
    public EventDto findByEventName(String eventName) {
        return EventToEventDtoMapper.converter(eventRepository.findByEventName(eventName));
    }

    /**
     * Finds an event by its venue ID and event type name.
     *
     * @param venueID  the ID of the venue
     * @param eventType the name of the event type
     * @return the EventDto representing the event
     */
    @Override
    public EventDto findByVenueVenueIDAndEventTypeEventTypeName(Long venueID, String eventType) {
        return EventToEventDtoMapper.converter(eventRepository.findByVenueVenueIDAndEventTypeEventTypeName(venueID,eventType));
    }

    /**
     * Retrieves all events.
     *
     * @return a list of EventDto objects representing all events
     */
    @Override
    public List<EventDto> findAll() {
        return eventRepository.findAll().stream().map(EventToEventDtoMapper::converter).collect(Collectors.toList());
    }

    /**
     * Creates a new event.
     *
     * @param createEventDto the data transfer object containing the event details
     * @return the created Event entity
     */
    @Override
    public Event createEvent(CreateEventDto createEventDto) {

        Event newEvent = new Event();
        Venue newEventVenue = venueService.findById(createEventDto.getVenueId());
        EventType newEventEventType = eventTypeService.findById(createEventDto.getEventTypeId());
        newEvent.setVenue(newEventVenue);
        newEvent.setEventType(newEventEventType);
        newEvent.setEventName(createEventDto.getName());
        newEvent.setEventDescription(createEventDto.getDescription());
        newEvent.setEventStartDate(createEventDto.getStartDate());
        newEvent.setEventEndDate(createEventDto.getEndDate());
        return eventRepository.save(newEvent);
    }

    /**
     * Deletes an event by its ID.
     *
     * @param eventId the ID of the event to be deleted
     * @throws EntityNotFoundException if the event with the specified ID is not found
     */
    @Override
    public void deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
        System.out.println(event.getEventID().toString());

        eventRepository.delete(event);
        System.out.println("event deleted successfully");
    }
}