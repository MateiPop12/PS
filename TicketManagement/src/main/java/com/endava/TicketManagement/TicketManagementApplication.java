package com.endava.TicketManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TicketManagementApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(TicketManagementApplication.class, args);

	}
}
