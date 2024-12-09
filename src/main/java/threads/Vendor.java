package threads;
import core.TicketPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class Vendor implements Runnable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String vendorName;
    private int vendorId;

    private TicketPool ticketPool;

    public Vendor(String vendorName, int vendorId) {
        this.vendorName = vendorName;
        this.vendorId = vendorId;
    }

    public Vendor(TicketPool ticketPool) {
        this.ticketPool = ticketPool;  // Initialize it through the constructor
    }

    public Vendor() {}

    public String getVendorName() {return vendorName;}
    public int getVendorId() {return vendorId;}
    public void setVendorName(String vendorName) {this.vendorName = vendorName;}
    public void setVendorId(int vendorId) {this.vendorId = vendorId;}

    @Override
    public void run() {
        int ticketCount = 1;
        while (true) {
            String ticket = vendorName + "-Ticket-" + ticketCount++;
            ticketPool.addTickets(ticket); // Add tickets to the pool
            try {
                Thread.sleep(500); // Simulate time taken to release a ticket
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Vendor interrupted: " + e.getMessage());
                break;
            }
        }
    }

}
//    public void addVendorDetails(Vendor vendorDetails) {}
//    public void viewVendors () {
//        //give a return type maybe a list
//    }
//    public void updateVendor(long vendorID) {
//        int updateID;
//        System.out.println("------------Update Vendor Details------------");
//        System.out.println("Enter Vendor ID: ");
//        updateID = input.nextInt();}
//public void deleteVendor(long vendorID) {}



