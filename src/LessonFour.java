import java.util.Scanner;
public class LessonFour {
    public static void main(String[] args) {
        int i = 1;
        while(i <= 20) {
            if(i == 3) {
//                continue;
                i+=2;
                continue;
            }
            System.out.println(i);
            i+=1;
            if((i%2) == 0) {
                i+=1;
            }
            if(i > 10) {
                break;
            }
        }
        double myPi = 4.0;
        double j = 3.0;
//        double i = 4.0;
        while(j < 11) {
            myPi = myPi - (4.0/j) + (4.0/(j+2));
            j+=4;
            System.out.println(myPi);
        }
        System.out.println("Value of Pi is: " + Math.PI);

        Scanner sc = new Scanner(System.in);
        String contYorN = "Y";
        int h = 1;
        while(contYorN.equalsIgnoreCase("y")) {
            System.out.println(h);
            contYorN = sc.nextLine();
            h++;
        }
        int k = 11;
        do {
            System.out.println(k);
            k+=1;
        }
        while(k < 10);
    }

}
