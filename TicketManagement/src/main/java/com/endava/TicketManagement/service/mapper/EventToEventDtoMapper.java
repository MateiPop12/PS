package com.endava.TicketManagement.service.mapper;

import com.endava.TicketManagement.repository.model.Event;
import com.endava.TicketManagement.service.dto.EventDto;

import java.time.format.DateTimeFormatter;

public class EventToEventDtoMapper {
    public static EventDto converter(Event event){
        EventDto eventDto = new EventDto();

        String pattern = "dd-MM-yyyy HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        eventDto.setEventID(event.getEventID());
        eventDto.setVenue(event.getVenue());
//        eventDto.setType(event.getEventType().getEventTypeName());
        eventDto.setEventDescription(event.getEventDescription());
        eventDto.setEventName(event.getEventName());
        eventDto.setEventStartDate(event.getEventStartDate().format(formatter));
        eventDto.setEventEndDate(event.getGetEventEndDate().format(formatter));
        eventDto.setTicketCategoryList(event.getTicketCategoryList());
        return  eventDto;
    }
}
