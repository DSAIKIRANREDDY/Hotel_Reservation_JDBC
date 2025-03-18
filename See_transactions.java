import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class See_transactions {

    public See_transactions() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservation","root","Hanuman$123");
            Statement stat=conn.createStatement();
            String query="SELECT room_number,customer,total_rent FROM transactions";
            ResultSet resultSet=stat.executeQuery(query);
            if(resultSet.next()){
                System.out.println("=====TRANSACTIONS DONE=====\n");
                do { 
                    System.out.println("ROOM_NUMBER: "+resultSet.getInt(1)+"  CUSTOMER: "+resultSet.getString(2)+"  TOTAL_RENT: "+resultSet.getString(3));
                } while (resultSet.next());
            }
            else{
                System.out.println("=====NO TRANSACTIONS=====\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Admin_menu();
    }
    public static void main(String[] args) {
        new See_transactions();
    }
}
