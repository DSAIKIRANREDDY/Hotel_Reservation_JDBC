import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Reserve_room{
    Reserve_room(){
        Map<Integer,Double> listrooms=new HashMap<>();
        Scanner scan=new Scanner(System.in);
        System.out.printf("Enter CheckIn Date mm/dd/yyyy example 03/05/2025:  ");
        String checkin=scan.nextLine().trim();
        System.out.printf("Enter CheckOut Date mm/dd/yyyy example 04/05/2025:  ");
        String checkout=scan.nextLine().trim();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservation","root","Hanuman$123");
            Statement stat=conn.createStatement();
            String query="SELECT room_number,room_rent,room_type FROM addroom WHERE room_number NOT IN (SELECT room_number FROM reserved)";   //required
            ResultSet resultSet=stat.executeQuery(query);
            if(resultSet.next()){
                do { 
                    System.out.println("ROOM_NUMBER:"+resultSet.getInt(1)+" ROOM_RENT:"+resultSet.getString(2)+" ROOM_TYPE:"+resultSet.getString(3)); //required
                    listrooms.put(resultSet.getInt(1),Double.parseDouble(resultSet.getString(2)));
                } while (resultSet.next());
            }
            else{
                System.out.println("SORRY ALL ROOMS FILLED");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Would you like to book a room? y/n");
        String bookrno=scan.nextLine().trim();
        if(bookrno.equals("n")){
            new Welcome();
            return;
        }
        else{
            System.out.println("Do you have an account with us? y/n");
            String haveaccount=scan.nextLine().trim();
            System.out.println("Enter Name: THOR ODISON");
            String name=scan.nextLine().trim();
            System.out.println("Enter Email Address: name@domain.com");
            String email=scan.nextLine().trim();
            System.out.println("What room number would like to reserve");
            int room=0;
            boolean valid=false;
            while(!valid){
                try {
                    room=Integer.parseInt(scan.nextLine());
                    if(listrooms.containsKey(room))
                        valid=true;
                    else
                        System.out.println("ENTER ROOM FROM ABOVE LIST");
                } catch (NumberFormatException e) {
                    System.out.println("ENTER A VALID ROOM NUMBER");
                }
            }
            int days=0;
            boolean validdays=false;
            System.out.println("ENTER NUMBER OF DAYS:");
            while(!validdays){
                try {
                    days=Integer.parseInt(scan.nextLine());
                    validdays=true;
                } catch (NumberFormatException e) {
                    System.out.println("ENTER A VALID NUMBER OF DAYS");
                }
            }
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservation","root","Hanuman$123");
                String query1="INSERT INTO reserved VALUES(?,?,?,?,?)";
                PreparedStatement stat1=conn.prepareStatement(query1);
                stat1.setInt(1,room);
                stat1.setString(2,name);
                stat1.setString(3,email);
                stat1.setString(4,checkin);
                stat1.setString(5,checkout);
                int rows=stat1.executeUpdate();
                if(rows>0){
                    System.out.println("ROOM__NUMBER: "+room+" CHECK_IN: "+checkin+" CHECK_OUT: "+checkout);
                    System.out.println("--**ROOM RESERVED**--\n---**ENJOY STAY**---");
                }
                else{
                    System.out.println("ROOM UNABLE TO RESERVE/n.....TRY AGAIN.....");
                }
                String query2="INSERT INTO transactions(room_number,customer,email,check_in,check_out,days,total_rent) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement stat2=conn.prepareStatement(query2);
                stat2.setInt(1,room);
                stat2.setString(2,name);
                stat2.setString(3,email);
                stat2.setString(4,checkin);
                stat2.setString(5,checkout);
                stat2.setInt(6,days);
                double total=days*listrooms.get(room);
                stat2.setDouble(7,total);
                int rows1=stat2.executeUpdate();
                if(rows1>0){
                    System.out.println("=====Transaction Added Successfully=====");
                }
                else{
                    System.out.println("=====Transaction Not Saved=====");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        new Welcome();
    }
    public static void main(String[] args) {
        new Reserve_room();
    }
}