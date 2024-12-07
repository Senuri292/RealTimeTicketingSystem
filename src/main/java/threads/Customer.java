package threads;
import core.TicketPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer implements Runnable {
    private int customerId;
    private String firstName;
    private String lastName;
    private int retrievalInterval;

    private TicketPool ticketPool;

    public Customer(int customerId, String firstName, String lastName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(TicketPool ticketPool) {
        this.ticketPool = ticketPool;  // Initialize it through the constructor
    }

    public int getCustomerId() {return customerId;}
    public void setCustomerID(int customerId) {this.customerId = customerId;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public static void insertCustomer(int customerId, String firstName, String lastName) throws SQLException {
        String sql = "INSERT INTO \"Customer\" VALUES (?, ?, ?, ?)";

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RealTimeTicketingSystem", "postgres", "");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Customer registered into the database successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting Customer: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        while (true) {
            String ticket = ticketPool.removeTickets(); // Purchase a ticket
            System.out.println(firstName + lastName + " purchased: " + ticket);
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



