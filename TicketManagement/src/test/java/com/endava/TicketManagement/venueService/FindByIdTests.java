package com.endava.TicketManagement.venueService;

import com.endava.TicketManagement.repository.VenueRepository;
import com.endava.TicketManagement.repository.model.Venue;
import com.endava.TicketManagement.service.implementation.VenueServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class FindByIdTests {


    @Mock
    private VenueRepository venueRepository;

    @InjectMocks
    private VenueServiceImplementation venueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById_WhenVenueFound() {
        Venue venue = new Venue(1L, "Venue A", "Concert Hall", 1000, Collections.emptyList());
        when(venueRepository.findByVenueID(1L)).thenReturn(venue);

        Venue result = venueService.findById(1L);

        assertEquals(venue, result);
    }

    @Test
    public void testFindById_WhenVenueNotFound() {
        when(venueRepository.findByVenueID(1L)).thenReturn(null);

        Venue result = venueService.findById(1L);

        assertEquals(null, result);
    }

    @Test
    public void testFindById_WhenRepositoryThrowsException() {
        when(venueRepository.findByVenueID(1L)).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> venueService.findById(1L));
    }
}
