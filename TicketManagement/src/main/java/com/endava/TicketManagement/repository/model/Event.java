package com.endava.TicketManagement.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventID")
    private Long eventID;

    @Column(name = "eventDescription")
    private String eventDescription;

    @Column(name = "eventName")
    private String eventName;

    @Column(name = "eventStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime eventStartDate;

    @Column(name = "eventEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime getEventEndDate;

    @JsonBackReference
    @OneToMany(mappedBy = "event",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<TicketCategory>ticketCategoryList = new ArrayList<>();

    @JsonBackReference
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "venueID")
    private Venue venue;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "eventTypeID")
    private EventType eventType;

}
