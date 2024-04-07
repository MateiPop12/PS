package com.endava.TicketManagement.controller;

import com.endava.TicketManagement.repository.model.EventType;
import com.endava.TicketManagement.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eventType")
@CrossOrigin("http://localhost:5173")
public class EventTypeController {
    private final EventTypeService eventTypeService;

    @Autowired
    public EventTypeController(EventTypeService eventTypeService) {
        this.eventTypeService = eventTypeService;
    }

    @GetMapping("/findAll")
    public List<EventType> findAll() {
        return eventTypeService.findAll();
    }
}
