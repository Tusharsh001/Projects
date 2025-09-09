package DAO;

import data.Manager;
import db.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO {

    public static  String  ManagerbyEmail(String email){
        Connection connection= MyConnection.getConnection();
        String mail="";
        try {
            PreparedStatement ps=connection.prepareStatement("select *from Manager where email=?");
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                 mail= rs.getString(4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return  mail;
    }

    public static Manager Details(String email){
        Connection connection=MyConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("select * from Manager where email=?");
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt(1);
                String name= rs.getString(2);
                String department =rs.getString(3);
                String mail=email;
                String phone=rs.getString(5);
                Manager manager =new Manager(id,name,department,mail,phone);
                return manager;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
