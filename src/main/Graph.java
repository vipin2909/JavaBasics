package main;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    /**
     * Number of vertices in the graph
     */
    private int V;
    /**
     * Array of lists for
     * Adjacency List representation
     */
    private LinkedList<Integer> adj[];

    @SuppressWarnings("uncheked")
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     *
     * @param v is the list in which we are adding w
     * @param w is the node in v list
     */
    void addEdge(int v, int w) {
        adj[v].add(w);
//        adj[w].add(v);
    }

    /**
     *
     * the graph is supposed to be disconnected
     */
    void DFSDisconnected() {
       boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                DFSUtil(i, visited);
            }
       }
    }
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.println(v+" ");
        Iterator<Integer> ite = adj[v].listIterator();
        while(ite.hasNext()) {
            int n  = ite.next();
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
    void DFS(int v) {
        // Mark all the vertices as
        // not visited ( set as
        // false by default in Java)
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    // Driver code
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is the depth first search traversal "+"(Starting from vertex 2)");
//        g.DFS(2);
        g.DFSDisconnected();
    }


}
