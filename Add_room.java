import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class Add_room {

    Add_room() {
        Scanner scan=new Scanner(System.in);
        boolean addroom=true;
        
        while(addroom){
            System.out.println("\nEnter room number");
            int room=scan.nextInt();
            System.out.println("Enter price per Night");
            int price=scan.nextInt();
            System.out.println("Enter 1 for single bed, 2 for double bed");
            int bed=scan.nextInt();
            scan.nextLine();
            //add rooms to server
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservation","root","Hanuman$123");
                String query="INSERT INTO addroom(room_number,room_rent,room_type) VALUES(?,?,?)";
                PreparedStatement stat=conn.prepareStatement(query);
                stat.setInt(1,room);
                stat.setInt(2,price);
                stat.setString(3,bed==1?"single bedroom":"double bedroom");
                int rows=stat.executeUpdate();
                if(rows>0) 
                    System.out.println("Room Added");
                else 
                    System.out.println("Failed to add room");
                stat.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    

            //end rooms to server

            System.out.println("Would you like to add another room yorn");
            String add=scan.nextLine();
            if(!add.equals("y"))
                addroom=false;
        }
        new Welcome();
    }
    
    public static void main(String[] args) {
        new Add_room();
    }
}