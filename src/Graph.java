import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    // number of vertices
    private int V;
    private ArrayList<Integer> ans;
    private LinkedList<Integer> adj[];
    @SuppressWarnings("unchecked") Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }
    public void addEdge(int v, int w) {
        adj[v].add(w); // added v to w's list
    }

    public void DFSUtil(int v, boolean visited[]) {
        // Mark the current Node visited and print it
        visited[v] = true;
        System.out.print(v+" ");
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()) {
            int n = i.next();
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
    void dfs(int v, boolean visited[], ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        ans.add(v);
        Iterator<Integer> itr =  adj.get(v).listIterator();
        while(itr.hasNext()) {
            int n = itr.next();
            if(!visited[n]) {
                dfs(n, visited, adj);
            }
        }
    }

    public static void main(String[] args) {
      Graph g = new Graph(4);
      g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.DFS(2);
    }
}
