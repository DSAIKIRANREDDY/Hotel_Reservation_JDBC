import java.util.Scanner;


class Admin_menu {

    Admin_menu() {
        Scanner scan=new Scanner(System.in);
        int user_option=0;
        boolean valid=false;
        while(!valid){
            try{
                System.out.println("Admin Menu\n-------------------------------------\n1. See all Customers\n2. See all Rooms\n3. See all Transactions\n4. Add a Room\n5. Add Test Data\n6. Back to Main Menu\n-------------------------------------");
                user_option=scan.nextInt();
                if(user_option<1 || user_option>6) 
                    valid=false;
                else
                    valid=true;  
            }
            catch(Exception e){
                scan.next();
            }
        }
        switch(user_option){
            case 1: System.out.println("\nSELECTED TO SEE CUSTOMERS\n");
                new See_customers();
                break;
            case 2: System.out.println("\nSELECTED TO SEE ROOMS\n");
                new See_rooms();
                break;
            case 3: System.out.println("SELECTED TO SEE TRANSACTIONS\n");
                new See_transactions();
                break;
            case 4: System.out.println("\nSELECTED TO ADD ROOOMS\n");
                new Add_room();
                break;
            case 5: System.out.println("\nSELECTED TO TEST_DATA\n");
                // new Test_data();
                break;
            case 6: System.out.println("\nSELECTED TO GO BACK TO MAIN MENU\n");
                new Welcome();
                break;
        }
    }
    
    public static void main(String[] args) {
        new Admin_menu();
    }
}