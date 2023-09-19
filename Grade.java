package main;

public class Grade {
    private int score;
    private String letterGrade;
    
    //
    public Grade (int score){
        this.score = score;
    }
    
    //This gets the score and returns it
    public int getScore() {
        return score;
    }
    
    //This if statement calculates thhe score then converts into a letter grade
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
}