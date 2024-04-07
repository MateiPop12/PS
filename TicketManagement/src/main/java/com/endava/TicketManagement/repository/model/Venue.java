package com.endava.TicketManagement.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
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
