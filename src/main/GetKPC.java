package main;

import java.util.*;
import java.io.*;

//import static jdk.internal.org.jline.utils.Log.debug;

public class GetKPC {
    static BufferedReader br;
    static String codes[] = new String[]{".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) throws IOException {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            ArrayList<String> words = getKPC(str);
            System.out.println(words);
            br.close();
        }
        catch(Throwable e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> getKPC(String str) {
        // 678
        if(str.length() == 0) {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
//        debug("This is str length: "+str.length());
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = getKPC(ros);
        ArrayList<String> mres = new ArrayList<>();

        for(int i = 0; i < codes[ch-48].length(); i++) {
            char chcode = codes[ch-48].charAt(i);
            for(String rstr: rres) {
                mres.add(chcode+rstr);
            }
        }
        return mres;
    }
}
