package com.endava.TicketManagement.service;

import com.endava.TicketManagement.service.dto.TicketCategoryDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TicketCategoryService {
    TicketCategoryDto findByTicketCategoryID(Long ticketCategoryId);
    List<TicketCategoryDto> findAll();
}
