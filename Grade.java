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
}
