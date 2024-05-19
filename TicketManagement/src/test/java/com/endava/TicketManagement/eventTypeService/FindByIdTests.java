package com.endava.TicketManagement.eventTypeService;

import com.endava.TicketManagement.repository.EventTypeRepository;
import com.endava.TicketManagement.repository.model.EventType;
import com.endava.TicketManagement.service.implementation.EventTypeServiceImplementation;
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
    private EventTypeRepository eventTypeRepository;

    @InjectMocks
    private EventTypeServiceImplementation eventTypeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById_WhenEventTypeFound() {
        EventType eventType = new EventType(1L, "Concert", Collections.emptyList());
        when(eventTypeRepository.findByEventTypeID(1L)).thenReturn(eventType);

        EventType result = eventTypeService.findById(1L);

        assertEquals(eventType, result);
    }

    @Test
    public void testFindById_WhenEventTypeNotFound() {
        when(eventTypeRepository.findByEventTypeID(1L)).thenReturn(null);

        EventType result = eventTypeService.findById(1L);

        assertEquals(null, result);
    }

    @Test
    public void testFindById_WhenRepositoryThrowsException() {
        when(eventTypeRepository.findByEventTypeID(1L)).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> eventTypeService.findById(1L));
    }
}
