package main;
import java.io.*;
import java.util.*;

public class CycleDetectionUsingDFS {
    // No. of vertices
    private int V;

    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    CycleDetectionUsingDFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // function to add edge into graph

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    Boolean isCycleUtil(int v, Boolean visited[], int parent) {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices
        // adjacent to this vertex
        Iterator<Integer> it = adj[v].listIterator();
        while(it.hasNext()) {
            int n = it.next();

            // If an adjacent is not
            // visited, then recur for that
            // adjacent

            if(!visited[n]) {
                if(isCycleUtil(n, visited, v)) {
                    return true;
                }
            }
            // If an adjacent is visited
            // and not parent of current
            // vertext, then there is a cycle
            else if(n != parent) {
                return true;
            }
        }
        return false;


    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }



}
