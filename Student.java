package main;

public class Student {
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade;
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setPid(int pid){
        this.pid = pid;
    }
    
    public int getPid() {
        return pid;
    }
    
    public void setGrade(Grade grade){
        this.grade = grade;
    }
    
    public Grade getgrade() {
        return grade;
    }
}
