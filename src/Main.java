package src;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGuessingGame();
    }

    public static void playGuessingGame() {
        Scanner scan = new Scanner(System.in);
        String playAgain;
        do {
            int target = generateRandomNumber();
            guessingGame(scan, target);
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scan.next();
        } while (playAgain.equalsIgnoreCase("y"));
        scan.close();
    }

    public static int generateRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(101);
    }

    public static int getValidInput(Scanner scan) {
        int guess = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter a number between 0 and 100: ");
            if (scan.hasNextInt()) {
                guess = scan.nextInt();
                if (guess >= 0 && guess <= 100) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scan.next();
            }
        }
        return guess;
    }

    public static void guessingGame(Scanner scan, int target){
        int guess;
        int attempts = 0;
        do {
            guess = getValidInput(scan);
            attempts++;
            if (guess > target) {
                System.out.println("It is too high");
            } else if (guess < target) {
                System.out.println("It is too low");
            }
        } while (guess != target);
        System.out.println("You guessed it in " + attempts + " attempts!");
    }
}