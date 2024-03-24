package com.endava.TicketManagement.repository;

import com.endava.TicketManagement.repository.model.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketCategoryRepository extends JpaRepository<TicketCategory,Long> {
    TicketCategory findByTicketCategoryID(Long ticketCategory);
}
