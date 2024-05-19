package com.endava.TicketManagement.controller;

import com.endava.TicketManagement.service.TicketCategoryService;
import com.endava.TicketManagement.service.dto.TicketCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketCategory")
@CrossOrigin(origins = "http://localhost:5173")
public class TicketCategoryController {

    private final TicketCategoryService ticketCategoryService;

    /**
     * Constructor for TicketCategoryController.
     *
     * @param ticketCategoryService the service used to manage ticket categories.
     */
    @Autowired
    public TicketCategoryController(TicketCategoryService ticketCategoryService) {
        this.ticketCategoryService = ticketCategoryService;
    }

    /**
     * Retrieves a list of all ticket categories.
     *
     * @return a list of TicketCategoryDto objects.
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<TicketCategoryDto> findAll(){
        System.out.println("Request ticketCategory/all");
        return ticketCategoryService.findAll();
    }

    /**
     * Retrieves a ticket category by its ID.
     *
     * @param ticketCategoryID the ID of the ticket category to retrieve.
     * @return the TicketCategoryDto object representing the ticket category.
     */
    @RequestMapping(value = "/find/{ticketCategoryID}",method = RequestMethod.GET)
    public TicketCategoryDto findByTicketCategoryId(@PathVariable Long ticketCategoryID){
        System.out.println("Request ticketCategory/find/"+ticketCategoryID);
        return ticketCategoryService.findByTicketCategoryID(ticketCategoryID);
    }
}
