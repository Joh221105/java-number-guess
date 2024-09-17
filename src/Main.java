package src;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = generateRandomNumber();
        guessingGame(scan, target);
        System.out.print("You got it! The number was: " + target);
    }

    public static int generateRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(101);
    }

    public static void guessingGame(Scanner scan, int target){
        int guess = -1;
        do{
            System.out.print("Enter a number between 0 and 100: ");
            guess = scan.nextInt();
            if(guess > target){
                System.out.println("It is too high");
            }
            else if(guess < target){
                System.out.println("It is too low");
            }
        }
        while(guess != target);
    }
}
