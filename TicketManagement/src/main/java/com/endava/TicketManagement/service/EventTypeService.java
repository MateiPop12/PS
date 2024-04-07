package com.endava.TicketManagement.service;

import com.endava.TicketManagement.repository.model.EventType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EventTypeService {
    List<EventType> findAll();
}
