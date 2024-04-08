package com.endava.TicketManagement.service.implementation;

import com.endava.TicketManagement.repository.CustomerRepository;
import com.endava.TicketManagement.repository.OrderRepository;
import com.endava.TicketManagement.repository.TicketCategoryRepository;
import com.endava.TicketManagement.repository.model.Customer;
import com.endava.TicketManagement.repository.model.Order;
import com.endava.TicketManagement.repository.model.TicketCategory;
import com.endava.TicketManagement.service.CustomerService;
import com.endava.TicketManagement.service.OrderService;
import com.endava.TicketManagement.service.dto.CustomerDto;
import com.endava.TicketManagement.service.dto.OrderDto;
import com.endava.TicketManagement.service.dto.OrderRequestDto;
import com.endava.TicketManagement.service.mapper.OrderToOrderDtoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImplementation implements OrderService {
    private final OrderRepository orderRepository;
    private final TicketCategoryRepository ticketCategoryRepository;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;


    @Autowired
    public OrderServiceImplementation(OrderRepository orderRepository,
                                      TicketCategoryRepository ticketCategoryRepository,
                                      CustomerRepository customerRepository,
                                      CustomerService customerService) {
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    /**
     * Retrieves a list of orders with the given number of tickets.
     *
     * @param numberOfTickets The number of tickets to search for.
     * @return A list of OrderDto objects representing the orders found.
     */
    @Override
    public List<OrderDto> findByNumberOfTickets(int numberOfTickets) {
        return orderRepository.findByNumberOfTickets(numberOfTickets).stream().map(OrderToOrderDtoMapper::converter).collect(Collectors.toList());
    }

    /**
     * Retrieves the order associated with the specified customer ID.
     *
     * @param customerID The ID of the customer.
     * @return The OrderDto object representing the order found.
     */
    @Override
    public OrderDto findByCustomerCustomerID(Long customerID) {
        return OrderToOrderDtoMapper.converter(orderRepository.findByCustomerCustomerID(customerID));
    }

    /**
     * Retrieves all orders.
     *
     * @return A list of OrderDto objects representing all orders.
     */
    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream().map(OrderToOrderDtoMapper::converter).collect(Collectors.toList());
    }

    /**
     * Creates a new order based on the provided order request and customer ID.
     *
     * @param orderRequestDto The order request DTO containing order details.
     * @param customerID      The ID of the customer placing the order.
     * @return The OrderDto object representing the newly created order.
     * @throws IllegalArgumentException If the ticket category ID is null.
     * @throws EntityNotFoundException  If the ticket category or customer is not found.
     */
    @Override
    public OrderDto createOrder(OrderRequestDto orderRequestDto, Long customerID) {

        Long ticketCategoryId = orderRequestDto.getTicketCategoryID();
        if (ticketCategoryId == null) {
            throw new IllegalArgumentException("TicketCategoryId cannot be null");
        }
        TicketCategory ticketCategory = ticketCategoryRepository.
                findByTicketCategoryID(orderRequestDto.getTicketCategoryID());
        Customer customer = customerRepository.findByCustomerID(customerID);

        if(ticketCategory == null){
            throw new EntityNotFoundException("TicketCategory not found.");

        }
        if (customer == null) {
            throw new EntityNotFoundException("Customer not found.");
        }

        Order order = new Order();

        order.setTicketCategory(ticketCategory);
        order.setCustomer(customer);
        order.setOrderedAt(LocalDateTime.now());
        order.setNumberOfTickets(orderRequestDto.getNumberOfTickets());
        order.setTotalPrice(orderRequestDto.getNumberOfTickets() * ticketCategory.
                getTicketCategoryPrice());
        orderRepository.save(order);
        return OrderToOrderDtoMapper.converter(order);
    }

    /**
     * Updates an existing order with the specified details.
     *
     * @param orderID            The ID of the order to be updated.
     * @param newTicketCategoryID The ID of the new ticket category.
     * @param newNumberOfTickets The new number of tickets for the order.
     * @return The OrderDto object representing the updated order.
     * @throws EntityNotFoundException If the order or new ticket category is not found.
     */
    @Override
    public OrderDto updateOrder(Long orderID, Long newTicketCategoryID, int newNumberOfTickets) {
        Order order = orderRepository.findById(orderID)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        TicketCategory newTicketCategory = ticketCategoryRepository.findById(newTicketCategoryID)
                .orElseThrow(() -> new EntityNotFoundException("New TicketCategory not found"));

        float newTotalPrice = newNumberOfTickets * newTicketCategory.getTicketCategoryPrice();

        order.setNumberOfTickets(newNumberOfTickets);
        order.setTotalPrice(newTotalPrice);
        order.setTicketCategory(newTicketCategory);

        orderRepository.save(order);

        return OrderToOrderDtoMapper.converter(order);
    }

    /**
     * Deletes an order with the specified ID.
     *
     * @param orderId The ID of the order to be deleted.
     * @throws EntityNotFoundException If the order with the specified ID is not found.
     */
    public void deleteOrder(Long orderId) {
        Order orderDeleteById = orderRepository.findById(orderId).orElse(null);
        if (orderDeleteById != null) {
            orderRepository.delete(orderDeleteById);
        } else {
            throw new EntityNotFoundException("Order with id " + orderId + " not found");
        }
    }

    @Override
    public void notifyCustomers(){
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            //if(customer.getSubscribed==true)
            customerService.update(customer.getCustomerID());
        }
    }
}
