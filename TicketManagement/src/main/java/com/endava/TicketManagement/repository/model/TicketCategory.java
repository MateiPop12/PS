package com.endava.TicketManagement.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Entity
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
