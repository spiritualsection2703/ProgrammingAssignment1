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
    
    // This is the main #1
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

    //This is the main #2
    public double calculateAvg() {
        double sum = 0;
        for (Student s : listOfStudents)
            sum += s.getGrade().getScore();
        return sum / listOfStudents.size();
    }

    //This is the main #3
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

    // This is the main #4 NEEDS TO BE FIXED
    public String calculateMinLetterGrade() {
    if (listOfStudents.isEmpty()) {
        throw new IllegalStateException("No students in the gradebook.");
    }

    String minLetterGrade = null;

    for (Student s : listOfStudents) {
        String letterGrade = s.getGrade().getLetterGrade();
        
        // Ignore students with null letter grades
        if (letterGrade == null) {
            continue;
        }

        // If minLetterGrade is null or letterGrade is smaller, update minLetterGrade
        if (minLetterGrade == null || letterGrade.compareTo(minLetterGrade) < 0) {
            minLetterGrade = letterGrade;
        }
    }

    if (minLetterGrade == null) {
        throw new IllegalStateException("No valid minimum letter grade found.");
    }

    return minLetterGrade;
}

    //This is the main #5 NEEDS TO BE FIXED
    public String calculateMaxLetterGrade() {
    if (listOfStudents.isEmpty()) {
        throw new IllegalStateException("No students in the gradebook.");
    }

    String maxLetterGrade = listOfStudents.get(0).getGrade().getLetterGrade();
    for (Student s : listOfStudents) {
        String letterGrade = s.getGrade().getLetterGrade();
        if (letterGrade.compareTo(maxLetterGrade) > 0) {
            maxLetterGrade = letterGrade;
        }
    }
        return maxLetterGrade;
    }

    //This is the main #6
    public void printAllStudents() {
        for (Student s : listOfStudents)
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }
    
    //this is the main #7 Output displays "null"
    public void findAndPrintLetterGrade(int targetPid) {
    for (Student s : listOfStudents) {
        if (s.getPid() == targetPid) {
            String letterGrade = s.getGrade().getLetterGrade();
            System.out.println("Letter Grade for PID " + targetPid + ": " + letterGrade);
            return;
        }
    }
    
        System.out.println("Student with PID " + targetPid + " not found in the gradebook.");
    }
    
    //This is the main #8
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
    
    //This is the main #9 newGradeSymbol change it to string not char?
    public void updateStudentGrade(int targetPid, String newGradeSymbol) {
    for (Student s : listOfStudents) {
        if (s.getPid() == targetPid) {
            s.getGrade().setLetterGrade(newGradeSymbol);
            System.out.println("Updated grade for PID " + targetPid + " to " + newGradeSymbol);
            return;
        }
    }
    
    System.out.println("Student with PID " + targetPid + " not found in the gradebook.");
    }

    //This is the main #10 This works
    public char calculateAverageLetterGrade() {
        if (listOfStudents.isEmpty()) {
            throw new IllegalStateException("No students in the gradebook.");
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

     //This is the main #11
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

    //This is the main #12
    public void printStudentTable() {
        System.out.println("firstname\tlastname\tPID\tscore");
        for (Student s : listOfStudents) {
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
        }
    }

    //This is the main #13 showing TWICE OF EVERYTHING AND shows null in letter grades
    public void printStudentTableWithLetterGrades() {
        System.out.println("firstname\tlastname\tPID\tletter-grades");
        for (Student s : listOfStudents) {
            System.out.printf("%s\t%s\t%d\t%c\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
        }
    }

}
