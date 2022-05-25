package main;

import java.util.ArrayList;
import java.util.Scanner;

public class DiffArrays {
    private static ArrayList<String> ans = new ArrayList<>();
    public static void main(String[] args) {

        DiffArrays objs = new DiffArrays();
//        objs.towerOfHanoi(3,'A', 'C', 'B');
        objs.subStrings("abc", "");
        System.out.println(ans);
    }
    public void towerOfHanoi(int total, char a, char c, char b) {
        if(total == 0) return;
        towerOfHanoi(total-1, a, b, c);
        System.out.println("move rod "+total+" from "+a+" to "+c);
        towerOfHanoi(total-1, b, c, a);
    }
    public void subStrings(String a, String s) {
        if(a.length() == 0) {
            ans.add(s);
            return;
        }
        subStrings(a.substring(1), s+a.charAt(0));
        subStrings(a.substring(1), s);


    }
}
