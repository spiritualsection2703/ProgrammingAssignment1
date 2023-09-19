package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to my grade book!");
        System.out.println("Please enter the information of the first student using the following format:");
        System.out.println("\"firstName lastName PID grade\"");
        System.out.println("Please enter 'Done' when you are done.");
    
        Student student = new Student();
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Thank you for using our program!");
                break; 
            } else if (input.equalsIgnoreCase("done")) {
                
                System.out.println("Enter the information for the next student or 'Done' to finish.");
            } else {
                
                String[] parts = input.split(" ");
                if (parts.length == 4) {
                    String firstName = parts[0];
                    String lastName = parts[1];
                    int pid = Integer.parseInt(parts[2]);
                    int gradeValue = Integer.parseInt(parts[3]);
                    
                    
                    Grade grade = new Grade(gradeValue);
                    
                    
                    student.setFirstName(firstName);
                    student.setLastName(lastName);
                    student.setPid(pid);
                    student.setGrade(grade);
                    System.out.println("Student added: " + student.getFirstName() + " " + student.getLastName());
                    System.out.println("Please add another Student or quit the program.");
                } else {
                    System.out.println("Please use: \"firstName lastName PID grade\"");
                }
            }
        }       
    }
}
