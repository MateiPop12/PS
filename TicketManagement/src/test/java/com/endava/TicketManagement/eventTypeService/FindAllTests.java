package com.endava.TicketManagement.eventTypeService;

import com.endava.TicketManagement.repository.EventTypeRepository;
import com.endava.TicketManagement.repository.model.EventType;
import com.endava.TicketManagement.service.implementation.EventTypeServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FindAllTests {

    @Mock
    private EventTypeRepository eventTypeRepository;

    @InjectMocks
    private EventTypeServiceImplementation eventTypeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll_WhenEventTypesFound() {
        List<EventType> eventTypes = Arrays.asList(
                new EventType(1L, "Concert", Collections.emptyList()),
                new EventType(2L, "Conference", Collections.emptyList()),
                new EventType(3L, "Sports", Collections.emptyList())
        );
        when(eventTypeRepository.findAll()).thenReturn(eventTypes);

        List<EventType> result = eventTypeService.findAll();

        assertEquals(eventTypes.size(), result.size());
        for (int i = 0; i < eventTypes.size(); i++) {
            assertEquals(eventTypes.get(i), result.get(i));
        }
    }

    @Test
    public void testFindAll_WhenNoEventTypesFound() {
        when(eventTypeRepository.findAll()).thenReturn(Collections.emptyList());

        List<EventType> result = eventTypeService.findAll();

        assertEquals(0, result.size());
    }
}
