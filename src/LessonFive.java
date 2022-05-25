import java.util.Scanner;
public class LessonFive {
    static double myPi = 3.14159; // class variable
    static int a = 10;
    static int randomNumber;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        addThem(1, 2);
//        System.out.println("Global " + myPi);
        System.out.println("Global a before inside main "+a);
        int b = randomChecking(6);
        int q = increaseValue(20);
        System.out.println("Global a after inside main " + a );
        System.out.println(getRandomNum());
        int guessResult = 1;
        int randomGuess = 0;
        while(guessResult != -1) {
            System.out.println("Guess a number between 0 and 50");
            randomGuess = sc.nextInt();
            guessResult = checkGuess(randomGuess);
        }

    }
    public static int addThem(int a, int b) {
        double smallPi = 3.140; // local variable
        myPi = myPi + 3.0;
        System.out.println("local " + myPi);
        return 1;
    }
    public static int randomChecking(int a) {
        System.out.println("The local value of a is "+ a);
        a = a+1;
        System.out.println("The local variable value of a is " + a);
        return a;
    }
    public static int increaseValue(int p) {
        a = p+a;
        return a;
    }
    public static int getRandomNum() {
        randomNumber = (int)(Math.random()*51);
        return randomNumber;
    }
    public static int checkGuess(int guess) {
        if(guess == randomNumber) {
            return -1;
        }
        return 1;
    }

}
