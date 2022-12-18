import employeemanagementsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Task {
    public int getEstimationHours() {
        return estimationHours;
    }

    public void setEstimationHours(int estimationHours) {
        this.estimationHours = estimationHours;
    }

    public int getId() {
        return id;
    }

    public static enum Phase {
        pending,
        under_work,
        testing,
        evaluation,
        canceled
    }

    private int id;
    private String code;
    private String title;
    private String description;
    private Employee assignedEmployee;
    private Phase phase;
    private Project project;
    private int priority;
    private Employee creator;
    private LocalDateTime start;
    private LocalDateTime end;
    private int estimationHours;

    public Task(Employee creator, Employee assignedEmployee, int estimationHours, Project project) throws SQLException {
        this.project = project;
        this.assignedEmployee = assignedEmployee;
        this.creator = creator;
        this.estimationHours = estimationHours;
        this.phase = Phase.pending;
        this.start = LocalDateTime.now();
        end = start.plusHours(estimationHours);
        Connection db = database.connectDb(database.databaseName, database.name, database.password);
        Statement statement = db.createStatement();
        ResultSet rs = statement.executeQuery(" SELECT MAX(`id`) FROM `taskmanagement`.`task`\n");
        rs.next();
        id = rs.getInt(1) + 1;
        db.close();
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void getAssigned(Employee assignedEmployee, LocalDateTime endDate) throws SQLException {
        this.assignedEmployee = assignedEmployee;
        if (phase == Phase.pending && assignedEmployee != null) phase = Phase.under_work;
        Assignment assignment = new Assignment(assignedEmployee, this, endDate);
        assignment.saveToDatabase();
    }


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Employee getCreator() {
        return creator;
    }

    public void setCreator(Employee creator) {
        this.creator = creator;
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

    public void saveToDatabase() throws SQLException {
        Connection db = database.connectDb(database.databaseName, database.name, database.password);
        Statement statement = db.createStatement();
        statement.execute("Insert Into task(code, title, description, assigned_employee_id, phase, project_id, priority," +
                " creator_id, start_date, end_date, estimationHours) " +
                "VALUES ("
                + "'"+code+"'" + ", " + "'"+title+"'" + ", " + "'"+description+"'" + ", " + assignedEmployee.getId() + ", " + phase.ordinal() +
                ", " + project.getId() + ", " + priority +  ", " + creator.getId() + ", " +
                 "'"+java.sql.Timestamp.valueOf(start)+"'" +  ", " + "'"+java.sql.Timestamp.valueOf(end)+"'" +  ", " + estimationHours +
                ")");
        db.close();
    }

    public static Task retrieveFromDatabase(int id) throws SQLException {
        Connection db = database.connectDb(database.databaseName, database.name, database.password);
        Statement statement = db.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from Task where id = " + id);
        rs.next();
        Employee creator = Employee.retrieveFromDatabase(rs.getInt(9));
        Employee assigned = Employee.retrieveFromDatabase(rs.getInt(5));
        Project project1 = Project.retrieveFromDatabase(rs.getInt(7));
        Task task = new Task(creator, assigned, rs.getInt(12), project1);
        task.setCode(rs.getString(2));
        task.setTitle(rs.getString(3));
        task.setDescription(rs.getString(4));
        task.setPhase(Phase.values()[rs.getInt(6)]);
        task.setPriority(rs.getInt(8));
        task.setStart(rs.getTimestamp(10).toLocalDateTime());
        task.setEnd(rs.getTimestamp(11).toLocalDateTime());
        db.close();
        return task;
    }
}