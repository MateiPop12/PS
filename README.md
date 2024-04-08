# Event Ticket Sales Management System

## Overview
The Event Ticket Sales Management System is a tool designed for managing the sale of tickets to events. The system allows for the creation of new orders by selecting the ticket type (regular or VIP) and specifying the number of tickets desired, with the corresponding price displayed. The app also allows orders to be viewed and edited by changing the type and number of tickets.

## Key Features
- **Event Selection:** Predetermined events are listed for ticket sales.
- **Order Management:** Users can view all orders and make edits as necessary.
- **Order Creation:** New orders can be created by selecting the ticket type (regular or VIP) and specifying the quantity, with the price automatically calculated and displayed.
- **Search Function:** A search by name function is provided for easier navigation and retrieval of orders and avalabile tickets.
- **Notify Function:** A function that notifys evety customer when an order is placed.

## Observer Pattern

The **Observer Pattern** is a behavioral design pattern where an object, called the subject, maintains a list of its dependents, called observers, and notifies them of any changes in state, usually by calling one of their methods. In the provided classes, we can identify an implementation of the Observer Pattern with the following elements:

1. **Subject (Observable)**: In this case, the `OrderServiceImplementation` class acts as the subject. It maintains a list of observers (customers) and notifies them of changes. The `notifyCustomers()` method in `OrderServiceImplementation` iterates through all customers and calls the `update()` method on each of them.

2. **Observer**: Customers are the observers in this scenario. However, the observer pattern usually involves a way for observers to register or subscribe to the subject to receive notifications. In this code snippet, this part is not explicitly implemented. Instead, it's assumed that all customers are already registered or subscribed. In a real-world scenario, there would typically be a method for customers to subscribe to updates, and a mechanism for the subject to keep track of its observers.

3. **Notification**: The `notifyCustomers()` method iterates through all customers and calls the `update()` method on each customer. In this case, the `update()` method is intended to notify customers, although the implementation is currently printing "Email sent" as a placeholder. Typically, this method would contain logic to send notifications to the customers through email, SMS, or other means.


## Entity diagram
The organization of the database is depicted in the following entity diagram:

![Example Image](EntityDiagram.drawio.png)
