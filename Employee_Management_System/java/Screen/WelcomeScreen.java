package Screen;

import DAO.EmployeeDAO;
import DAO.ManagerDAO;
import data.Employee;
import data.Manager;

import java.util.Scanner;

public class WelcomeScreen {
    Scanner sc=new Scanner(System.in);
    public void w(){
        do {
            System.out.println("Welcome To Application ");
            System.out.println("Press 1: Manager");
            System.out.println("Press 2: Employees");
            System.out.println("Press 0: to Exit");

            int inp = sc.nextInt();
            switch (inp) {
                case 1:
                    loginM();
                    break;
                case 2:
                    loginE();
                    break;
                case 0:
                    System.exit(0);

            }
        }
        while(true);

    }
    void loginM(){
        System.out.println("Please Enter your Email");
          sc.nextLine();
        String email=sc.nextLine();
        System.out.println("Enter Your Department");
        String dp=sc.nextLine();
        String mail= ManagerDAO.ManagerbyEmail(email);
        if(mail.equals(email)){
           ManagerView view=new ManagerView();
           view.welcomeView(email,dp);
        }
        else{
            System.out.println("Press 1: Try Again");
            System.out.println("Press 2: Home");
            int wrong=sc.nextInt();
            switch (wrong){
                case 1: loginE();
                    break;
                case 2: w();
            }
        }
    }
    void loginE(){
        System.out.println("Please Enter you Email");
        sc.nextLine();
        String email=sc.nextLine();
        String mail= EmployeeDAO.getEmail(email);
        if(mail.equals(email)){
            EmployeeView view=new EmployeeView();
          view.welcomeView(email);
        }
        else{

            System.out.println("Press 1: Try Again");
            System.out.println("Press 2: Home");
            int wrong=sc.nextInt();
            switch (wrong){
                case 1: loginE();
                break;
                case 2: w();
                default:
                    loginE();
            }

        }

    }

}
