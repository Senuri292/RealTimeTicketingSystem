package com.example.RealTimeTicketingSystem.threads;

import com.example.RealTimeTicketingSystem.Core.TicketPool;
import jakarta.persistence.*;

// customer class to hold details of the vendor
@Entity
@Table(name = "\"Vendor\"")
public class Vendor implements Runnable {
    @Column(name = "\"vendorId\"")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vendorId;
    @Column(name = "\"vendorName\"")
    private String vendorName;
    @Column(name = "\"numOfTickets\"")
    private int numOfTickets;

    @Embedded
    private TicketPool ticketPool;
    public Vendor(String vendorName, int vendorId, int numOfTickets) {
        this.vendorName = vendorName;
        this.vendorId = vendorId;
        this.numOfTickets = numOfTickets;
    }
    public Vendor(TicketPool ticketPool) {
        this.ticketPool = ticketPool;  // Initialize it through the constructor
    }
    public Vendor() {}

    public String getVendorName() {return vendorName;}
    public int getVendorId() {return vendorId;}
    public void setVendorName(String vendorName) {this.vendorName = vendorName;}
    public void setVendorId(int vendorId) {this.vendorId = vendorId;}
    public int getNumOfTickets() {return numOfTickets;}
    public void setNumOfTickets(int numOfTickets) {this.numOfTickets = numOfTickets;}
    // overriding run method from runnable
    @Override
    public void run() {
        int ticketCount = 1;
        while (true) {
            ticketPool.addTickets(numOfTickets); // Add tickets to the pool
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




