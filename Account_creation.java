import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class Account_creation {

    public Account_creation() {
        Scanner scan=new Scanner(System.in);

        System.out.println("Enter Email format: nam@domain.com");
        String email=scan.nextLine().trim();
        System.out.printf("First Name: ");
        String firstname=scan.nextLine().trim();
        System.out.printf("Last Name: ");
        String lastname=scan.nextLine().trim();
        
        //store the user information
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelReservation","root", "Hanuman$123");
            String query="INSERT INTO acccreation(email,firstname,lastname) values(?,?,?)";
            PreparedStatement stat=conn.prepareStatement(query);
            stat.setString(1,email);
            stat.setString(2,firstname);
            stat.setString(3,lastname);
            int rows=stat.executeUpdate();
            if(rows>0)
                System.out.println("ACCOUNT SUCCESSFULLY CREATED");
            else
                System.out.println("ACCOUNT CREATION UNSUCCESFULL\nTRY AGAIN....");
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Welcome();
    }
    public static void main(String[] args) {
        new Account_creation();
    }
}