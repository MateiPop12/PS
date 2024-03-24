package com.endava.TicketManagement.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
//@Data
@Entity
@JsonSerialize
@Getter
@Setter
@Table(name = "ticketCategory")
public class TicketCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketCategoryID")
    private Long ticketCategoryID;

    @Column(name = "ticketCategoryDescription")
    private String ticketCategoryDescription;

    @Column(name = "ticketCategoryPrice")
    private float ticketCategoryPrice;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "eventID")
    private Event event;
}
