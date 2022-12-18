package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class employee extends person implements Serializable{

    int id_emp;
    int idLogin;
    int x;
    String absentOrAttend;
    String type_emp;
    String loginUserName;
    final String empFilePath="emp.bin";
    public static ArrayList<employee> emp = new ArrayList<employee>();
    
    public int getID (){
        return idLogin;
    }
    
    public employee(){
    }
    
    public employee(int id , String userName , String pass ,String fname , String lname,String type_emp) {
        super( userName,  pass,  fname,  lname);
        this.id_emp=id;
        this.type_emp= type_emp;
    }
    // getter and setter employee
    public int getId_emp() {
        return id_emp;
    }

    public String getAbsentOrAttend() {
        return absentOrAttend;
    }

    public void setAbsentOrAttend(String absentOrAttend) {
        this.absentOrAttend = absentOrAttend;
    }
   
    public String getType_emp() {
        return type_emp;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
    
    
    public void setType_emp(String type_emp) {
        this.type_emp = type_emp;
    }
        
    @Override
    public String getFname(){
        return this.fname;
    }
    
    
    @Override
    public String getLname(){
        return this.lname;
    }
    
    public void setId_emp(int id_emp) {
    this.id_emp = id_emp;
    }    
    
    public boolean addemployee(){
        loadFromFileEmp();
        if (this.id_emp > 0 && getEmployeeIndex(this.id_emp) == -1 && checkLogIn(getUserName(), getPass()))
        {
            emp.add(this);
            return commitToFileEmp();
        }
        else
            return false;
    }
    
    public boolean searchEmployee(int id) {
        loadFromFileEmp();
        int index = getEmployeeIndex(id);
        if (index != -1) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getEmployeeIndex(int Id){
        loadFromFileEmp();
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).getId_emp()== Id) {
                return i;
            }       
        }
        return  -1;   
    }
    
    public void getEmpIdByUserName(String userName){
        loadFromFileEmp();
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).getUserName().equals(userName)) {
                idLogin = emp.get(i).id_emp;
            }       
        }  
    }
     
    public boolean deleteEmployee(int id){
        loadFromFileEmp();
        if (!(emp.isEmpty()) ){
            int index=getEmployeeIndex(id);
            if (index!=-1) {
                emp.remove(index);
                return commitToFileEmp();
            }
        }
       return false;
    }
    
    public boolean updateEmployee(int oldId, employee e){
        loadFromFileEmp();
        if (!(emp.isEmpty()) ){
            int index=getEmployeeIndex(oldId);
            if (index!=-1) {
                emp.set(index, e);
                return commitToFileEmp();
            }
        }
       return false;
    }
    
    public boolean submittask(){
        tasksClass t = new tasksClass();
        t.stopTime(id_emp);
        t.stopTimeMillis(id_emp);
        t.setEstimation();
        t.submitTasks(id_emp);
        return true;
        } 

    public void attendance(int id){
        loadFromFileEmp();
        int index = getEmployeeIndex(id);
        if (index!=-1){
            emp.get(index).setAbsentOrAttend("Attendant");
        }
        commitToFileEmp();
}
    public void departure(int id){
        loadFromFileEmp();
        int index = getEmployeeIndex(id);
        if (index!=-1){
            emp.get(index).setAbsentOrAttend("Absent");
        }
        commitToFileEmp();
    }
    
    public boolean checkLogIn(String user , String pass)
    {
        loadFromFileEmp();
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).getUserName().equals(user) && emp.get(i).getPass().equals(pass)) {
                    return false;
            }
        }
        return true;
    }
    
   public boolean logIn(String userName , String password){
       loadFromFileEmp();
       for (employee e : emp){
           if ((e.userName.equals(userName) && e.pass.equals(password)) ){   
                getEmpIdByUserName(userName);
                return true;
           }               
       }
       return false;
   }
   
   public  String leaveRequest(String leaveType){
       leader l = new leader();
       if (l.leave(id_emp, leaveType) == 1)
           return "accepted";
       else if (l.leave(id_emp, leaveType) == 2)
           return "refused";
       else
           return "Pending";
   }
   
   public boolean commitToFileEmp(){
        return fmanager.write(empFilePath, emp);
    }
   
   public void loadFromFileEmp() {
            emp = (ArrayList<employee>) fmanager.read(empFilePath);
    }
   
}
   