package derekTutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinaryIndexedTree<T> {
    int n;
    int[] binaryArray;
    // E - Element (used extensively by the java Collections Framework)
    // K - Key
    // N - Number
    // T - TYpe
    // V - Value
    // S, U, V etc. - 2nd, 3rd, 4th types

    public BinaryIndexedTree(int n) {
        this.n = n;
        this.binaryArray = new int[n+10];
    }
    public BinaryIndexedTree() {
    }

    int getSum(int index) {
         int sum = 0;
         index = index + 1;
         while(index > 0) {
             sum += binaryArray[index];
             index -= index & (-index);
         }
         return sum;
     }

    public void updateBit(int n, int index, int value) {
        index = index + 1;
        while(index <= n) {
            binaryArray[index] += value;
            index += index & (-index);
        }
    }

    void constructBinaryTree(int[] arr, int n) {
        for(int i = 0; i <= n; i++)
            binaryArray[i] = 0;

        for(int i = 0; i < n; i++) {
            updateBit(n, i, arr[i]);
        }
    }

    public static void main(String[] args) {
        int freq[] = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        int n  = freq.length;
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        tree.constructBinaryTree(freq, n);
        System.out.println("Sum of elements in array[0...5] is " + tree.getSum(5));
        freq[3] += 6;
        tree.updateBit(n, 3, 6);
        System.out.println("sum of elemets in arr[0...5] range is " + tree.getSum(5));





    }
}

























































