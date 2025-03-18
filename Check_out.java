import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Check_out {

    public Check_out() {
        Scanner scan=new Scanner(System.in);
        System.out.println("ENTER THE ROOM NUMBER:");
        int room_number=0;
        boolean valid=false;
        while(!valid){
            try {
               String room=scan.nextLine();
               room_number=Integer.parseInt(room); 
               valid=true;
            } catch (NumberFormatException e) {
                System.out.println("ENTER A VALID ROOM_NUMBER");
            }
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservation","root","Hanuman$123");
            String query="DELETE FROM reserved WHERE room_number = ?";
            PreparedStatement stat=conn.prepareStatement(query);
            stat.setInt(1,room_number);
            int rows=stat.executeUpdate();
            if(rows>0)
                System.out.println("ROOM CHECKOUT SUCCESSFULLY");
            else
                System.out.println("SOMETHING WENT WRONG CHECK ROOM_NUMBER ENTERED IS CORRECT\n-----TRY AGAIN-----");
        } catch (Exception e) {
            e.printStackTrace();
        }    
        new Welcome();    
    }
    public static void main(String[] args) {
        new Check_out();
    }
}
