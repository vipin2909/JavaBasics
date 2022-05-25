package main;
import java.util.*;
public class LongestPath {
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // maximum length of cable among the cities

    static int max_len = Integer.MIN_VALUE;

    static void DFS(Vector<Vector<Pair>> graph, int src, int prev_len, boolean visited[]) {
        // mark the current node visited

        visited[src] = true;

        // current length is for the cable
        // from src city to its adjacent city
        int curr_len = 0;
        Pair adjacent;
        for(int i = 0; i < graph.get(src).size(); i++) {
            adjacent = graph.get(src).get(i);
            if(!visited[adjacent.x]) {
                curr_len = prev_len + adjacent.y;
                DFS(graph, adjacent.x, curr_len, visited);
            }
            if(max_len < curr_len) {
                max_len = curr_len;
            }

            curr_len = 0;
        }
    }
    static int longestCable(Vector<Vector<Pair>> graph, int n) {
        for(int i = 1; i <= n; i++) {
            boolean visited[] = new boolean[n+1];
            DFS(graph, i, 0, visited);
        }
        return max_len;
    }

    public static void main(String[] args) {
        int n = 6;
        Vector<Vector<Pair>> graph = new Vector<Vector<Pair>>();
        for(int i = 0; i < n+1; i++) {
            graph.add(new Vector<Pair>());
        }

        // create an undirected graph
        // first edge

        graph.get(1).add(new Pair(2, 3));
        graph.get(2).add(new Pair(1, 3));

        // second edge
        graph.get(2).add(new Pair(3, 4));
        graph.get(3).add(new Pair(2, 4));

        // third edge
        graph.get(2).add(new Pair(6, 2));
        graph.get(6).add(new Pair(2, 2));

        // fourth edge
        graph.get(4).add(new Pair(6, 6));
        graph.get(6).add(new Pair(4, 6));

        // fifth edge
        graph.get(5).add(new Pair(6, 5));
        graph.get(6).add(new Pair(5, 5));

        System.out.println("Maximum length of cable = "+ longestCable(graph, n));
    }
}
