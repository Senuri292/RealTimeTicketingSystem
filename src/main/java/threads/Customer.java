package threads;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private int retrievalInterval;

    public Customer(int customerId, String firstName, String lastName, int retrievalInterval) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.retrievalInterval = retrievalInterval;
    }
    public int getCustomerId() {return customerId;}
    public void setCustomerID(int customerId) {this.customerId = customerId;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public int getRetrievalInterval() {return retrievalInterval;}
    public void setRetrievalInterval(int retrievalInterval) {this.retrievalInterval = retrievalInterval;}

    public static void insertCustomer(int customerId, String firstName, String lastName, int retrievalInterval) throws SQLException {
        String sql = "INSERT INTO \"Customer\" VALUES (?, ?, ?, ?)";

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RealTimeTicketingSystem", "postgres", "");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, customerId);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setInt(4, retrievalInterval);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Customer registered into the database successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting Customer: " + e.getMessage());
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
}


