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
    
    public int calculateMinScore() {
        if (listOfStudents.isEmpty()) {
            throw new IllegalStateException("Please add students in the gradebook.");
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

    public double calculateAvg() {
        double sum = 0;
        for (Student s : listOfStudents)
            sum += s.getGrade().getScore();
        return sum / listOfStudents.size();
    }

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

    public String calculateMinLetterGrade() {
    if (listOfStudents.isEmpty()) {
        throw new IllegalStateException("No students in the gradebook.");
    }

    String minLetterGrade = listOfStudents.get(0).getGrade().getLetterGrade();
    for (Student s : listOfStudents) {
        String letterGrade = s.getGrade().getLetterGrade();
        if (letterGrade.compareTo(minLetterGrade) < 0) {
            minLetterGrade = letterGrade;
        }
    }
    return minLetterGrade;
}


    public char calculateMaxLetterGrade() {
        if (listOfStudents.isEmpty()) {
            throw new IllegalStateException("No students in the gradebook.");
        }

        char maxLetterGrade = listOfStudents.get(0).getGrade().getLetterGrade();
        for (Student s : listOfStudents) {
            char letterGrade = s.getGrade().getLetterGrade();
            if (letterGrade > maxLetterGrade) {
                maxLetterGrade = letterGrade;
            }
        }
        return maxLetterGrade;
    }

    public void printAllStudents() {
        for (Student s : listOfStudents)
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }
    
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
    
    public void findAndPrintFullName(int targetPid) {
    for (Student s : listOfStudents) {
        if (s.getPid() == targetPid) {
            String fullName = s.getFirstName() + " " + s.getLastName();
            System.out.println("Full Name for PID " + targetPid + ": " + fullName);
            return; 
        }
    }
    
    System.out.println("Student with PID " + targetPid + " not found in the gradebook.");
}
    
    public void updateStudentGrade(int targetPid, char newGradeSymbol) {
    for (Student s : listOfStudents) {
        if (s.getPid() == targetPid) {
            s.getGrade().setLetterGrade(newGradeSymbol);
            System.out.println("Updated grade for PID " + targetPid + " to " + newGradeSymbol);
            return;
        }
    }
    
    System.out.println("Student with PID " + targetPid + " not found in the gradebook.");
}

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

public void printStudentTable() {
    System.out.println("firstname\tlastname\tPID\tscore");
    for (Student s : listOfStudents) {
        System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }
}

public void printStudentTableWithLetterGrades() {
    System.out.println("firstname\tlastname\tPID\tletter-grades");
    for (Student s : listOfStudents) {
        System.out.printf("%s\t%s\t%d\t%c\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
    }
}

}
