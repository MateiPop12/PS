package com.endava.TicketManagement.service;

import com.endava.TicketManagement.repository.model.Venue;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VenueService {
    List<Venue> findAll();
    Venue findById(Long id);
}
