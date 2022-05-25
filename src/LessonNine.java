import java.util.Arrays;

public class LessonNine {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        changeArray(arr);
        for(int a: arr) {
            System.out.print(a+" ");
        }
        System.out.println();
        String[][] multiArray = new String[10][10];
        int k = 1;
        System.out.print(" ");
        while(k <= 50) {
            System.out.print("-");
            k++;
        }
        System.out.println();
        k = 1;

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                multiArray[i][j] = i+" "+j;
            }
        }
        for(String[] i: multiArray) {
            for(String j: i) {
                System.out.print(" |");
                System.out.print(j);
            }
            System.out.println("|");
        }
        System.out.print(" ");
        while(k <= 50) {
            System.out.print("-");
            k++;
        }
        System.out.println();
        int[] numCopy = Arrays.copyOf(arr, 2);
        int[] numCopyRange = Arrays.copyOfRange(arr, 1 , 4);
        System.out.println(Arrays.toString(numCopyRange));
        for(int a: numCopy) {
            System.out.print(a+" ");
        }
        int[] numToSort = new int[10];
        for(int i = 0; i < 10; i++) {
            numToSort[i] = (int)(Math.random()*100);
        }
        Arrays.sort(numToSort);
        System.out.println(Arrays.toString(numToSort));
        int whereIs50 = Arrays.binarySearch(numToSort, 50);
        System.out.println(whereIs50);
    }
    public static void changeArray(int[] arr) {
        arr[0] = 90;
    }
}
