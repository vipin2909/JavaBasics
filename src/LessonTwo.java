import java.util.Scanner;

public class LessonTwo {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Your favorite number: ");
        if(sc.hasNextInt()) {
            // .hasNextDouble();
            // .hasNextFloat();
            int numberEntered = sc.nextInt();
            System.out.println("You entered  " + numberEntered);
        }
        else {
            System.out.println("Enter a integer next time: ");
        }
    }
}
