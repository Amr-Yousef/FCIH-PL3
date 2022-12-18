package classes;
import static classes.employee.emp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class tasksClass implements Serializable{
    FileManagerBinary fmanager = new FileManagerBinary();
    final String taskFileName = "tasks.bin";
    public static ArrayList<tasksClass> tasks = new ArrayList<tasksClass>();
    int id;
    String name;
    String phase;
    String priority;
    int assignedEmpId; 
    String description;
    int assignedLeaderId;
    long stopTimeMillis;
    String stopTime;
    long estimationTime;
    String evalution;
    Date date ;
    String project;
    String submitted = "submitted";
    long startTime;
    String startTimeStr;
   public tasksClass(){};

    public tasksClass(int id , String name, String description , String priority, int assignedEmpId ,int assignedLeaderId , String project) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.assignedEmpId = assignedEmpId;
        this.assignedLeaderId = assignedLeaderId;
        this.description = description;
        this.project = project;
        date = new Date();
        startTime  = (System.currentTimeMillis());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getId() {
        return id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAssignedLeaderId() {
        return assignedLeaderId;
    }

    public void setAssignedLeaderId(int assignedLeaderId) {
        this.assignedLeaderId = assignedLeaderId;
    }

    public long getStopTimeMillis() {
        return stopTimeMillis;
    }

    public void setStopTimeMillis(long stopTimeMillis) {
        this.stopTimeMillis = stopTimeMillis;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public long getEstimationTime() {
        return estimationTime;
    }

    public void setEstimationTime(long estimationTime) {
        this.estimationTime = estimationTime;
    }

    public String getEvalution() {
        return evalution;
    }

    public void setEvalution(String evalution) {
        this.evalution = evalution;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }
    
    
    public int getAssignedEmpId() {
        return assignedEmpId;
    }

    public void setAssignedEmpId(int assignedEmpId) {
        this.assignedEmpId = assignedEmpId;
    }
    
    public boolean addTask()
    {
        loadFromFile();
        employee x = new employee();
        if (id > 0 && getTaskById(this.id) == -1 && x.searchEmployee(assignedEmpId)){
            tasks.add(this);
            return commitToFile();
        }
        return false;
    }

    public boolean addTaskPhase(int id , String phase){
        loadFromFile();
        if (!(tasks.isEmpty()) ){
            int index = getTaskById(id);
            tasks.get(index).setPhase(phase); 
            return commitToFile();
        }
        return false;
    }

    public int getTaskById(int id){
        loadFromFile();
        for(int i=0 ; i<tasks.size() ; i++)
        {
            if (tasks.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public int getTaskByEmpId(int id){
        loadFromFile();
        for(int i=0 ; i<tasks.size() ; i++)
        {
            if (tasks.get(i).getAssignedEmpId() == id);
                return i;
        }
        return -1;
    }

    public boolean updateTask(int id , tasksClass task)
    {
        loadFromFile();
        if (!(tasks.isEmpty()) ){
            int index = getTaskById(id);
            if (index != -1)
            {
                tasks.set(index, task);
                return commitToFile();
            }
        }
        return false;
    }
    
    public boolean deleteTask(int id){
        loadFromFile();
        if (!(emp.isEmpty()) ){
            int index=getTaskById(id);
            if (index!=-1) {
                emp.remove(index);
                return commitToFile();
            }
        }
           return false;
    }
    
    public String empTask(int empId)
    {
        loadFromFile();
        if (!(emp.isEmpty()) ){
            int index = getTaskByEmpId(empId);
            return tasks.get(index).toString();
        }
        return null;
    }
    
//    public String showTasks(){
//        loadFromFile();
//        if (!(emp.isEmpty()) ){
//            System.out.println("\nAll Tasks Data:\n");
//            String s ="";
//            for (tasksClass x : tasks) {
//                s += x.toString();
//            }
//            return s;
//        }
//        return null;
//    }
    
    public boolean searchTask(int id) {
        loadFromFile();
        int index = getTaskById(id);
        if (index != -1) {
            return true;
        } else {
            return false;
        }
    }
    
    public long stopTimeMillis(int empId)
    {
        int index = getTaskByEmpId(empId);
        long time = System.currentTimeMillis();
        return time;
    }
    
    public String stopTime(int Id)
    {
        loadFromFile();
        if (!tasks.isEmpty()){
            int index = getTaskById(Id);
            Date d = new Date();
            String time  = tasks.get(index).stopTime = d.toString();
            commitToFile();
            return time;
        }
        return null;
    }
    
    public String setEvalution(int empId , String eval)
    {
        loadFromFile();
        if (!tasks.isEmpty()){
            int index = getTaskByEmpId(empId);
            tasks.get(index).evalution = eval;
            commitToFile();
            return eval;
        }
        return null;
    }
      
    public boolean commitToFile() {
        return fmanager.write(taskFileName, tasks);
    } 
    
    public void loadFromFile() {
        tasks = (ArrayList<tasksClass>)fmanager.read(taskFileName);
    }
    
    public long setEstimation(){
        return ((stopTimeMillis(this.id) - startTime) / (1000*60*60)) % 24;
    }
    
    public boolean submitTasks(int id){
        loadFromFile();
        if (!(emp.isEmpty()) ){
            int index = getTaskById(id);
            tasks.get(index).setSubmitted(submitted);
            return commitToFile();
        }
        return false;
    }
}       

            
