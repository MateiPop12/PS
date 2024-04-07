package com.endava.TicketManagement.repository;

import com.endava.TicketManagement.repository.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue,Long> {
}
