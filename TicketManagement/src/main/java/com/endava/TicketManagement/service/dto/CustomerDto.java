package com.endava.TicketManagement.service.dto;

import com.endava.TicketManagement.repository.model.Order;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonSerialize
public class CustomerDto {
    private Long customerID;
    private String customerName;
    private String customerEmail;
    @JsonManagedReference
    private List<Order> orderList;
}
