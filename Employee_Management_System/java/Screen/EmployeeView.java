package Screen;

import DAO.EmployeeDAO;
import data.Employee;

import java.util.Scanner;

public class EmployeeView {
    Scanner sc=new Scanner(System.in);
    public void welcomeView(String email){
        System.out.println("Welcome "+ email);
        System.out.println("Press 1: View Personal Detail");
        System.out.println("Press 2: sign Out");
        int in=sc.nextInt();
        switch (in){
            case 1: personalDetails(email);
            break;
            case 2:System.exit(0);
            break;
            default:
                System.out.println("Enter a Valid Input");
                welcomeView(email);

        }

    }
    void personalDetails(String email){
        Employee em=EmployeeDAO.detail(email);
        System.out.println("Name:- "+em.getName());
        System.out.println("ID:- "+em.getId());
        System.out.println("Department:- "+em.getDepartment());
        System.out.println("email:- "+em.getEmail());
        System.out.println("Contact:- "+em.getContact());
        System.out.println();
        System.out.println();
        System.out.println("Press 1:Back");
        int in=sc.nextInt();
        if(in==1){
            welcomeView(email);
        }
        else{
            System.out.println("Enter a Valid Input");
            personalDetails(email);
        }
    }

}
