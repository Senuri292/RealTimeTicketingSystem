package com.example.RealTimeTicketingSystem.threads;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private int customerId;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "numOfTickets")
    private int numOfTickets;

    // Default constructor
    public Customer() {}

    // Parameterized constructor
    public Customer(int customerId, String customerName, int numOfTickets) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.numOfTickets = numOfTickets;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }

    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }
}