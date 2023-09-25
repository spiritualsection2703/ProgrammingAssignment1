package main;

public class Grade {
    private int score;
    private String letterGrade;
    
    // Setters and getters for grade, letters, and scores
    public Grade (int score){
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getLetterGrade() {
        return letterGrade;
    }
    
    
    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }
}