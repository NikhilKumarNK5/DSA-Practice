package Graphs.AdjacencyMatrix;

public class AdjacencyMatrix_EdgeListGiven {
    public static void main(String[] args) {
        int[][] edgeList = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 2},
                {1, 3}
        };

        int n = edgeList.length;

        // adjacency matrix
        int[][] adjMatrix = new int[n][n];

        // filling the matrix
        for(int i = 0; i < n; i++) {
            int u = edgeList[i][0];
            int v = edgeList[i][1];

            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
        }

        // print adjacency matrix
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
