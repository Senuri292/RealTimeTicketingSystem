package threads;
import Core.TicketPool;

import jakarta.persistence.*;

@Entity
public class Customer implements Runnable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vendorId;
    private static int customerId;
    private String firstName;
    private int numOfTickets;

    @Embedded
    private TicketPool ticketPool;

    public Customer(int customerId, String firstName, int numOfTickets) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.numOfTickets = numOfTickets;
    }

    public Customer(TicketPool ticketPool) {
        this.ticketPool = ticketPool;  // Initialize it through the constructor
    }

    public Customer() {}

    public static int getCustomerId() {return customerId;}
    public void setCustomerID(int customerId) {this.customerId = customerId;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    @Override
    public void run() {
        while (true) {
            int ticket = ticketPool.removeTickets(numOfTickets); // Purchase a ticket
            System.out.println(firstName + " purchased: " + ticket);
            try {
                Thread.sleep(1000); // Simulate time between purchases
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Customer interrupted: " + e.getMessage());
                break;
            }
        }
    }
}

//    public void addCustomer(){
//
//    }
//
//    public void viewCustomers(){
//
//    }
//
//    public void updateCustomer(long customerID){
//
//    }
//
//    public void removeCustomer(long customerID){
//
//    }



