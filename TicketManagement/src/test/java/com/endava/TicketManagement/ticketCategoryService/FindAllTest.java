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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FindAllTest {

    @Mock
    private TicketCategoryRepository ticketCategoryRepository;

    @InjectMocks
    private TicketCategoryServiceImplementation ticketCategoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll_WhenTicketCategoriesFound() {
        List<TicketCategoryDto> ticketCategoryDtos = Arrays.asList(
                new TicketCategoryDto(1L, "VIP", 100.0f),
                new TicketCategoryDto(2L, "Standard", 50.0f),
                new TicketCategoryDto(3L, "Economy", 30.0f)
        );
        when(ticketCategoryRepository.findAll()).thenReturn((List<TicketCategory>) ticketCategoryDtos.stream()
                .map(ticketCategoryDto -> {
                    TicketCategory ticketCategory = new TicketCategory();
                    ticketCategory.setTicketCategoryID(ticketCategoryDto.getTicketCategoryID());
                    ticketCategory.setTicketCategoryDescription(ticketCategoryDto.getTicketCategoryDescription());
                    ticketCategory.setTicketCategoryPrice(ticketCategoryDto.getTicketCategoryPrice());
                    return ticketCategory;
                })
                .collect(Collectors.toList()));

        List<TicketCategoryDto> result = ticketCategoryService.findAll();

        assertEquals(ticketCategoryDtos.size(), result.size());
        for (int i = 0; i < ticketCategoryDtos.size(); i++) {
            assertEquals(ticketCategoryDtos.get(i), result.get(i));
        }
    }

    @Test
    public void testFindAll_WhenNoTicketCategoriesFound() {
        when(ticketCategoryRepository.findAll()).thenReturn(Collections.emptyList());

        List<TicketCategoryDto> result = ticketCategoryService.findAll();

        assertEquals(0, result.size());
    }
}
