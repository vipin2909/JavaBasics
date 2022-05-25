package derekTutorial;

import java.util.Scanner;

public class LessonFive {
    static double myPi = 3.14159; // class variable
     static int randomNumber;

     static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        int d = 5;
//        tryToChange(d);
//        System.out.println("This is d = "+d);
//
        System.out.println(getRandomNumber());
        int guessResult = 1;
        int randomGuess = 0;
        while(guessResult != -1) {
            System.out.println("Guess a number between 0 and 50");
            randomGuess = sc.nextInt();
            guessResult = checkGuess(randomGuess);
        }
        System.out.println("Guessed right random number");
    }

    static int getRandomNumber() {
        randomNumber = (int) (Math.random() * 51);
        return randomNumber;
    }
    public static int checkGuess(int guess) {
        if(guess == randomNumber) {
            System.out.println("You Guessed the right random number");
            return -1;
        }
        else {
            return guess;
        }
    }

    public static void tryToChange(int d) {
        d = d+1;
        System.out.println("tryToChange d " + d);
    }
    public static int addThem(int a, int b) {
        int c = a+b;
        return c;
    }
}
