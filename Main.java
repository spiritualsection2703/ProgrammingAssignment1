package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gradebook gradebook = new Gradebook();

        //This asks the user to enter the information of the first student via keyboard
        System.out.println("Welcome to my grade book!");
        System.out.println("Please enter the information of the students using the following format:");
        System.out.println("\"firstName lastName PID grade\"");
        System.out.println("Press Enter when you are done");
    
        while (true) {
            String input = scanner.nextLine();
            //"Done" quits the enter program entirely and displays a nice message for the user
            if (input.equalsIgnoreCase("Done")) {
                System.out.println("Thank you for using our program!");
                break;
                // 1. Calculate Min Score = Calculates the minimum score
            } else if (input.equalsIgnoreCase("1. Calculate Min Score")) {
                try {
                    int minScore = gradebook.calculateMinScore();
                    System.out.println("Minimum Score: " + minScore);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
                        // 2. Calculate Avg = This calculates and prints the average score
            } else if (input.equalsIgnoreCase("2. Calculate Avg")) {
                double avgScore = gradebook.calculateAvg();
                System.out.println("Average Score: " + avgScore);
                        // 3. Calculate Median This calculates and prints the Median
            } else if (input.equalsIgnoreCase("3. Calculate Median")) {
                float medianScore = gradebook.calculateMedian();
                System.out.println("Median Score: " + medianScore);
                        // 4. Calculate Min Letter Grade = This calculates Min Letter Grade
            } else if (input.equalsIgnoreCase("4. Calculate Min Letter Grade")) {
                try {
                    String minLetterGrade = gradebook.calculateMinLetterGrade();
                    System.out.println("Minimum Letter Grade: " + minLetterGrade);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    }
                        //5. Calculate Max Letter Grade = Calculate and print the maximum letter grade
                } else if (input.equalsIgnoreCase("5. Calculate Max Letter Grade")) {
                try {
                    String maxLetterGrade = gradebook.calculateMaxLetterGrade();
                    System.out.println("Maximum Letter Grade: " + maxLetterGrade);
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                    }
                        //6. Print All Students = Prints all students information
                } else if (input.equalsIgnoreCase("6. Print All Students")) {
                gradebook.printAllStudents();
                        // 7. Find and Print Letter Grade = Find and print letter grade for a specific PID
                } else if (input.equalsIgnoreCase("7. Find and Print Letter Grade")) {
                System.out.println("Enter the PID to find the letter grade:");
                int targetPid = scanner.nextInt();
                scanner.nextLine();
                gradebook.findAndPrintLetterGrade(targetPid);
                        // 8. Find and Print Full Name = Find and print full name for a specific PID
                } else if (input.equalsIgnoreCase("8. Find and Print Full Name")) {
                System.out.println("Enter the PID to find the full name:");
                int targetPid = scanner.nextInt();
                scanner.nextLine();
                gradebook.findAndPrintFullName(targetPid);
                        // 9. Update Student Grade = Update student's grade by their PID
                } else if (input.equals("9. Update Student Grade")) {
                System.out.println("Enter the PID to update grade score:");
                int targetPid = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("Enter the new grade symbol:");
                String newGradeSymbol = scanner.nextLine();
                gradebook.updateStudentGrade(targetPid, newGradeSymbol);
                        //10. Calculate Average Letter Grade = Calculate and print the average letter grade for all students
                } else if (input.equalsIgnoreCase("10. Calculate Average Letter Grade")) {
                char avgLetterGrade = gradebook.calculateAverageLetterGrade();
                System.out.println("Average Letter Grade: " + avgLetterGrade);
                        //11. Calculate Median Letter Grade = Calculate and print the median letter grade for all students
                } else if (input.equalsIgnoreCase("11. Calculate Median Letter Grade")) {
                char medianLetterGrade = gradebook.calculateMedianLetterGrade();
                System.out.println("Median Letter Grade: " + medianLetterGrade);
                        //12. Print Student Table = Print a table of students' information
                } else if (input.equalsIgnoreCase("12. Print Student Table")) {
                gradebook.printStudentTable();
                // 13. Print Student Table with Letter Grades = Print a table of students' information with letter grades
                } else if (input.equalsIgnoreCase("13. Print Student Table with Letter Grades")) {
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
                    
                    // This displays the mutiple options the user can use
                    System.out.println("Student added: " + student.getFirstName() + " " + student.getLastName());
                    System.out.println( "Please type one of the following \n 1. Calculate Min Score \n 2. Calculate Avg \n 3. Calculate Median \n 4. Calculate Min Letter Grade \n 5. Calculate Max Letter Grade \n 6. Print All Students \n 7. Find and Print Letter Grade \n 8. Find and Print Full Name \n 9. Update Student Grade \n 10. Calculate Average Letter Grade \n 11. Calculate Median Letter Grade \n 12. Print Student Table \n 13. Print Student Table with Letter Grades");
                    System.out.println("Please enter the information of the next student using the same format \nIf there is no more students, please enter the keyword \"Done\"\nPress Enter when you are done.");
                } else {
                    System.out.println("Please use: \"firstName lastName PID grade\"");
                }
            }
        }
    }
}