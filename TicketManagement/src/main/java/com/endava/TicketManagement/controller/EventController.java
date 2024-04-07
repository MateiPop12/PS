package com.endava.TicketManagement.controller;

import com.endava.TicketManagement.service.EventService;
import com.endava.TicketManagement.service.dto.EventDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@CrossOrigin("http://localhost:5173")
public class EventController {
    private final EventService eventService;
    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @RequestMapping(value = "/findByEventName/{eventName}", method = RequestMethod.GET)
    public EventDto findByEventName(@PathVariable String eventName){
        System.out.println("Request event/findByEventName/" + eventName);
        return eventService.findByEventName(eventName);
    }
    @RequestMapping(value = "/findByVenueIDAndEventType/{venueID}/{eventType}",method = RequestMethod.GET)
    public EventDto findByVenueVenueIDAndEventTypeEventTypeName(@PathVariable Long venueID,@PathVariable String eventType){
        System.out.println("Request event/findByVenueIDAndEventType/"+venueID+eventType);
        return eventService.findByVenueVenueIDAndEventTypeEventTypeName(venueID,eventType);
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<EventDto> findAll(){
        System.out.println("Request event/all");
        return eventService.findAll();
    }

    @PostMapping("/create")
    public EventDto CreateEvent(@RequestBody EventDto eventDto){
        return eventService.createEvent(eventDto);
    }

    @DeleteMapping("/delete/{eventId}")
    public void deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
    }
}
