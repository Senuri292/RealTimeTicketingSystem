package Service;

import Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import threads.Vendor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public static void addVendor() throws SQLException {
        Scanner input = new Scanner(System.in);
        int vendorId = 0;
        String name = "";
        int numOfTicketsVendor = 0;

        try {
            System.out.print("Enter Vendor ID: ");
            vendorId = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Vendor ID! Please enter a integer Vendor ID.");
            input.nextLine();
        }

        try {
            System.out.print("Enter Vendor's Name: ");
            name = input.next();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Vendor's Name! Please enter a integer Vendor ID.");
            input.nextLine();
        }
        try {
            System.out.print("Enter the number of tickets vendor have: ");
            numOfTicketsVendor = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a integer value.");
            input.nextLine();
        }

        Vendor vendor = new Vendor(name, vendorId, numOfTicketsVendor);
        try {
            VendorService.insertVendor(vendorId, name, numOfTicketsVendor);

        } catch (SQLException e) {
            // Print the error if an exception occurs
            System.err.println("Error inserting vendor: " + e.getMessage());
        }
    }

    public static void insertVendor(int vendorId, String vendorName, int numOfTickets) throws SQLException {
        String sql = "INSERT INTO \"Vendor\" VALUES (?, ?, ?)";

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RealTimeTicketingSystem", "postgres", "");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, vendorId);
            preparedStatement.setString(2, vendorName);
            preparedStatement.setInt(3, numOfTickets);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Vendor registered into the database successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting vendor: " + e.getMessage());
        }
        System.out.println("Vendors credentials: "+ vendorId + "-" + vendorName);
    }
}
