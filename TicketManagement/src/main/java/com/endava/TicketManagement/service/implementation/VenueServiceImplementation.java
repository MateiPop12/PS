package com.endava.TicketManagement.service.implementation;

import com.endava.TicketManagement.repository.VenueRepository;
import com.endava.TicketManagement.repository.model.Venue;
import com.endava.TicketManagement.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImplementation implements VenueService {

    private final VenueRepository venueRepository;

    public VenueServiceImplementation(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> findAll() {
        return venueRepository.findAll().stream().toList();
    }
}
