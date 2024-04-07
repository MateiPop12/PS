package com.endava.TicketManagement.controller;

import com.endava.TicketManagement.repository.model.Venue;
import com.endava.TicketManagement.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/venue")
@CrossOrigin("http://localhost:5173")
public class VenueController {
    private final VenueService venueService;

    @Autowired
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping("/findAll")
    public List<Venue> findAll(){
        return venueService.findAll();
    }
}
