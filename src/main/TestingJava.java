package main;

import java.util.HashSet;
import java.util.Set;

public class TestingJava {

    public static void findInterleaving(String curr, String X, String Y, Set<String> interLeavings){
        if(X.length() == 0 && Y.length() == 0) {
            interLeavings.add(curr);
            return;
        }
        if(X.length() > 0) {
            findInterleaving(curr+X.charAt(0), X.substring(1), Y, interLeavings);
        }
        if(Y.length() > 0) {
            findInterleaving(curr+Y.charAt(0), X, Y.substring(1), interLeavings);
        }
    }
    public static Set<String> findInterleaving(String X, String Y) {
        Set<String> interLeavings = new HashSet<>();
        if(X.length() == 0 && Y.length() == 0) {
            return interLeavings;
        }
        findInterleaving("", X, Y, interLeavings);
        return interLeavings;
    }

    /**
     * permutation function
     * @param str to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    public void permute(String str, int l, int r) {
        if(l==r){
            System.out.println(str);
        }
        // ABC
        // A->A str = ABC
        // B->B str = ABC
        // C->C str = ABC

        else{
            for(int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l+1, r);
                str=swap(str, l, i);
            }
        }
    }
    public String swap(String a, int i, int j) {
        char[] charArray =a.toCharArray();
        char temp = charArray[i];
        charArray[i] =charArray[j];
        charArray[j]=temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String X = "ABC";
        int n = X.length();
        TestingJava testing = new TestingJava();
        testing.permute(X, 0, n-1);
//        String Y = "ACB";
//
//        Set<String> interLeavings = findInterleaving(X, Y);
//        System.out.println(interLeavings);
//        int arr[] = new int[10];
//        for(int i = 0; i < 10; i++) arr[i] = i+1;
//        Set<Integer> sst = new HashSet<>(arr);
//        System.out.println(sst);

    }
}
