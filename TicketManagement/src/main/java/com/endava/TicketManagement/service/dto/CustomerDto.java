package com.endava.TicketManagement.service.dto;

import com.endava.TicketManagement.repository.model.Order;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonSerialize
public class CustomerDto {
    private Long customerID;
    private String customerName;
    private String customerEmail;
    @JsonManagedReference
    private List<Order> orderList;
}
