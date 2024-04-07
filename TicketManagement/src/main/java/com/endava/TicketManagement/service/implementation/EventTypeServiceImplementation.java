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

    @Override
    public List<EventType> findAll() {
        return eventTypeRepository.findAll().stream().toList();
    }
}
