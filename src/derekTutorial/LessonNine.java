package derekTutorial;

import java.util.Arrays;

public class LessonNine {
    public static void main(String[] args) {
        int[] randomArray;
        int[] numberArray = new int[10];
        randomArray = new int[20];
        randomArray[0] = 500;

        String[] stringArray = {"just", "random", "words"};

        for(int i = 0; i < numberArray.length; i++) {
            numberArray[i] = i;
        }

        int k = 1;
        while(k <= 41) {
            System.out.print('-');
            k++;
        }
        System.out.println();
        for(int j = 0; j < numberArray.length; j++) {
            System.out.print("| " + j + " ");
        }
        System.out.println();

        String[][] multiArray = new String[10][10];

        for(int row = 0; row < multiArray.length; row += 1) {
            for(int col = 0; col < multiArray[row].length; col += 1) {
                multiArray[row][col] = row + " " + col;
            }
        }
        for(String[] rows: multiArray) {
            for(String column: rows) {
                System.out.print("| "+column+" ");
            }
            System.out.println("|");
        }
        k = 1;
        while(k <= 41) {
            System.out.print('-');
            k++;
        }

        int[] numCopy = Arrays.copyOf(numberArray, 5);
        int[] numRangeCopy = Arrays.copyOfRange(numberArray, 0, 2);
        for(int row: numCopy) {
            System.out.print(row);
        }
        System.out.println("\n");
        for(int row: numRangeCopy) {
            System.out.print(row);
        }
        System.out.println("\n");

        System.out.println(Arrays.toString(numCopy));



    }
}
