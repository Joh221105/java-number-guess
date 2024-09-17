package src;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = generateRandomNumber();
    }

    public static int generateRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(101);
    }

    public static void guessingGame(int target){

    }
}
