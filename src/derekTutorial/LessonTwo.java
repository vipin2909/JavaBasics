package derekTutorial;

import java.util.Scanner;

public class LessonTwo {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Your favorite number: ");

        if(userInput.hasNext()) {
            int numberEntered = userInput.nextInt();
            System.out.println("Ypu Entered " + numberEntered);
            int numberEnteredTimes2 = numberEntered + numberEntered;
            System.out.println(numberEntered + " + " + numberEntered + " = " + numberEnteredTimes2);

            int numberEnteredTimesSelf = numberEntered * numberEntered;
            System.out.println(numberEntered + " * " + numberEntered + " = " + numberEnteredTimesSelf);

            int numberEnteredMinus2 = numberEntered - 2;
            System.out.println(numberEntered + " - 2 = " + numberEnteredMinus2);

            int numberEnteredDivide2 = numberEntered / 2;
            System.out.println(numberEntered + " / 2 = " + numberEnteredDivide2);

            numberEntered += 2;
            numberEntered -= 2;

            numberEntered--; // post-decrement
            numberEntered++; // post-increment
            ++numberEntered; // pre-increment
            --numberEntered; // pre-decrement

            int numberABS = Math.abs(numberEntered);
            int whichIsBigger = Math.max(5, 7); // 7
            int whichIsSmaller = Math.min(5, 7); // 5

            double numSqrt = Math.sqrt(5.23); //
            System.out.println(numSqrt);

            int numCeiling = (int)Math.ceil(5.23); // 6
            int numFloor = (int)Math.floor(5.23); // 5
            int numRound = (int) Math.round(5.23); // 5

            int randomNumber = (int) (Math.random() * 11);
            System.out.println("Random Number " + randomNumber);

        }

        else {
            System.out.println("Enter an integer next time");
        }
    }
}
