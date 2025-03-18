import java.util.Scanner;

class Welcome {

    public Welcome() {
        Scanner scan=new Scanner(System.in);
        int user_option=0;
        boolean valid=false;
        while(!valid){
            try{
                System.out.println(" WELCOME TO THE HOTEL RESERVATION APPLICATION\n\n---------------------------------------------\n1. Find and reserve a room\n2. Check out the room\n3. See my reservations\n4. Create an account\n5. Admin\n6. Exit\n--------------------------------------------\n PLEASE SELECT A NUMBER FOR THE MENU OTION");
                user_option=scan.nextInt();
                if(user_option>5 || user_option<1) 
                    valid=false;
                else
                    valid=true;
            }
            catch(Exception e){
                scan.next();
            }
        }
        switch(user_option){
            case 1: System.out.println("\nSELECTED FOR RESERVING ROOM\n");
                new Reserve_room();
                break;
            case 2: System.out.println("\nSELECTED FOR CHECK_OUT");
                new Check_out();
                break;
            case 3: System.out.println("\nSELECTED FOR SEEING FOR RESERVATIONS\n");
                new See_Reservations();
                break;
            case 4: System.out.println("\nSELECTED FOR ACCOUNT CREATION\n");
                new Account_creation();
                break;
            case 5: System.out.println("\nSELECTED FOR ADMIN_MENU\n");
                new Admin_menu();
                break;
            case 6: System.out.println("\nEXITING THE PAGE\n");
                return;
        }
    }
    public static void main(String[] args) {
        new Welcome();        
    }
}
