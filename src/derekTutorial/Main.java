package derekTutorial;

import java.io.*;
import java.util.*;

public class Main {

    BufferedReader br;
    StringTokenizer tok;
    PrintWriter out;

    int[] dx = {1, 1, -1, -1};
    int[] dy = {1, -1, 1, -1};

    String next() throws IOException {
        while(tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(br.readLine());
        }
        return tok.nextToken();
    }
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    int getStringDifference(String a, String b) {
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            int x = a.charAt(i) - 'a';
            int y = b.charAt(i) - 'a';
            count += Math.abs(y-x);
        }
        return count;
    }
    void solve() throws IOException {
        int n = nextInt();
        int arr[] = new int[n];
        int cnt=0,temp=0,temp_max=-1;
        for(int i = 0; i < n; i++) {
            int a = nextInt();
            if(a==1) {
                cnt+=1;
                if(temp>0) temp -= 1;
            }
            else {
                temp+=1;
                if(temp>temp_max) temp_max=temp;
            }
        }
        out.println(cnt+temp_max);
    }
    public static void main(String[] args) {
        try {
            Main obj = new Main();
            obj.br = new BufferedReader(new InputStreamReader(System.in));
            obj.out = new PrintWriter(System.out);
            obj.solve();
            obj.br.close();
            obj.out.close();
        }
        catch(Throwable e) {
            e.printStackTrace();
        }
    }
}
/**
 *
 * 3 2 1
 * 5 7
 * 1 2
 * 5 100
 * 1 2 5 5 7 100
 * 4+3+2+95
 * 104 ans
 */