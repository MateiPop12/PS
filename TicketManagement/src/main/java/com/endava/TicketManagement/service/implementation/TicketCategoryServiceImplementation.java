package com.endava.TicketManagement.service.implementation;

import com.endava.TicketManagement.repository.TicketCategoryRepository;
import com.endava.TicketManagement.service.TicketCategoryService;
import com.endava.TicketManagement.service.dto.TicketCategoryDto;
import com.endava.TicketManagement.service.mapper.TicketCategoryToTicketCategoryDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketCategoryServiceImplementation implements TicketCategoryService {

    private final TicketCategoryRepository ticketCategoryRepository;

    public TicketCategoryServiceImplementation(TicketCategoryRepository ticketCategoryRepository){
        this.ticketCategoryRepository = ticketCategoryRepository;
    }

    /**
     * Retrieves all ticket categories.
     *
     * @return a list of TicketCategoryDto objects representing all ticket categories
     */
    @Override
    public List<TicketCategoryDto> findAll(){
        return ticketCategoryRepository.findAll().stream().map(TicketCategoryToTicketCategoryDtoMapper::converter).collect(Collectors.toList());
    }

    /**
     * Finds a ticket category by its ID.
     *
     * @param ticketCategoryId the ID of the ticket category
     * @return the TicketCategoryDto object representing the ticket category
     */
    @Override
    public TicketCategoryDto findByTicketCategoryID(Long ticketCategoryId) {
        return TicketCategoryToTicketCategoryDtoMapper.converter(ticketCategoryRepository.findByTicketCategoryID(ticketCategoryId));
    }
}
