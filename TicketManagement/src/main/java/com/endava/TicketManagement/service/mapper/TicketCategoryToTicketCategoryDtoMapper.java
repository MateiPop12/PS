package com.endava.TicketManagement.service.mapper;

import com.endava.TicketManagement.repository.model.TicketCategory;
import com.endava.TicketManagement.service.dto.TicketCategoryDto;

public class TicketCategoryToTicketCategoryDtoMapper {
    public static TicketCategoryDto converter(TicketCategory ticketCategory){
        TicketCategoryDto ticketCategoryDto = new TicketCategoryDto();
        ticketCategoryDto.setTicketCategoryID(ticketCategory.getTicketCategoryID());
        ticketCategoryDto.setTicketCategoryDescription(ticketCategory.getTicketCategoryDescription());
        ticketCategoryDto.setTicketCategoryPrice(ticketCategory.getTicketCategoryPrice());
//        ticketCategoryDto.setOrderList(ticketCategory.getOrderList());
//        ticketCategoryDto.setEvent(ticketCategory.getEvent());
        return ticketCategoryDto;
    }
}
