package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to my grade book!");
        System.out.println("Please enter the information of the first student using the following format:");
        System.out.println("\"firstName lastName PID grade\"");
        System.out.println("Please enter 'done' when you are done.");
    
        while (true) {
            System.out.println("Please enter a new command");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("done")) {
                System.out.println("Please enter a new command.");

            }
         

        }
        


    }
}
