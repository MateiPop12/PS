package com.endava.TicketManagement.service.implementation;

import com.endava.TicketManagement.repository.EventTypeRepository;
import com.endava.TicketManagement.repository.model.EventType;
import com.endava.TicketManagement.service.EventTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeServiceImplementation implements EventTypeService {

    private final EventTypeRepository eventTypeRepository;

    public EventTypeServiceImplementation(EventTypeRepository eventTypeRepository) {
        this.eventTypeRepository = eventTypeRepository;
    }

    /**
     * Retrieves all event types.
     *
     * @return a list of EventType objects representing all event types
     */
    @Override
    public List<EventType> findAll() {
        return eventTypeRepository.findAll().stream().toList();
    }

    /**
     * Finds an event type by its ID.
     *
     * @param id the ID of the event type
     * @return the EventType object representing the event type
     */
    @Override
    public EventType findById(Long id) {
        return eventTypeRepository.findByEventTypeID(id);
    }
}
