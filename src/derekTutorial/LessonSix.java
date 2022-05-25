package derekTutorial;

// checked Exceptions
// unchecked Exceptions - Error & Runtime Exception

// Arithemetic Exception
// ClassNotFoundException
// IllegalArgumentException
// IndexOutOfBoundsException
// InputMismatchException
// IOException

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class LessonSix {

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

//        System.out.println("How Old are you ? ");
//        int age = checkValidAge();
//        if(age != 0) {
//            System.out.println("You are " + age + " years old");
//        }
//         divideByZero(2);
        try {
            getAFile("./someStuff.txt");
        }
        catch(IOException e) {
            System.out.println("An IO Error occured");

        }
//        catch(FileNotFoundException e) {
//            System.out.println("File not found ");
//        }

    }

    public static void getAFile(String fileName) throws IOException, FileNotFoundException {
//        try {
            FileInputStream file = new FileInputStream(fileName);
//        }
        // first specific one and after that least specific exceptions
//        catch(FileNotFoundException e) {
//            System.out.println("Sorry can't find that file");
//        }
//
//        catch(IOException e) {
//            System.out.println("Unknown IO Error");
//        }

//        catch(Exception e) {
//            System.out.println("Some Error occured");
//        }
//
//        finally {
//            System.out.println("This is gonaa run no matter what");
//        }

    }
    public static int checkValidAge() {
        try {
            return userInput.nextInt();
        }
        catch(InputMismatchException e) {
            userInput.next();
            System.out.print("That isn't a whole number");
            return 0;
        }
    }
    public static void divideByZero(int a) {
        try {
            System.out.println(a / 0);
        }
        // There are different ways of printing error messages

        catch(ArithmeticException e) {
            System.out.println("YOu can't do that here");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
//            e.printStackTrace();
        }
    }
}
