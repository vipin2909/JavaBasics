import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer tok;
    static int tt;
    static void solve() throws IOException {
        int n = nextInt();
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = nextInt();
        }
        Arrays.sort(arr);
        int k = 0;
        while(k < arr.length && n > 0) {
            if(n == 0) {
                out.println(n+100);
                n--;
            }
        }

    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    static String next() throws IOException {
        while(tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(br.readLine());
        }
        return tok.nextToken();
    }
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            br.close();
            out.close();
        }
        catch(Throwable e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
