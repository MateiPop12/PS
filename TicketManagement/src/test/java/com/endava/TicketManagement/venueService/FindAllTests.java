package com.endava.TicketManagement.venueService;

import com.endava.TicketManagement.repository.VenueRepository;
import com.endava.TicketManagement.repository.model.Venue;
import com.endava.TicketManagement.service.implementation.VenueServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FindAllTests {

    @Mock
    private VenueRepository venueRepository;

    @InjectMocks
    private VenueServiceImplementation venueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll_WhenVenuesFound() {
        List<Venue> venues = Arrays.asList(
                new Venue(1L, "Venue A", "Concert Hall", 1000, Collections.emptyList()),
                new Venue(2L, "Venue B", "Conference Center", 500, Collections.emptyList()),
                new Venue(3L, "Venue C", "Sports Stadium", 20000, Collections.emptyList())
        );
        when(venueRepository.findAll()).thenReturn(venues);

        List<Venue> result = venueService.findAll();

        assertEquals(venues.size(), result.size());
        for (int i = 0; i < venues.size(); i++) {
            assertEquals(venues.get(i), result.get(i));
        }
    }

    @Test
    public void testFindAll_WhenNoVenuesFound() {
        when(venueRepository.findAll()).thenReturn(Collections.emptyList());

        List<Venue> result = venueService.findAll();

        assertEquals(0, result.size());
    }

}
