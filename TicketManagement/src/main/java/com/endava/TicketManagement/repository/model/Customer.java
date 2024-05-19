package com.endava.TicketManagement.repository.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@JsonSerialize
@Getter
@Setter
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerID")
    private Long customerID;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerEmail")
    private String customerEmail;

//    @Column(name = "subscribed")
//    private Boolean subscribed;
}