//
//package derekTutorial;
//
//        import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.io.PrintWriter;
//        import java.util.*;
//
//public class Main {
//    class BinaryIndexedTree<T> {
//        int n;
//        int[] binaryArray;
//        BinaryIndexedTree(int n) {
//            this.n = n;
//            this.binaryArray = new int[n+10];
//            Arrays.fill(binaryArray, 0);
//        }
//        int getSum(int index) {
//            int sum = 0;
////               index = index + 1;
//            while(index > 0) {
//                sum += binaryArray[index];
//                index -= index & (-index);
//            }
//            return sum;
//        }
//        int getRangeSum(int l, int r) {
//            return getSum(r) - getSum(l);
//        }
//        void add(int index, int value) {
//            index += 1;
//            while(index <= n) {
//                binaryArray[index] += value;
//                index += index & (-index);
//            }
//        }
//    }
//    //     class BinaryIndexedTree {
////         int n;
////         ArrayList<Integer> bi;
////
////         int getSum(int index) {
////             int sum = 0;
////             // index in binary tree is more than as comapre to array
////             index = index+1;
////             while(index > 0) {
////                 sum += bi.get(index);
////                 index -= index & (-index);
////             }
////             return sum;
////         }
////         void updateBIT(int n, int index, int val) {
////             index = index+1;
////             while(index<=n) {
////                 bi.set(index, bi.get(index)+val);
////                 index += index & (-index);
////             }
////         }
////         void constructBITTree(ArrayList<Integer> arr, int n) {
////             for(int i = 0; i <= n; i++) {
////                 bi.set(i, 0);
////             }
////             for(int i = 0; i < n; i++) {
////                 updateBIT(n, i, arr.get(n));
////             }
////         }
////         int sum(int L, int R) {
////             return getSum(R) - getSum(L);
////         }
////     }
////
////    class BinaryIndexedTree {
////        int n;
////        ArrayList<Integer> bit;
////        BinaryIndexedTree(int n) {
////            this.n = n;
////            this.bit = new ArrayList<>(n+1);
////            Collections.fill(bit, 0);
////        }
////        void add(int i, int x) {
////            i++;
////            while(i <= n) {
////                bit.set(i, bit.get(i)+x);
////                i += (i & -i);
////            }
////        }
////        int sum(int i) {
////            int ans = 0;
////            while(i > 0) {
////                ans += bit.get(i);
////                i -= (i & -i);
////            }
////            return ans;
////        }
////        int sum(int L, int R) {
////            return sum(R) - sum(L);
////        }
////    }
//    BufferedReader br;
//    StringTokenizer tok;
//    PrintWriter out;
//
//    int[] dx = {1, 1, -1, -1};
//    int[] dy = {1, -1, 1, -1};
//
//    String next() throws IOException {
//        while(tok == null || !tok.hasMoreTokens()) {
//            tok = new StringTokenizer(br.readLine());
//        }
//        return tok.nextToken();
//    }
//    int nextInt() throws IOException {
//        return Integer.parseInt(next());
//    }
//    long nextLong() throws IOException {
//        return Long.parseLong(next());
//    }
//    int getStringDifference(String a, String b) {
//        int count = 0;
//        for(int i = 0; i < a.length(); i++) {
//            int x = a.charAt(i) - 'a';
//            int y = b.charAt(i) - 'a';
//            count += Math.abs(y-x);
//        }
//        return count;
//    }
//    void solve() throws IOException {
//        String str = next();
//
//        int count = 0;
//        ArrayList<Integer> arr = new ArrayList<>();
//        int k = str.length()-1;
//        while(k > 0) {
//            int x = (int)str.charAt(k);
//            int temp = x%10;
//            arr.add(temp);
//            k -= 1;
//        }
//        StringBuilder sb = new StringBuilder();
//        int index = 0;
//        for(int i = arr.size()-1; i >= 0; i-=1) {
//            if(arr.get(i) == 0) {
//                index = i;
//                break;
//            }
//        }
//        for(int i = arr.size()-1; i >= 0; i-=1) {
//            if(i == index) {
//                continue;
//            }
//            else {
//                sb.append(arr.get(i));
//            }
//        }
//        out.println(sb.toString());
//    }
//    public static void main(String[] args) {
//        try {
//            Main obj = new Main();
//            obj.br = new BufferedReader(new InputStreamReader(System.in));
//            obj.out = new PrintWriter(System.out);
//            obj.solve();
//            obj.br.close();
//            obj.out.close();
//        }
//        catch(Throwable e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
//
//
//
//
//
////import java.io.BufferedReader;
////        import java.io.IOException;
////        import java.io.InputStreamReader;
////        import java.io.PrintWriter;
////        import java.util.*;
//
//
////public class CodeForces {
////    static FastScanner fs = new FastScanner();
////    static PrintWriter out=new PrintWriter(System.out);
////    static  int[] a;
////    static long[] t;
////    static int n;
////    public static void solve(){
////        n = a.length;
////        t = new long[n + 2];
////        long res = 0;
////        for (int i = 0; i < a.length; i++) {
////            res += sum(n) - sum(a[i] - 1);
////            add(a[i]);
////        }
////        out.println(res);
////    }
////
////    static void add(int x) {
////        //因为树状数组t中，储存的为下标，所以最大下标+1应该为n
////        for (; x <= n; x += x & (-x)) t[x]++;
////    }
////
////    static int sum(int x) {
////        int sum = 0;
////        for (; x > 0; x -= x & (-x)) sum += t[x];
////        return sum;
////    }
////
////    public static void main(String[] args) {
////        int testCases = fs.nextInt();
////        for(int t = 0; t < testCases; ++t) {
////            a = fs.readArray(fs.nextInt());
////            solve();
////        }
////        out.close();
////    }
////
////
////    static final Random random=new Random();
////    static final int mod=1_000_000_007;
////
////    static void ruffleSort(int[] a) {
////        int n=a.length;//shuffle, then sort
////        for (int i=0; i<n; i++) {
////            int oi=random.nextInt(n), temp=a[oi];
////            a[oi]=a[i]; a[i]=temp;
////        }
////        Arrays.sort(a);
////    }
////    static long add(long a, long b) {
////        return (a+b)%mod;
////    }
////    static long sub(long a, long b) {
////        return ((a-b)%mod+mod)%mod;
////    }
////    static long mul(long a, long b) {
////        return (a*b)%mod;
////    }
////    static long exp(long base, long exp) {
////        if (exp==0) return 1;
////        long half=exp(base, exp/2);
////        if (exp%2==0) return mul(half, half);
////        return mul(half, mul(half, base));
////    }
////
////    static void sort(int[] a) {
////        ArrayList<Integer> l=new ArrayList<>();
////        for (int i:a) l.add(i);
////        Collections.sort(l);
////        for (int i=0; i<a.length; i++) a[i]=l.get(i);
////    }
////
////
////    static class FastScanner {
////        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
////        StringTokenizer st=new StringTokenizer("");
////        String next() {
////            while (!st.hasMoreTokens())
////                try {
////                    st=new StringTokenizer(br.readLine());
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            return st.nextToken();
////        }
////
////        int nextInt() {
////            return Integer.parseInt(next());
////        }
////        int[] readArray(int n) {
////            int[] a = new int[n];
////            for (int i=0; i<n; i++) a[i] = nextInt();
////            return a;
////        }
////        long nextLong() {
////            return Long.parseLong(next());
////        }
////    }
////}
////
//
//
//
//
//
//
//
//
////import java.io.BufferedReader;
////        import java.io.IOException;
////        import java.io.InputStreamReader;
////        import java.io.PrintWriter;
////        import java.util.*;
//
//
////public class CodeForces {
////    static FastScanner fs = new FastScanner();
////    static PrintWriter out=new PrintWriter(System.out);
////    static  int[] a;
////    static long[] t;
////    static int n;
////    public static void solve(){
////        n = a.length;
////        t = new long[n + 2];
////        long res = 0;
////        for (int i = 0; i < a.length; i++) {
////            res += sum(n) - sum(a[i] - 1);
////            add(a[i]);
////        }
////        out.println(res);
////    }
////
////    static void add(int x) {
////        //因为树状数组t中，储存的为下标，所以最大下标+1应该为n
////        for (; x <= n; x += x & (-x)) t[x]++;
////    }
////
////    static int sum(int x) {
////        int sum = 0;
////        for (; x > 0; x -= x & (-x)) sum += t[x];
////        return sum;
////    }
////
////    public static void main(String[] args) {
////        int testCases = fs.nextInt();
////        for(int t = 0; t < testCases; ++t) {
////            a = fs.readArray(fs.nextInt());
////            solve();
////        }
////        out.close();
////    }
////
////
////    static final Random random=new Random();
////    static final int mod=1_000_000_007;
////
////    static void ruffleSort(int[] a) {
////        int n=a.length;//shuffle, then sort
////        for (int i=0; i<n; i++) {
////            int oi=random.nextInt(n), temp=a[oi];
////            a[oi]=a[i]; a[i]=temp;
////        }
////        Arrays.sort(a);
////    }
////    static long add(long a, long b) {
////        return (a+b)%mod;
////    }
////    static long sub(long a, long b) {
////        return ((a-b)%mod+mod)%mod;
////    }
////    static long mul(long a, long b) {
////        return (a*b)%mod;
////    }
////    static long exp(long base, long exp) {
////        if (exp==0) return 1;
////        long half=exp(base, exp/2);
////        if (exp%2==0) return mul(half, half);
////        return mul(half, mul(half, base));
////    }
////
////    static void sort(int[] a) {
////        ArrayList<Integer> l=new ArrayList<>();
////        for (int i:a) l.add(i);
////        Collections.sort(l);
////        for (int i=0; i<a.length; i++) a[i]=l.get(i);
////    }
////
////
////    static class FastScanner {
////        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
////        StringTokenizer st=new StringTokenizer("");
////        String next() {
////            while (!st.hasMoreTokens())
////                try {
////                    st=new StringTokenizer(br.readLine());
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
////            return st.nextToken();
////        }
////
////        int nextInt() {
////            return Integer.parseInt(next());
////        }
////        int[] readArray(int n) {
////            int[] a = new int[n];
////            for (int i=0; i<n; i++) a[i] = nextInt();
////            return a;
////        }
////        long nextLong() {
////            return Long.parseLong(next());
////        }
////    }
////}