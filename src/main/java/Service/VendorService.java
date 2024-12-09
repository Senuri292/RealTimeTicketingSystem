package Service;

import Repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import threads.Vendor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

        System.out.print("Enter Vendor's Name: ");
        String name = input.next();
        System.out.print("Enter Vendor's ID: ");
        int id = input.nextInt();
        // TOTAL number of vendors+1

        Vendor vendor = new Vendor(name, id);
        try {
            VendorService.insertVendor(id, name);

        } catch (SQLException e) {
            // Print the error if an exception occurs
            System.err.println("Error inserting vendor: " + e.getMessage());
        }
    }

    public static void insertVendor(int vendorId, String vendorName) throws SQLException {
        String sql = "INSERT INTO \"Vendor\" VALUES (?, ?, ?, ?)";

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RealTimeTicketingSystem", "postgres", "");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, vendorId);
            preparedStatement.setString(2, vendorName);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Vendor registered into the database successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting vendor: " + e.getMessage());
        }

    }
}
