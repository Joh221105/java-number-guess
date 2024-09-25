package src;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_LIVES = 10;

    public static void main(String[] args) {
        playGuessingGame();
    }

    public static void playGuessingGame() {
        Scanner scan = new Scanner(System.in);
        do {
            int target = generateRandomNumber();
            guessingGame(scan, target);
        } while (askToPlayAgain(scan));
        scan.close();
    }

    public static int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    public static int getValidInput(Scanner scan) {
        int guess = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ": ");
            if (scan.hasNextInt()) {
                guess = scan.nextInt();
                if (guess >= MIN_NUMBER && guess <= MAX_NUMBER) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scan.next();
            }
        }
        return guess;
    }

    public static void guessingGame(Scanner scan, int target) {
        int lives = MAX_LIVES;
        int guess;

        while (lives > 0) {
            guess = getValidInput(scan);
            lives--;

            if (guess > target) {
                System.out.println("It is too high. Lives left: " + lives);
            } else if (guess < target) {
                System.out.println("It is too low. Lives left: " + lives);
            } else {
                System.out.println("You guessed it! The number was " + target + "!");
                break;
            }

            if (lives == 0) {
                System.out.println("You've run out of lives. The number was " + target + ".");
            }
        }
    }

    public static boolean askToPlayAgain(Scanner scan) {
        System.out.print("Do you want to play again? (y/n): ");
        while (true) {
            String response = scan.next().trim().toLowerCase();
            switch (response) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.print("Invalid input. Please enter 'y' to play again or 'n' to quit: ");
            }
        }
    }
}