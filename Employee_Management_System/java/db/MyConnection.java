package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
     static Connection connection=null;
    public static Connection getConnection()  {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             // the url is same for the mysql if not changed the localhost 3306
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeData","username","password");
//            System.out.println("connection is Done");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }



}

