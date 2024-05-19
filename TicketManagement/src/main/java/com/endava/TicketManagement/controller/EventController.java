package com.endava.TicketManagement.controller;

import com.endava.TicketManagement.repository.model.Event;
import com.endava.TicketManagement.service.EventService;
import com.endava.TicketManagement.service.dto.CreateEventDto;
import com.endava.TicketManagement.service.dto.EventDto;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * Retrieves an event by its name.
     *
     * @param eventName the name of the event to retrieve.
     * @return the EventDto object representing the event.
     */
    @RequestMapping(value = "/findByEventName/{eventName}", method = RequestMethod.GET)
    public EventDto findByEventName(@PathVariable String eventName){
        System.out.println("Request event/findByEventName/" + eventName);
        return eventService.findByEventName(eventName);
    }

    /**
     * Retrieves an event by its venue ID and event type name.
     *
     * @param venueID the ID of the venue.
     * @param eventType the name of the event type.
     * @return the EventDto object representing the event.
     */
    @RequestMapping(value = "/findByVenueIDAndEventType/{venueID}/{eventType}",method = RequestMethod.GET)
    public EventDto findByVenueVenueIDAndEventTypeEventTypeName(@PathVariable Long venueID,@PathVariable String eventType){
        System.out.println("Request event/findByVenueIDAndEventType/"+venueID+eventType);
        return eventService.findByVenueVenueIDAndEventTypeEventTypeName(venueID,eventType);
    }

    /**
     * Retrieves a list of all events.
     *
     * @return a list of EventDto objects representing all events.
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<EventDto> findAll(){
        System.out.println("Request event/all");
        return eventService.findAll();
    }

    /**
     * Creates a new event.
     *
     * @param eventDto the DTO containing the details of the event to create.
     * @return the newly created Event object.
     */
    @PostMapping("/create")
    public Event CreateEvent(@RequestBody CreateEventDto eventDto){
        return eventService.createEvent(eventDto);
    }

    /**
     * Deletes an event by its ID.
     *
     * @param eventId the ID of the event to delete.
     * @return a ResponseEntity with HTTP status indicating success or failure.
     */
    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId){
        try{
            eventService.deleteEvent(eventId);
            System.out.println("Request event/delete/" + eventId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EntityNotFoundException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
