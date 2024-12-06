package com.example.RealTimeTicketingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


@SpringBootApplication
public class RealTimeTicketingSystemApplication {

	public static void main(String[] args) throws SQLException{
		SpringApplication.run(RealTimeTicketingSystemApplication.class, args);
		Scanner input = new Scanner(System.in);
		System.out.println("---------------Welcome to the Ticketing System CLI--------------");
		int choice;
		do {
			// Display the menu
			System.out.println("What do you want to do?: ");
			System.out.println("1. Register as a vendor");
			System.out.println("2. Register as a customer");
			System.out.println("3. Add Event");
			System.out.println("4. Buy Tickets");
			System.out.println("5. View Profile");
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
					System.out.println("------------Event Registration------------");
					//addEvent();
					break;

				case 4:
					System.out.println("------------Buy Tickets------------");
					//buyTickets();
					break;

				case 5:
					System.out.println("------------View Profile------------");
					//profile();
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
		System.out.println("Enter Vendor's contact number: ");
		int contact = input.nextInt();

		threads.Vendor vendor = new threads.Vendor(name, id, contact, 0);
		try {
			threads.Vendor.insertVendor(id, name, contact, 0);

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

		threads.Customer customer = new threads.Customer(id, fName, lName, 0);
		try {
			threads.Customer.insertCustomer(id, fName, lName, 0);

		} catch (SQLException e) {
			// Print the error if an exception occurs
			System.err.println("Error inserting Customer: " + e.getMessage());
		}
	}
}
