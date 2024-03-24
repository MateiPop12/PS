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

    @RequestMapping(value = "/findByNumberOfTickets/{numberOfTickets}", method = RequestMethod.GET)
    public List<OrderDto> findByNumberOfTickets(@PathVariable int numberOfTickets) {
        System.out.println("Request order/findByNumberOfTickets/" + numberOfTickets);
        return orderService.findByNumberOfTickets(numberOfTickets);
    }
    @RequestMapping(value = "/findByCustomerID/{customerID}",method = RequestMethod.GET)
    public OrderDto findByCustomerCustomerID(@PathVariable Long customerID){
        System.out.println("Request order/findByCustomerID/" + customerID);
        return orderService.findByCustomerCustomerID(customerID);
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<OrderDto> findAll() {
        System.out.println("Request order/all");
        return orderService.findAll();
    }

    @PostMapping(value = "/create/{customerID}", produces = {"application/json"}, consumes = {"application/json"})
    public OrderDto createOrder(@RequestBody OrderRequestDto orderRequestDto, @PathVariable Long customerID) {
        System.out.println(orderRequestDto);
        return orderService.createOrder(orderRequestDto, customerID);
    }
    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public OrderDto updateOrder(@RequestBody OrderUpdateDto orderUpdateDto) {
        return orderService.updateOrder(
                orderUpdateDto.getOrderId(),
                orderUpdateDto.getTicketCategoryId(),
                orderUpdateDto.getNumberOfTickets()
        );
    }
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

