import java.util.Objects;

public class Recursion {

    public int reverseDigits(int num) {
        int rev_num = 0;
        while(num > 0) {
            rev_num = rev_num*10+num%10;
            num/=10;
        }
        return rev_num;
    }
    public static void main(String[] args) {
       int n = 1122334455;
       int curr = n;
       int arr[] = new int[10];
       while(curr > 0) {
           arr[curr%10]++;
           curr /= 10;
       }
       int cnt = 0;
       for(int i = 0; i < 10; i++) {
           if((arr[i] &  1) == 1) {
               cnt++;
           }
       }
        System.out.println(cnt <= 1 ? "YES" : "NO");
        System.out.println(Object.class.getEnclosingClass());
    }
}
