public class Project {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Project retrieveFromDatabase(int id){
        Project p = new Project();
        p.setId(1);
        return p;
    }
}
