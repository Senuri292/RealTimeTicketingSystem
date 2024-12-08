package com.example.RealTimeTicketingSystem;

import core.TicketPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import threads.Customer;
import threads.Vendor;

import java.sql.SQLException;
import java.util.*;

import static com.sun.imageio.plugins.jpeg.JPEG.vendor;


@SpringBootApplication
public class RealTimeTicketingSystemApplication {

	private static Runnable customer;

	public static void main(String[] args) throws SQLException{
		SpringApplication.run(RealTimeTicketingSystemApplication.class, args);
		Scanner input = new Scanner(System.in);

		TicketPool ticketPool = new TicketPool(0, 0);

		System.out.println("---------------Welcome to the Ticketing System--------------");
		int choice;
		do {
			// Display the menu
			System.out.println("What do you want to do?: ");
			System.out.println("1. Register as a vendor");
			System.out.println("2. Register as a customer");
			System.out.println("3. Add Tickets");
			System.out.println("4. Buy Tickets");
			System.out.println("5. View CLI");
			System.out.println("6. Exit");

			// Get user's choice
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

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
					System.out.println("------------Add Tickets------------");
					addTickets();
					break;

				case 4:
					System.out.println("------------Buy Tickets------------");
					buyTickets();
					break;

				case 5:
					System.out.println("------------Command Line Interface------------");
					//cli();
					break;

				case 6:
					break;

				default:
					System.out.println("Invalid choice! Please choose from the menu.");
			}
		} while (choice != 6);
		System.out.println("Exiting the Program! Thank you and have a nice day!!!............................");

	}

	public static void addVendor() throws SQLException {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter Vendor's Name: ");
		String name = input.next();
		System.out.print("Enter Vendor's ID: ");
		int id = input.nextInt();
		// TOTAL number of vendors+1

		Vendor vendor = new Vendor(name, id);
		try {
			Vendor.insertVendor(id, name);

		} catch (SQLException e) {
			// Print the error if an exception occurs
			System.err.println("Error inserting vendor: " + e.getMessage());
		}
	}

	public static void addCustomer() throws SQLException {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter Customer's ID: ");
		int id = input.nextInt();
		// total number of customers+1
		System.out.print("Enter Customer's First Name: ");
		String fName = input.next();
		System.out.print("Enter Customer's Last Name: ");
		String lName = input.next();

		Customer customer = new Customer(id, fName, lName);
		try {
			Customer.insertCustomer(id, fName, lName);

		} catch (SQLException e) {
			// Print the error if an exception occurs
			System.err.println("Error inserting Customer: " + e.getMessage());
		}
	}

	private static void addTickets() {
		Scanner input = new Scanner(System.in);

		System.out.print("How many Vendors will be adding Tickets? ");
		int vendorCount = input.nextInt();

		List<Thread> vendorThreads = new ArrayList<>();

		for (int i = 0; i < vendorCount; i++) {
			Thread vendorThread = new Thread(vendor);
			vendorThreads.add(vendorThread);
			vendorThread.start();
			System.out.println("Vendor"+(i+1)+" added Tickets to the ticket pool");
		}

		for (Thread thread : vendorThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.err.println("Thread interrupted: " + e.getMessage());
			}
		}
		System.out.println("All operations completed!");
	}

	private static void buyTickets() {
		Scanner input = new Scanner(System.in);

		System.out.print("How many Customers will be buying Tickets? ");
		int customerCount = input.nextInt();

		List<Thread> customerThreads = new ArrayList<>();

		for (int i = 0; i < customerCount; i++) {
			Thread customerThread = new Thread(customer);
			customerThreads.add(customerThread);
			customerThread.start();
			System.out.println("Customer"+(i+1)+" bought Tickets from the ticket pool");
		}
		for (Thread thread : customerThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.err.println("Thread interrupted: " + e.getMessage());
			}
		}
		System.out.println("All operations completed!");
	}
}
