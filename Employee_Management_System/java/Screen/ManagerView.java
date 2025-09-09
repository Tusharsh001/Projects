package Screen;

import DAO.EmployeeDAO;
import DAO.ManagerDAO;
import data.Employee;
import data.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerView {
    Scanner sc=new Scanner(System.in);
    public  void welcomeView(String email,String dp){
        String depart=dp;
        System.out.println("Welcome "+email);
        System.out.println("Press 1: View personal Details");
        System.out.println("Press 2: view Department Employee List");
        System.out.println("Press 3: Add New Employee");
        System.out.println("Press 4: Remove Employee");
        System.out.println("Press 0: Sign Out");
        Scanner sc=new Scanner(System.in);
        int in=sc.nextInt();
        switch (in){
            case 1: personlDetails(email,depart);
            break;
            case 2: depatmentList(depart,email);
            break;
            case 3: saveEmployee(depart,email);
            break;
            case 4: removeEmployee(depart,email);
            break;
            case 0: System.exit(0);
            break;
            default:
                System.out.println("Enter a Valid Input ");
                welcomeView(email,depart);
        }

    }
    void personlDetails(String email,String depart){
        Manager details= ManagerDAO.Details(email);
        System.out.println("Name:- "+ details.getName());
        System.out.println("ID:- "+details.getId());
        System.out.println("Department:- "+ details.getDepartment());
        System.out.println("Email:- "+details.getEmail());
        System.out.println("Contact No.:- "+details.getPhoneNumber());

        welcomeView(email,depart);

    }
    void depatmentList(String Depart,String email){
        List<Employee> list= EmployeeDAO.getList(Depart);
        for(Employee i: list){
            System.out.println(i);
        }
        welcomeView(email,Depart);
    }
    void saveEmployee(String depart,String mail){
        System.out.println("Enter Employee Name:-");
        String name=sc.nextLine();
        System.out.println("Enter Employee Email");
        String email=sc.nextLine();
        System.out.println("Enter Contact Number");
        String contact =sc.nextLine();
        System.out.println("Enter Joining Date");
        String join=sc.nextLine();
        System.out.println("Enter Salary");
        String salary =sc.nextLine();
       if( EmployeeDAO.save(name,depart,email,contact,join,salary)){
           System.out.println("Saved");
           welcomeView(mail,depart);
       }



    }
    public void removeEmployee(String depart,String email){
        List <Employee> list=EmployeeDAO.getList(depart);
        for(Employee i:list){
            System.out.println(i);
        }
        System.out.println("Enter The Employee ID");
        int id=sc.nextInt();
        if(EmployeeDAO.remove(id)){
            System.out.println("Removed Successfully");
        }
        else{
            System.out.println("Enter a Valid ID");
            System.out.println("Press 1: Try Again");

            int in=sc.nextInt();
             while(in!=1){
                 System.out.println("Enter a Valid Input");
             }
             removeEmployee(depart,email);
        }
       welcomeView(email,depart);
    }

}
