package com.endava.TicketManagement.repository.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@JsonSerialize
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID")
    private Long orderID;

    @Column(name = "orderedAt")
    private LocalDateTime orderedAt;

    @Column(name = "numberOfTickets")
    private int numberOfTickets;

    @Column(name = "totalPrice")
    private float totalPrice;

    @JsonManagedReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "customerID")
    private Customer customer;

    @JsonManagedReference
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "ticketCategoryID")
    private TicketCategory ticketCategory;

}
