/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;

/**
 *
 * @author MarcoMan
 * Subscribe our Channel --> https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ
 * Thanks for the support guys! <3
 */
public class database {
    public static String name = "root";
    public static String password = "password";
    public static String databaseName = "taskmanagement";
    public static String port = "3306";


    public static Connection connectDb(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    public static Connection connectDb(String DBName, String user, String password, String port){

        try{

//            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + DBName, user, password);
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    public static Connection connectDb(String DBName, String user, String password){
        return connectDb(DBName, user, password, "3306");
    }
}
