import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data_base {
    static Connection con = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_reservation", "root", "password"); 
            System.out.println("Database Connected Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!");
        }
        return con;
    }
    public static void main(String[] args) {
        
    }
}

