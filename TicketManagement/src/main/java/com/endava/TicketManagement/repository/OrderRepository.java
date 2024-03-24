package com.endava.TicketManagement.repository;

import com.endava.TicketManagement.repository.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByNumberOfTickets(int numberOfTickets);
    Order findByCustomerCustomerID(Long customerID);
}
