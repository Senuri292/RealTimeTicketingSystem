package com.example.RealTimeTicketingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RealTimeTicketingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeTicketingSystemApplication.class, args);

	}

	public void addVendor(){
		Scanner input = new Scanner(System.in);
		System.out.println("------------Vendor Registration------------");

		System.out.print("Enter Vendor's Name: ");
		String name = input.nextLine();

		System.out.print("Enter Vendor's ID: ");
		int id = input.nextInt();

		System.out.println("Enter Vendor's contact number: ");
		int contact = input.nextInt();

		Vendor vendor1 = new Vendor(name, id, contact);

		//Vendor.setVendorDetails.add(new Vendor(vendorName, vendorId, vendorContact));
	}
}
