package com.endava.TicketManagement.controller;

import com.endava.TicketManagement.service.CustomerService;
import com.endava.TicketManagement.service.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    CustomerController(CustomerService customerService){this.customerService=customerService;}

    /**
     * Retrieves a customer by their ID.
     *
     * @param customerId the ID of the customer to retrieve.
     * @return the CustomerDto object representing the customer.
     */
    @RequestMapping(value = "/find/{customerId}", method = RequestMethod.GET)
    public CustomerDto findByCustomerId(@PathVariable Long customerId){
        System.out.println("Request customer/find/"+customerId);
        return customerService.findByCustomerID(customerId);
    }
}
