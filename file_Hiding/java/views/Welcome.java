package views;

import dao.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SendOTPService;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Welcome {
    Scanner sc=new Scanner(System.in);
    public void welcomeScreen(){
         Scanner br=new Scanner(System.in);
        System.out.println("Welcome to the app");
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to signup");
        System.out.println("Press 0 to exit");
        int choice=0;
        choice=Integer.parseInt(br.next());

        switch(choice){
            case 1 :login();
            break;
            case 2 :signUp();
            break;
            case 0 :System.exit(0);
            break;// to exit from the system
        }

    }

    private void signUp() {
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter email");
        String email=sc.nextLine();


        String genOTP= GenerateOTP.getOTP();
        SendOTPService.sendOTP(email, genOTP);
        System.out.println("Enter the otp");
        String otp=sc.nextLine();
        if(otp.equals(genOTP)){
            User user =new User(name,email);
            int response= UserService.saveUser(user);
            switch(response) {
                case 0: System.out.println("User registered");
                break;
                case 1: System.out.println("User already exsited");
                break;
                    }
                }
                else{
                    System.out.println("Wrong opt");
                }
    }

    private void login() {
        System.out.println("Enter email");
        String email=sc.nextLine();
        try{
            if(UserDAO.isExists(email)){
                String genOTP= GenerateOTP.getOTP();
                SendOTPService.sendOTP(email, genOTP);
                System.out.println("Enter the otp");
                String otp=sc.nextLine();
                if(otp.equals(genOTP)){
                   new UserView(email).home();

                }
                else{
                    System.out.println("Wrong opt");
                }
            }
            else{
                System.out.println("User not found");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        
    }


}
