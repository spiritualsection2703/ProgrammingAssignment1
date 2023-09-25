package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Gradebook {
    private ArrayList<Student> listOfStudents;
    
    
    public Gradebook() {
        listOfStudents = new ArrayList<>();
    }

    public void addStudent(Student student) {
        listOfStudents.add(student);
    }
    
    // This method calculates the score then converts it to a letter grade
    public static String calculateScoreToLetter(double score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    // This method calculates the minimum score
    public int calculateMinScore() {
        if (listOfStudents.isEmpty()) {
            throw new IllegalStateException("Please add students to the gradebook.");
        }

        int minScore = listOfStudents.get(0).getGrade().getScore();
        for (Student s : listOfStudents) {
            int score = s.getGrade().getScore();
            if (score < minScore) {
                minScore = score;
            }
        }
        return minScore;
    }

    // This method calculates the average
    public double calculateAvg() {
        double sum = 0;
        for (Student s : listOfStudents)
            sum += s.getGrade().getScore();
        return sum / listOfStudents.size();
    }

    // This method calculates median
    public float calculateMedian() {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for (Student s : listOfStudents)
            scores[i++] = s.getGrade().getScore();
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f;
        else
            return scores[n / 2];
    }

    // This method calculates the minimum letter grade
    public String calculateMinLetterGrade() {
    if (listOfStudents.isEmpty()) {
        throw new IllegalStateException("No students in the gradebook.");
    }

    String minLetterGrade = null;

    for (Student s : listOfStudents) {
        int score = s.getGrade().getScore();

        
        String letterGrade = calculateScoreToLetter(score);

       
        if (letterGrade == null) {
            continue;
        }

        if (minLetterGrade == null || letterGrade.compareTo(minLetterGrade) > 0) {
            minLetterGrade = letterGrade;
        }
    }

    if (minLetterGrade == null) {
        throw new IllegalStateException("No minimum letter grade could be found.");
    }

    return minLetterGrade;
}

    //This method calculates the maximum letter grade
    public String calculateMaxLetterGrade() {
    if (listOfStudents.isEmpty()) {
        throw new IllegalStateException("No students in the gradebook.");
    }

    String maxLetterGrade = null;

    for (Student s : listOfStudents) {
        int score = s.getGrade().getScore();

        String letterGrade = calculateScoreToLetter(score);

        if (letterGrade == null) {
            continue;
        }

        if (maxLetterGrade == null || letterGrade.compareTo(maxLetterGrade) < 0) {
            maxLetterGrade = letterGrade;
        }
    }

    if (maxLetterGrade == null) {
        throw new IllegalStateException("No maximum letter grade could found.");
    }

    return maxLetterGrade;
}

    //This method prints out all the student's information
    public void printAllStudents() {
        for (Student s : listOfStudents)
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }
    
    //This method finds the student's PID and then prints their letter
    public void findAndPrintLetterGrade(int targetPid) {
    for (Student s : listOfStudents) {
        if (s.getPid() == targetPid) {
            Grade grade = s.getGrade();
            if (grade != null) {
                String letterGrade = grade.getLetterGrade();
                if (letterGrade != null) {
                    System.out.println("Letter Grade for PID " + targetPid + ": " + letterGrade);
                } else {
                    double score = grade.getScore();
                    String calculatedLetterGrade = calculateScoreToLetter(score);
                    System.out.println("Calculated Letter Grade for PID " + targetPid + ": " + calculatedLetterGrade);
                }
            } else {
                System.out.println("Grade information for PID " + targetPid + " is not available.");
            }
            return;
        }
    }

    System.out.println("Student with PID " + targetPid + " not found in the gradebook.");
}
    
    //This method uses the PID of the student to print out their name and last name
    public void findAndPrintFullName(int targetPid) {
    for (Student s : listOfStudents) {
        if (s.getPid() == targetPid) {
            String fullName = s.getFirstName() + " " + s.getLastName();
            System.out.println("Student's PID " + targetPid + ": " + fullName);
            return; 
        }
    }
    
    System.out.println("Student with PID " + targetPid + " not found in the gradebook.");
    }
    
    //This method uses the PID of the student to update their grade
    public void updateStudentGrade(int targetPid, String newGradeSymbol) {
    for (Student s : listOfStudents) {
        if (s.getPid() == targetPid) {
            s.getGrade().setLetterGrade(newGradeSymbol);
            System.out.println("Update grade by using PID " + targetPid + " to " + newGradeSymbol);
            return;
        }
    }
    
    System.out.println("Student with PID " + targetPid + " not found in the gradebook.");
    }

    //This method calculates the average letter grade
    public char calculateAverageLetterGrade() {
        if (listOfStudents.isEmpty()) {
            throw new IllegalStateException("There are no students in the gradebook.");
        }

        double averageScore = calculateAvg(); 


        if (averageScore >= 90.0) {
            return 'A';
        } else if (averageScore >= 80.0) {
            return 'B';
        } else if (averageScore >= 70.0) {
            return 'C';
        } else if (averageScore >= 60.0) {
            return 'D';
        } else {
            return 'F';
        }
    }    

     //This method calculates the median letter grade
    public char calculateMedianLetterGrade() {
        if (listOfStudents.isEmpty()) {
            throw new IllegalStateException("No students in the gradebook.");
        }

        float medianScore = calculateMedian();

        if (medianScore >= 90.0f) {
            return 'A';
        } else if (medianScore >= 80.0f) {
            return 'B';
        } else if (medianScore >= 70.0f) {
            return 'C';
        } else if (medianScore >= 60.0f) {
            return 'D';
        } else {
            return 'F';
        }
    }

    //this method prints out all students information in a table with their score
    public void printStudentTable() {
        System.out.println("first Name\tLast Name\tPID\tScore");
        for (Student s : listOfStudents) {
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
        }
    }

    //This method prints out all students information in a table with the their letter grade
    public void printStudentTableWithLetterGrades() {
    System.out.println("First Name\tLast Name\tPID\tLetter Grade");
    for (Student s : listOfStudents) {
        int score = s.getGrade().getScore();
        String letterGrade = calculateScoreToLetter(score);

        System.out.printf("%s\t%s\t%d\t%s\n", s.getFirstName(), s.getLastName(), s.getPid(), letterGrade);
    }
}


}
