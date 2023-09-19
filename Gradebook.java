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

public char calculateMinLetterGrade() {
        if (listOfStudents.isEmpty()) {
            throw new IllegalStateException("No students in the gradebook.");
        }

        char minLetterGrade = listOfStudents.get(0).getGrade().getLetterGrade();
        for (Student s : listOfStudents) {
            char letterGrade = s.getGrade().getLetterGrade();
            if (letterGrade < minLetterGrade) {
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
}
