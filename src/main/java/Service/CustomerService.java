package Service;

import Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import threads.Customer;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public static void addCustomer() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Customer ID: ");
        int customerId = input.nextInt();
        System.out.print("Enter Customer's First Name: ");
        String fName = input.next();
        System.out.print("Enter number of tickets customer wants to buy: ");
        int numOfTicketsCustomer = input.nextInt();

        Customer customer = new Customer(customerId, fName, numOfTicketsCustomer);
        try {
            CustomerService.insertCustomer(customerId, fName, numOfTicketsCustomer);

        } catch (SQLException e) {
            // Print the error if an exception occurs
            System.err.println("Error inserting Customer: " + e.getMessage());
        }
    }

    public static void insertCustomer(int customerId, String firstName, int numOfTickets) throws SQLException {
        String sql = "INSERT INTO \"Customer\" VALUES (?, ?, ?)";

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RealTimeTicketingSystem", "postgres", "");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, firstName);
            preparedStatement.setInt(3, numOfTickets);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Customer registered into the database successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting Customer: " + e.getMessage());
        }
        System.out.println("Customers credentials: "+ customerId + "-" + firstName);
    }
}
