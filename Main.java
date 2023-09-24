package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gradebook gradebook = new Gradebook();

        System.out.println("Welcome to my grade book!");
        System.out.println("Please enter the information of the students using the following format:");
        System.out.println("\"firstName lastName PID grade\"");
        System.out.println("Enter 'Quit' to finish or 'Calculate Min Score' to find the minimum score.");
    
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Quit")) {
                System.out.println("Thank you for using our program!");
                break;
            } else if (input.equalsIgnoreCase("1. Calculate Min Score")) {
                
                try {
                    int minScore = gradebook.calculateMinScore();
                    System.out.println("Minimum Score: " + minScore);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            } else if (input.equalsIgnoreCase("2. Calculate Avg")) {
                // This calculates and prints the average score
                double avgScore = gradebook.calculateAvg();
                System.out.println("Average Score: " + avgScore);
                // This calculates and prints the Median
            } else if (input.equalsIgnoreCase("3. Calculate Median")) {
                float medianScore = gradebook.calculateMedian();
                System.out.println("Median Score: " + medianScore);
            } else if (input.equalsIgnoreCase("4. Calculate Min Letter Grade")) {
                // Calculate and print the minimum letter grade
                try {
                    String minLetterGrade = gradebook.calculateMinLetterGrade();
                    System.out.println("Minimum Letter Grade: " + minLetterGrade);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    }
                } else if (input.equalsIgnoreCase("5. Calculate Max Letter Grade")) {
                // Calculate and print the maximum letter grade
                try {
                    String maxLetterGrade = gradebook.calculateMaxLetterGrade();
                    System.out.println("Maximum Letter Grade: " + maxLetterGrade);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    }
                } else if (input.equalsIgnoreCase("6. Print All Students")) {
                // Prints students information
                gradebook.printAllStudents();
                } else if (input.equalsIgnoreCase("7. Find and Print Letter Grade")) {
                // Find and print letter grade for the Student's PID
                System.out.println("Enter the PID to find the letter grade:");
                int targetPid = scanner.nextInt();
                scanner.nextLine();
                gradebook.findAndPrintLetterGrade(targetPid);
                } else if (input.equalsIgnoreCase("8. Find and Print Full Name")) {
                // Find and print full name for a specific PID
                System.out.println("Enter the PID to find the full name:");
                int targetPid = scanner.nextInt();
                scanner.nextLine();
                gradebook.findAndPrintFullName(targetPid);
                
                /*number #9 goes here dont forget that*/
                
                } else if (input.equalsIgnoreCase("10. Calculate Average Letter Grade")) {
                // Calculate and print the average letter grade for all students
                char avgLetterGrade = gradebook.calculateAverageLetterGrade();
                System.out.println("Average Letter Grade: " + avgLetterGrade);
                } else if (input.equalsIgnoreCase("11. Calculate Median Letter Grade")) {
                // Calculate and print the median letter grade for all students
                char medianLetterGrade = gradebook.calculateMedianLetterGrade();
                System.out.println("Median Letter Grade: " + medianLetterGrade);
                } else if (input.equalsIgnoreCase("12. Print Student Table")) {
                // Print a table of students' information
                gradebook.printStudentTable();
                } else if (input.equalsIgnoreCase("13. Print Student Table with Letter Grades")) {
                // Print a table of students' information with letter grades
                System.out.println("Firstname\tLastname\tPID\tLetter Grade");
                gradebook.printStudentTableWithLetterGrades();
            } else {
                String[] parts = input.split(" ");
                if (parts.length == 4) {
                    String firstName = parts[0];
                    String lastName = parts[1];
                    int pid = Integer.parseInt(parts[2]);
                    int gradeValue = Integer.parseInt(parts[3]);

                    Grade grade = new Grade(gradeValue);
                    Student student = new Student();

                    student.setFirstName(firstName);
                    student.setLastName(lastName);
                    student.setPid(pid);
                    student.setGrade(grade);

                    gradebook.addStudent(student);

                    System.out.println("Student added: " + student.getFirstName() + " " + student.getLastName());
                    System.out.println( "Please type one of the following \n 1. Calculate Min Score \n 2. Calculate Avg \n 3. Calculate Median \n 4. Calculate Min Letter Grade \n 5. Calculate Max Letter Grade \n 6. Print All Students \n 7. Find and Print Letter Grade \n 8. Find and Print Full Name \n 10. Calculate Average Letter Grade \n 11. Calculate Median Letter Grade \n 12. Print Student Table \n 13. Print Student Table with Letter Grades");
                    System.out.println("Please add another student or quit the program.");
                } else {
                    System.out.println("Please use: \"firstName lastName PID grade\"");
                }
            }
        }
    }
}