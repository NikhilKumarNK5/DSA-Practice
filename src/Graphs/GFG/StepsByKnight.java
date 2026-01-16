package Graphs.GFG;

/*
Given a square chessboard of size (n x n), the initial position and target postion of Knight are given. Find out the minimum steps a Knight will take to reach the target position.

Note: The initial and the target position coordinates of Knight have been given according to 1-base indexing.

Examples:
Input: n = 3, knightPos[] = [3, 3], targetPos[]= [1, 2]
Output: 1
Explanation:
Knight takes 1 step to reach from
(3, 3) to (1 ,2).

Input: n = 6, knightPos[] = [4, 5],targetPos[] = [1, 1]
Output: 3
Explanation:
Knight takes 3 step to reach from
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).

Constraints:
1 <= n<= 1000
1 <= knightpos ≤ [x, y], targertpos[x, y] ≤  n
*/

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {

    // Approach: Using BFS as BFS always gives the shortest path
    // TC => O(N^2)
    // SC => O(N^2)
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        // 1-based indexing to 0-based
        int startX = knightPos[0] - 1;
        int startY = knightPos[1] - 1;
        int targetX = targetPos[0] - 1;
        int targetY = targetPos[1] - 1;

        // if already at the target then return 0
        if(startX == targetX && startY == targetY)
                return 0;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startX, startY, 0}); // x, y, steps
        visited[startX][startY] = true;

        while(!q.isEmpty()) {
            int[] currNode = q.poll();
            int x = currNode[0];
            int y = currNode[1];
            int steps = currNode[2];

            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // check if inside the board and not visited
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    if(nx == targetX && ny == targetY) {
                        return steps + 1;
                    }
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, steps + 1});
                }
            }
        }
        // if unreachable
        return -1;
    }
}
