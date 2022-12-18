package classes;
import GUI.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String projectPath = System.getProperty("user.dir");
        System.out.println("project path : " + projectPath);
        File currentDir = new File(projectPath);
        checkDirectoryContents(currentDir);
          Login log1 = new Login();
          log1.setVisible(true);
    
    }
    
    public static void checkDirectoryContents(File dir) {
        
        File[] files = dir.listFiles();
        boolean empFile = true;
        boolean cusFile = true;
        boolean taskFile = true;
        for(File file : files){
            if (file.getName().contains("emp.bin")){
                    empFile = false;
            }
            
            else if (file.getName().contains("cus.bin")){
                    cusFile = false;
            }
            
            else if (file.getName().contains("tasks.bin")){
                    taskFile = false;
            }
        }
       if (empFile){
           employee x = new employee();
           x.commitToFileEmp();
       }  
       
       if (cusFile){
           customer x = new customer();
           x.commitToFilecus();
       }
       
       if (taskFile){
           tasksClass x = new tasksClass();
           x.commitToFile();
       }
    }
        
}
