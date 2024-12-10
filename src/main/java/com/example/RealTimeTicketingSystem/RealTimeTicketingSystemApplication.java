package com.example.RealTimeTicketingSystem;

import Service.CustomerService;
import Service.VendorService;
import Core.TicketPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static Logging.TicketLogger.start;
import static Service.CustomerService.addCustomer;
import static Service.VendorService.addVendor;

@SpringBootApplication
public class RealTimeTicketingSystemApplication {
	private static Runnable customer;
	private static Runnable vendor;

	public static void main(String[] args) throws SQLException, IOException {
		SpringApplication.run(RealTimeTicketingSystemApplication.class, args);
		Scanner input = new Scanner(System.in);

		//TicketPool ticketPool = new TicketPool(0, 0);

		System.out.println("---------------Welcome to the Ticketing System--------------");
		int choice = 0;
		do {
			// Display the menu
			System.out.println("What do you want to do?: ");
			System.out.println("1. Register as a vendor");
			System.out.println("2. Register as a customer");
			System.out.println("3. Start");
			System.out.println("4. Exit");

			// Get user's choice
			try {
				System.out.print("Enter your choice: ");
				choice = input.nextInt();
			}catch (InputMismatchException e){
				input.nextLine();
			}
			// Perform action based on the choice
			switch (choice) {
				case 1:
					System.out.println("------------Vendor Registration------------");
					addVendor();
					break;

				case 2:
					System.out.println("------------Customer Registration------------");
					addCustomer();
					break;

				case 3:
					System.out.println("------------Starting Simulation------------");
					start();
					break;

				case 4:
					break;

				default:
					System.out.println("Invalid choice! Please choose from the menu.");
			}
		} while (choice != 4);
		System.out.println("Exiting the Program! Thank you and have a nice day!!!............................");
	}

//	private static void addTickets() {
//		Scanner input = new Scanner(System.in);
//
//		System.out.print("How many Vendors will be adding Tickets? ");
//		int vendorCount = input.nextInt();
//
//		List<Thread> vendorThreads = new ArrayList<>();
//
//		for (int i = 0; i < vendorCount; i++) {
//			Thread vendorThread = new Thread(vendor);
//			vendorThreads.add(vendorThread);
//			vendorThread.start();
//			System.out.println("Vendor"+(i+1)+" added Tickets to the ticket pool");
//		}
//
//		for (Thread thread : vendorThreads) {
//			try {
//				thread.join();
//			} catch (InterruptedException e) {
//				System.err.println("Thread interrupted: " + e.getMessage());
//			}
//		}
//		System.out.println("All operations completed!");
//	}
//
//	private static void buyTickets() {
//		Scanner input = new Scanner(System.in);
//
//		System.out.print("How many Customers will be buying Tickets? ");
//		int customerCount = input.nextInt();
//
//		List<Thread> customerThreads = new ArrayList<>();
//
//		for (int i = 0; i < customerCount; i++) {
//			Thread customerThread = new Thread(customer);
//			customerThreads.add(customerThread);
//			customerThread.start();
//			System.out.println("Customer"+(i+1)+" bought Tickets from the ticket pool");
//		}
//		for (Thread thread : customerThreads) {
//			try {
//				thread.join();
//			} catch (InterruptedException e) {
//				System.err.println("Thread interrupted: " + e.getMessage());
//			}
//		}
//		System.out.println("All operations completed!");
//	}
}
