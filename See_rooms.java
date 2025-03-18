import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class See_rooms {
    See_rooms(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservation","root","Hanuman$123");
            Statement stat=conn.createStatement();
            String query="SELECT room_number,room_rent,room_type FROM addroom";
            ResultSet resultset=stat.executeQuery(query);
            if(!resultset.next()){
                System.out.println("=====NO INFORMATION RELATED TO ROOMS=====\n");
            }
            else{
                System.out.println("=====LIST OF ROOMS=====\n");
                do { 
                    System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getString(3));
                } while (resultset.next());
            }
            resultset.close();
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Admin_menu();
    }
    public static void main(String[] args) {
        new See_rooms();
    }
}
