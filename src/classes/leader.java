package classes;

import java.util.*;
import java.io.*;

public class leader  extends person implements Serializable{
    
    private int id = 1;
    int check;

    public leader() {
        super("leader", "leader", "marwan", "ahmed");
    }
    
    

   public void setID(int id) {
        this.id =id;
    }
   public int getID() {
        return this.id;
    }
   
   public boolean addTask(int id , String name, String description , String priority, int assignedEmpId ,int assignedLeaderId , String project){
       tasksClass t = new tasksClass(id , name , description , priority , assignedEmpId , assignedLeaderId , project);
        if (t.addTask())
            return true;
        else
            return false;
    }
   
   public boolean updateTask(int oldId , int id , String name , String desc , String priority , int assEmpId , int assLeaderId , String project){
        tasksClass x = new tasksClass(oldId , name , desc , priority , assEmpId , assLeaderId , project);
        if (x.updateTask(oldId , x)) {
           return true;
        } else {
            return false;
        }
   }
   
   public boolean deleteTask(int id){
        tasksClass x = new  tasksClass();
        if (x.deleteTask(id)) {
           return true;
        } else {
            return false;
       }
    }
   
   public boolean login(String userName , String pass){
        if (this.userName.equals(userName) && this.pass.equals(pass))
            return true;
        else
            return false;
    }
   
   public void recieveLeave( String str)
   {
       if (str.equals("accepted"))
           check = 1;
       else if (str.equals("refused"))
           check = 2;
       else
             check = -1;
   }
   
   
   public int leave (int id , String leaveType){
       if (check == 1)
           return 1;
       else if (check == 2)
           return 2; 
       else
           return -1;
   }
   
   public void getAttendance (int id_emp){
       employee e = new employee();
       e.attendance(id_emp);
   }
   
   public void getDeprature (int id_emp){
       employee e = new employee();
       e.departure(id_emp);
   }
   
   public void logOut(){
       System.exit(0);
   }
}

    




