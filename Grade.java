package main;

public class Grade {
    private int score;
    private String letterGrade;
    
    public Grade (int score){
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getLetterGrade() {
        return letterGrade;
    }
    
    // Setter for letterGrade
    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
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