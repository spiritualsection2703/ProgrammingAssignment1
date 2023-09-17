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
    
    //This is a "if" statement that goes through the letter grade and percentage
    public String getLetterGrade() {
       if(score >= 90){
           return "A";
       }
        else if (score >= 80){
           return "B";
       }
       else if (score >= 70){
           return "C";
       }
       else if (score >= 60){
           return "D";
       }
       else {
           return "F";
       }
    }
}
