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
@Table(name = "eventType")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventTypeID;

    @Column(name = "eventTypeName")
    private String eventTypeName;

    @JsonBackReference
    @OneToMany(mappedBy = "eventType",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Event> eventList = new ArrayList<>();
}
