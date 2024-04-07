package com.endava.TicketManagement.repository;

import com.endava.TicketManagement.repository.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> {
}
