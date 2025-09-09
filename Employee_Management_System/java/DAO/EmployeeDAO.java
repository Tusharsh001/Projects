package DAO;

import data.Employee;
import db.MyConnection;


import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static List<Employee> getList(String depart){
        Connection connection= MyConnection.getConnection();
        List <Employee> list=new ArrayList<>();

        try {
            PreparedStatement ps=connection.prepareStatement("select * from employee where department=?");
            ps.setString(1,depart);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id =rs.getInt(1);
                String name =rs.getString(2);
                String depat=rs.getString(3);
                String email=rs.getString(4);
                String contact=rs.getString(5);
                String joiningDate=rs.getString(6);
                String salary =rs.getString(7);
                Employee em=new Employee(id,name,depart,email,contact,joiningDate,salary);
                list.add(em);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean save(String name,String depart,String email,String contact,String joiningDate,String salary){
        Connection connection=MyConnection.getConnection();
         int rs=0;
        try {
            PreparedStatement ps=connection.prepareStatement("insert into employee values(default,?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,depart);
            ps.setString(3,email);
            ps.setString(4,contact);
            ps.setString(5,joiningDate);
            ps.setString(6,salary);
            rs=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return rs==1? true:false;
    }


    // remove the employe using the id only of the employee
    public static boolean remove(int Id){
        Connection connection =MyConnection.getConnection();
        int rs=0;
        try {
            PreparedStatement ps = connection.prepareStatement("delete from employee where id=?");
            ps.setInt(1,Id);
            rs=ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return rs==1? true:false;
    }

    public static String getEmail(String mail){
         Connection connection=MyConnection.getConnection();
         String email="";
         try {
             PreparedStatement ps = connection.prepareStatement("select * from employee where email=?");
             ps.setString(1,mail);
             ResultSet rs=ps.executeQuery();
             while(rs.next()){
                email= rs.getString(4);
             }
         }
         catch (SQLException e){
             e.printStackTrace();
         }
         return email;
    }

    public static Employee detail(String email){
        Connection connetion=MyConnection.getConnection();
        Employee em=null;
        try {
            PreparedStatement ps = connetion.prepareStatement("select * from employee where email=?");
            ps.setString(1, email);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String depat=rs.getString(3);
                String contact=rs.getString(5);
                String mail=rs.getString(4);
                em=new Employee(id,name,depat,mail,contact);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return em;
    }




}
