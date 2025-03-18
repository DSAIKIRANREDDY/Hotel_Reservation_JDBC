import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class See_Reservations {
    See_Reservations(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservation","root","Hanuman$123");
            Statement stat=conn.createStatement();
            ResultSet resultSet=stat.executeQuery("SELECT * FROM reserved");
            if(resultSet.next()){
                System.out.println("\n=====ROOMS RESERVED=====\n");
                do { 
                    System.out.println("ROOM_NUMBER:"+resultSet.getInt(1)+"  CUSTOMER_NAME:"+resultSet.getString(2)+"  EMAIL:"+resultSet.getString(3)+"  CHECK_IN:"+resultSet.getString(4)+"  CHECK_OUT:"+resultSet.getString(5));
                } while (resultSet.next());
            }
            else{
                System.out.println("=====NO RESERVATIONS DONE=====");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Welcome();
    }
    public static void main(String[] args) {
        new See_Reservations();
    }
}
