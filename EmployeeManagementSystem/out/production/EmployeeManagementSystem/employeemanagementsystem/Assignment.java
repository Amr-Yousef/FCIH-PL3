import employeemanagementsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Assignment {
    private Task task;
    private Employee employee;
    private LocalDateTime start;
    private LocalDateTime end;

    public Assignment(Employee employee, Task task, LocalDateTime end){
        this.employee = employee;
        this.task = task;
        this.start = LocalDateTime.now();
        this.end = end;
    }

    public void saveToDatabase() throws SQLException {
        Connection db = database.connectDb(database.databaseName, database.name, database.password);
        Statement statement = db.createStatement();
        statement.execute(
                "INSERT INTO task_assignment (employee_id, task_id, start_date, end_date)"+
                "VALUES ("+employee.getId()+", "+
                        task.getId()+", "+
                        "'"+java.sql.Timestamp.valueOf(start)+"'"+", "+
                        "'"+java.sql.Timestamp.valueOf(end)+"'"+
                        ")"
        );
        db.close();
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public static ArrayList<Assignment> getLog() throws SQLException {
        ArrayList<Assignment> log = new ArrayList<>();
        Connection db = database.connectDb(database.databaseName, database.name, database.password);
        Statement statement = db.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from task_assignment order by start_date desc");
        while (rs.next()){
            Employee employee1 = Employee.retrieveFromDatabase(rs.getInt(1));
            Task task1 = Task.retrieveFromDatabase(rs.getInt(2));
            Assignment assignment = new Assignment(employee1, task1, rs.getTimestamp(4).toLocalDateTime());
            assignment.setStart(rs.getTimestamp(3).toLocalDateTime());
            log.add(assignment);
        }
        db.close();
        return log;
    }
}
