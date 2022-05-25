import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LessonSix {

    // Arithemetic exception
    // ClassNotFoundException
    // IllegalArgumentException
    // IndexOutOfBoundsException
    // InputMismatchException
    // IOException
     static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        divideByZero(2);
//        System.out.print("How old are you? ");
//        int age = checkValidAge();
//        if(age != 0) {
//            System.out.println("You are " + age + " years old");
//        }
//        getAFile("./someStuff.txt");
        try {
            getAFileThrowsException("./someStuff.txt");
        }
        catch(IOException e) {
            System.out.println("An IO Error occured !!");
        }
    }
    // e.getMessage();
    // e.toString();
    // e.printStackTrace();
    public static void divideByZero(int a) {
        try {
            System.out.println(a/0);
        }
        catch(ArithmeticException e)
        {
            System.out.println("You can't do that here !");
//            System.out.println(e.getMessage());
            System.out.println(e.toString());
//            System.out.println(e.printStackTrace());
            e.printStackTrace();
        }
    }
    public static int checkValidAge() {
        try
        {
            return sc.nextInt();
        }
        catch(InputMismatchException e) {
            sc.next();
            System.out.println("That is a whole number");
            return 0;
        }
    }
    public static void getAFile(String fileName) {
        try
        {
            FileInputStream file = new FileInputStream(fileName);

        }
        catch(FileNotFoundException e) {
            System.out.println("Sorry can't find that file");
        }
        catch(IOException e) {
            System.out.println("Unknown IOError");
        }
//       catch(ClassNotFoundException | IOException e) {
//           System.out.println("This class is not present !!");
//       }
        catch(Exception e) {
            System.out.println("Some error occured !");
        }
        finally {
            System.out.println("This is run no matter what...");
        }
    }
    public static void getAFileThrowsException(String fileName) throws IOException, FileNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
    }

}
