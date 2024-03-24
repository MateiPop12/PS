package com.endava.TicketManagement.repository;

import com.endava.TicketManagement.repository.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Event findByEventName(String name);
    Event findByVenueVenueIDAndEventTypeEventTypeName(Long venueID,String eventTypeString);
}
