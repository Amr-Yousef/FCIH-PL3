package classes;

import java.util.*;
import java.io.*;
public class adminClass extends person implements Serializable{
    

    public adminClass() {
        super("admin", "admin", "moaaz", "mostafa");
    }  
    
    public boolean addEmployee(String typeOfEmp , int id , String userName , String pass , String fname , String lname){
        employee e = new employee(id , userName , pass , fname , lname , typeOfEmp);
            if (e.addemployee())
                return true;
            return false;                    
        }
    
    public boolean updateEmployee(int oldId , String typeOfEmp , int id , String userName , String pass , String fname , String lname){
        employee e = new employee(oldId , userName , pass , fname , lname , typeOfEmp);
        if (e.updateEmployee(oldId, e))
            return true;
        else
            return false;
    }
    
    public boolean deleteEmployee(int id){
        employee e = new employee();
        if(e.deleteEmployee(id)) 
            return true;
        return false;
    }
    
    public boolean addCustomer(int id , String name){
        customer c = new customer(id , name);
        if (c.addcustomer())
            return true;
        return false;                    
    }
    
    public boolean updateCustomer(int oldId , int id ,String name){
        customer c = new customer(id , name);
        if (c.updatecustomer(oldId, c))
            return true;
        else
            return false;
    }
    
    public boolean deleteCustomer(int id){
        customer c = new customer();
        if(c.deleteCustomer(id)) 
            return true;
        return false;
    }
    
    public boolean addTaskPhase(int id , String phase){
        tasksClass t = new tasksClass();
        if (t.addTaskPhase(id, phase))
            return true;                   
        else
            return false;
    }
    
    
    public boolean login(String userName , String pass){
        if (this.userName.equals(userName) && this.pass.equals(pass))
            return true;
        else
            return false;
    }
    
    public void logout(){
        System.exit(0);
    }
}
