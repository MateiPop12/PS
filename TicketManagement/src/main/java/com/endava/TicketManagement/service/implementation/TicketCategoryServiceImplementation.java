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
    @Override
    public List<TicketCategoryDto> findAll(){
        return ticketCategoryRepository.findAll().stream().map(TicketCategoryToTicketCategoryDtoMapper::converter).collect(Collectors.toList());
    }
    @Override
    public TicketCategoryDto findByTicketCategoryID(Long ticketCategoryId) {
        return TicketCategoryToTicketCategoryDtoMapper.converter(ticketCategoryRepository.findByTicketCategoryID(ticketCategoryId));
    }

}
