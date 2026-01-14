package Graphs.AdjacencyList;

import java.util.ArrayList;

public class AdjacencyList_EdgeListGiven {
    public static void main(String[] args) {
        int[][] edgeList = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 2},
                {1, 3}
        };

        int n = edgeList.length;

        // adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // initialize adjacency list
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // convert edgeList to adjacency list
        for(int i = 0; i < n; i++) {
            int u = edgeList[i][0];
            int v = edgeList[i][1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // print adjacency list
        for(int i = 1; i < n; i++) {
            System.out.println(i + " -> " + adjList.get(i));
        }
    }
}
