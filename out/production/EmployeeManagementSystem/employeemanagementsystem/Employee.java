import employeemanagementsystem.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static enum Type{
        leader,
        senior,
        junior
    }
    private int id;
    private String name;
    private Type type;

    public Employee(String name, Type type) throws SQLException {
        this.name = name;
        this.type = type;
        Connection db = database.connectDb(database.databaseName, database.name, database.password);
        Statement statement = db.createStatement();
        ResultSet rs = statement.executeQuery(" SELECT MAX(`id`) FROM `taskmanagement`.`employee`\n");
        rs.next();
        id = rs.getInt(1) + 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Employee retrieveFromDatabase(int id) throws SQLException {
        Connection db = database.connectDb(database.databaseName, database.name, database.password);
        Statement statement = db.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from employee where id = " + id);
        rs.next();
        Employee employee = new Employee(rs.getString(2), Type.values()[rs.getInt(3)]);
        db.close();
        return employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void saveToDatabase() throws SQLException {
        Connection db = database.connectDb(database.databaseName, database.name, database.password);
        Statement statement = db.createStatement();
        statement.execute(
                "INSERT INTO employee (name, type)"+
                "VALUES ("+"'"+this.name+"'"+", "+
                        type.ordinal()+
                        ")"
        );
        db.close();
    }
}
