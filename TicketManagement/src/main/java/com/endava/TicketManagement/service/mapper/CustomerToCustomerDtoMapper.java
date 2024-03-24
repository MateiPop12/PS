package com.endava.TicketManagement.service.mapper;

import com.endava.TicketManagement.repository.model.Customer;
import com.endava.TicketManagement.service.dto.CustomerDto;

public class CustomerToCustomerDtoMapper {
    public static CustomerDto converter(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerID(customer.getCustomerID());
        customerDto.setCustomerName(customer.getCustomerName());
        customerDto.setCustomerEmail(customer.getCustomerEmail());
//        customerDto.setOrderList(customer.getOrderList());
        return customerDto;
    }
}
