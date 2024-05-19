package com.endava.TicketManagement.controller;

import com.endava.TicketManagement.service.OrderService;
import com.endava.TicketManagement.service.dto.OrderDto;
import com.endava.TicketManagement.service.dto.OrderRequestDto;
import com.endava.TicketManagement.service.dto.OrderUpdateDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Retrieves a list of orders with the specified number of tickets.
     *
     * @param numberOfTickets The number of tickets to search for.
     * @return A list of OrderDto objects representing the orders found.
     */
    @GetMapping(value = "/findByNumberOfTickets/{numberOfTickets}")
    public List<OrderDto> findByNumberOfTickets(@PathVariable int numberOfTickets) {
        System.out.println("Request order/findByNumberOfTickets/" + numberOfTickets);
        return orderService.findByNumberOfTickets(numberOfTickets);
    }

    /**
     * Retrieves the order associated with the specified customer ID.
     *
     * @param customerID The ID of the customer.
     * @return The OrderDto object representing the order found.
     */
    @GetMapping(value = "/findByCustomerID/{customerID}")
    public OrderDto findByCustomerCustomerID(@PathVariable Long customerID){
        System.out.println("Request order/findByCustomerID/" + customerID);
        return orderService.findByCustomerCustomerID(customerID);
    }

    /**
     * Retrieves all orders.
     *
     * @return A list of OrderDto objects representing all orders.
     */
    @GetMapping(value = "/all")
    public List<OrderDto> findAll() {
        System.out.println("Request order/all");
        return orderService.findAll();
    }

    /**
     * Creates a new order based on the provided order request and customer ID.
     *
     * @param orderRequestDto The order request DTO containing order details.
     * @param customerID      The ID of the customer placing the order.
     * @return The OrderDto object representing the newly created order.
     */
    @PostMapping(value = "/create/{customerID}", produces = {"application/json"}, consumes = {"application/json"})
    public OrderDto createOrder(@RequestBody OrderRequestDto orderRequestDto, @PathVariable Long customerID) {
        System.out.println(orderRequestDto);
        orderService.notifyCustomers();
        return orderService.createOrder(orderRequestDto, customerID);
    }

    /**
     * Updates an existing order with the specified details.
     *
     * @param orderUpdateDto The DTO containing updated order details.
     * @return The OrderDto object representing the updated order.
     */
    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public OrderDto updateOrder(@RequestBody OrderUpdateDto orderUpdateDto) {
        return orderService.updateOrder(
                orderUpdateDto.getOrderId(),
                orderUpdateDto.getTicketCategoryId(),
                orderUpdateDto.getNumberOfTickets()
        );
    }

    /**
     * Deletes an order with the specified ID.
     *
     * @param orderID The ID of the order to be deleted.
     * @return ResponseEntity with HTTP status indicating success or failure.
     */
    @DeleteMapping("/delete/{orderID}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderID) {
        try {
            orderService.deleteOrder(orderID);
            System.out.println("Request order/delete/" + orderID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

