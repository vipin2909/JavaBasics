package derekTutorial;
import java.util.Scanner;


public class LessonFour {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int i = 1;
        while(i <= 20) {
            if(i == 3) {
                i += 2;
                continue;
            }
//            System.out.println(i);
            i+=1;
            if((i%2)==0) {
                i++;
            }
            if(i > 10) {
                break;
            }
        }

        double myPi = 4.0;
        double j = 3.0;

        // vlaue of Pi is 4 - 4/3 + 4/5 - 4/7...........
        while(j < 11) {
            myPi = myPi - (4/j) +  (4/(j+2));
            j+=4;
            System.out.println(myPi);
        }
        System.out.println("Value of pi " + Math.PI);

        String contOrN = "Y";
        int h  = 1;
        while(contOrN.equalsIgnoreCase("y")) {
            System.out.println(h);
            System.out.print("Continue y or n ?");
            contOrN = sc.nextLine();
            h+=1;
        }

        // main purpose of do while loop is make sure is code is executed atleat once

        int k = 100;
        do {
            System.out.println(k);
            k+=1;
        } while(k <= 10);

        // for (declare iterator; conditional statement; change iterator)

        for(int l = 10; l >= 1; l--) {
            System.out.println(l);
        }
//        System.out.println(l);
    }
}
