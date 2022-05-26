package derekTutorial;

import java.io.*;
import java.util.*;

public class Main {

    class Pair {
        int index, commonDiff;
        public Pair(int first, int second) {
            this.index = first;
            this.commonDiff = second;
        }
    }
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

    private static final int  z = (int)(1e6+5);
    boolean isprime[] = new boolean[z];
    void siv(){
        isprime[1]=true;
        for(int i=2;i*i<=z;i++){
            if(!isprime[i]){
                for(int j=i+i;j<=z;j+=i){
                    if(!isprime[j])isprime[j]=true;
                }
            }
        }
    }

    private static final int a = (int)(1e6+10);
    void solve() throws IOException {
//        int n = nextInt();
//        int[] arr = new int[n];
//        HashSet<Integer> set = new HashSet<Integer>();
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
//
//        for(int i = 0; i < n; i++) {
//            arr[i] = nextInt();
//           set.add(arr[i]);
//        }
//        int[] a = new int[a];
//        for(int i = 0; i < n; i++) {
//
//            if(map.containsKey(arr[i])) {
//                if(temp.get(arr[i]) == 0)
//                map.put(arr[i], i-map.get(arr[i]));
//                else
//                    continue;
//            }
//            else {
//                map.put(arr[i], i);
//            }
//            temp.put(arr[i], temp.getOrDefault(arr[i], -1)+1);
//
//        }
//        ArrayList<Pair> ans = new ArrayList<>();
//        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
//            int key = entry.getKey();
//            int mapValue = entry.getValue();
//            int tempValue = temp.get(key);
//            if(tempValue==0) {
//                ans.add(new Pair(key, 0));
//            }
//            else {
//                ans.add(new Pair(key, mapValue));
//            }
//        }

//        out.println(set.size());
//        for(int i = 0; i < ans.size(); i++) {
//            out.println(ans.get(i).first + " " + ans.get(i).second);
//        }

        int n = nextInt();
        int arr[] = new int[n];
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Pair> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            arr[i] = nextInt();
            set.add(arr[i]);
        }
        HashMap<Integer, Integer> temp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                int diff = map.get(arr[i]).commonDiff;
                if(diff == 0) {
                    int newDiff = i - map.get(arr[i]).index;
                    map.put(arr[i], new Pair(i, newDiff));
//                    temp.put(arr[i], newDiff);
                }
                else {
                    int newDiff = i - map.get(arr[i]).index;
                    if(newDiff == map.get(arr[i]).commonDiff) {
                        map.put(arr[i], new Pair(i, newDiff));
                    }
                    else {
                        map.remove(arr[i]);
                        set.remove(arr[i]);
                    }
                }
            }
            else {
                map.put(arr[i], new Pair(i, 0));
            }
        }
        out.println(set.size());

        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);
         Iterator<Integer> itr = list.listIterator();
        while(itr.hasNext()) {
            int x = itr.next();
            out.println(x+" "+map.get(x).commonDiff);
        }
        //        for(Map.Entry<Integer, Pair> entry: map.entrySet()) {
//            out.println(entry.getKey()+" "+entry.getValue().commonDiff);
//        }



    }
//    void solve() throws IOException {
//       int n = nextInt();
//       int[] arr = new int[n];
//
//
//       HashMap<Integer, Integer> map = new HashMap<>();
//       HashSet<Integer> set = new HashSet<>();
//        for(int i = 0; i < n; i++) {
//           arr[i] = nextInt();
//           set.add(arr[i]);
//           map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
//       }
//        ArrayList<Pair> ans = new ArrayList<>();
//
//        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
//            ans.add(new Pair(entry.getKey(), n/entry.getValue() == n ? 0 : n / entry.getValue()));
//        }
//        out.println(set.size());
//        for(int i = 0; i < ans.size(); i++) {
//            out.println(ans.get(i).first + " " + ans.get(i).second);
//        }
//
//    }
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