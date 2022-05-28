    package derekTutorial;
    
    import java.io.*;
    import java.util.*;
    
    public class Main {
    
        class Pair {
            private int first, second;
            public Pair(int first, int second) {
                this.first = first;
                this.second = second;
    
            }
            int getFirst() {
                return this.first;
            }
            int getSecond() {
                return this.second;
            }
            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + first;
                result = prime * result + second;
                return result;
            }
            @Override
            public boolean equals(Object obj) {
                if(this == obj) {
                    return true;
                }
                if(obj == null) return false;
                if(getClass() != obj.getClass()) {
                    return false;
                }
                Pair other = (Pair) obj;
                if(first != other.first) {
                    return false;
                }
                if(second != other.second) {
                    return false;
                }
                return true;
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
    
        int getCount(int element, int arr[]) {
            int cnt = 1;
            for(int i = arr.length-1; i >= 1; i-=1) {
                if(arr[i] == arr[i-1]) {
                    cnt+=1;
                }
                else {
                    break;
                }
            }
            return cnt;
        }
        private static final int a = (int)(1e6+10);
        void solve() throws IOException {
            int n = nextInt();
            int k = nextInt();
            Pair[] arr = new Pair[n];
            for(int i = 0; i < n; i++) {
                int prob = nextInt();
                int time = nextInt();
    
                arr[i] = new Pair(prob, time);
            }
            Arrays.sort(arr, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.getFirst() == o2.getFirst()) {
                        if(o1.getSecond() < o2.getSecond()) {
                            return -1;
                        }
                        if(o1.getSecond() > o2.getSecond()) {
                            return 1;
                        }
                        return 0;
                    }
                    if(o1.getFirst() > o2.getFirst()) {
                        return -1;
                    }
                    return 1;
                }
            });
            HashMap<Pair, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++) {
                Pair newPair = new Pair(arr[i].getFirst(), arr[i].getSecond());
                map.put(newPair, map.getOrDefault(newPair, 0)+1);
            }
    //        out.println(arr[k-1].getFirst()+" "+arr[k-1].getSecond());
    //        out.println(map.get(arr[k-1]));
//            for(Map.Entry<Pair, Integer> entry: map.entrySet()) {
//                out.println(entry.getKey().getFirst()+" "+entry.getKey().getSecond()+" has value of " + entry.getValue());
//            }
//            for(int i = 0; i < n; i++) {
//                out.println(arr[i].getFirst()+" "+arr[i].getSecond()+" has value of "+map.get(arr[i]));
//            }
            out.println(map.get(arr[k-1]));
    
    
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