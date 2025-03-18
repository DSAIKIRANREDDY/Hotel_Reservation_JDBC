import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class See_customers {

    public See_customers() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservation","root","Hanuman$123");
            Statement stat=conn.createStatement();
            ResultSet resultset=stat.executeQuery("SELECT lastname,firstname FROM acccreation");
            System.out.println("=====CUSTOMERS DETAILS=====\n");
            if(!resultset.next()){
                System.out.println("=====NO CUSTOMERS DATA REGISTERED===\n");
            }
            else{
                do { 
                    System.out.println(resultset.getString(1)+" "+resultset.getString(2));
                } while (resultset.next());
            }
            resultset.close();
            conn.close();
            stat.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Admin_menu();
    }
    public static void main(String[] args) {
        new See_customers();
    }
}
