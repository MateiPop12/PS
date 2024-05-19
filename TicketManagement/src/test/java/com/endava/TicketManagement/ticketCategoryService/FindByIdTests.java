package com.endava.TicketManagement.ticketCategoryService;

import com.endava.TicketManagement.repository.TicketCategoryRepository;
import com.endava.TicketManagement.repository.model.TicketCategory;
import com.endava.TicketManagement.service.dto.TicketCategoryDto;
import com.endava.TicketManagement.service.implementation.TicketCategoryServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class FindByIdTests {
    @Mock
    private TicketCategoryRepository ticketCategoryRepository;

    @InjectMocks
    private TicketCategoryServiceImplementation ticketCategoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindByTicketCategoryID_WhenTicketCategoryFound() {
        TicketCategory ticketCategory = new TicketCategory(1L, "VIP", 100.0f, null);
        when(ticketCategoryRepository.findByTicketCategoryID(1L)).thenReturn(ticketCategory);

        TicketCategoryDto result = ticketCategoryService.findByTicketCategoryID(1L);

        assertEquals(ticketCategory.getTicketCategoryID(), result.getTicketCategoryID());
        assertEquals(ticketCategory.getTicketCategoryDescription(), result.getTicketCategoryDescription());
        assertEquals(ticketCategory.getTicketCategoryPrice(), result.getTicketCategoryPrice());
    }

    @Test
    public void testFindByTicketCategoryID_WhenTicketCategoryNotFound() {
        when(ticketCategoryRepository.findByTicketCategoryID(1L)).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> ticketCategoryService.findByTicketCategoryID(1L));
    }
}
