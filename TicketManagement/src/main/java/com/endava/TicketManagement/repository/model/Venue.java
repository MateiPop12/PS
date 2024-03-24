package com.endava.TicketManagement.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
@JsonSerialize
@Table(name = "venue")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long venueID;

    @Column(name = "venueLocation")
    private String venueLocation;

    @Column(name = "venueType")
    private String venueType;

    @Column(name = "venueCapacity")
    private int venueCapacity;

    @JsonBackReference
    @OneToMany(mappedBy = "venue",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Event> eventList = new ArrayList<>();
}
