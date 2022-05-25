    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.PrintWriter;
    import java.math.BigInteger;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.PriorityQueue;
    import java.util.StringTokenizer;

    public class TestA {

        static BufferedReader br;
        static StringTokenizer tok;
        static PrintWriter out;
        static int testCases;

        public static void solve() throws IOException {

           int n = nextInt();
           int arr[] = new int[n];
           for(int i = 0; i < n; i++) {
               arr[i] = nextInt();
           }
           int count100 = 0, count200 = 0, sum = 0;
           for(int i = 0; i < n; i++) {
               if(arr[i] == 100) count100++;
               else count200++;
               sum+=arr[i];
           }
           if(sum%3!=0) {
               out.println("NO");
           }
           else {
               if(count100%2!=0) {
                   out.println("NO");
               }
               else if(count100 == 0 && count200%2!=0) {
                   out.println("NO");
               }

           }
        }

        public static String next() throws IOException {
            while(tok == null || !tok.hasMoreTokens()) {
                tok = new StringTokenizer(br.readLine());
            }
            return tok.nextToken();
        }
        public static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public static long gcd(long a, long b) throws IOException {
            BigInteger b1 = BigInteger.valueOf(a);
            BigInteger b2 = BigInteger.valueOf(b);
            BigInteger gcd = b1.gcd(b2);
            return gcd.longValue();
        }

        public static boolean isPowerOfTwo(int x) throws IOException {
            return x != 0 && ((x & (x-1)) == 0);
        }

        public static void main(String[] args) {
            try{
                br = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
    //            testCases = nextInt();
                solve();

                long start = System.currentTimeMillis();
                long end = System.currentTimeMillis();
                long elapsedTime = end-start;
                float ans = (elapsedTime/1000);
    //            out.println(ans+" time in milliseconds");
                br.close();
                out.close();
            }
            catch(Throwable e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

    }
