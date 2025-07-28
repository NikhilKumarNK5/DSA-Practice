package LeetCode;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /*
        Dry Run Example:
        Input matrix:
        [
          [1,  2,  3],
          [4,  5,  6],
          [7,  8,  9]
        ]
        Initial variables:
        n = 3, m = 3
        top = 0, bottom = 2, left = 0, right = 2
        res = []

        Step 1: Traverse top row (left → right)
          matrix[0][0] = 1 → res = [1]
          matrix[0][1] = 2 → res = [1, 2]
          matrix[0][2] = 3 → res = [1, 2, 3]
        top = 1

        Step 2: Traverse right column (top → bottom)
          matrix[1][2] = 6 → res = [1, 2, 3, 6]
          matrix[2][2] = 9 → res = [1, 2, 3, 6, 9]
        right = 1

        Step 3: Traverse bottom row (right → left)
          matrix[2][1] = 8 → res = [1, 2, 3, 6, 9, 8]
          matrix[2][0] = 7 → res = [1, 2, 3, 6, 9, 8, 7]
        bottom = 1

        Step 4: Traverse left column (bottom → top)
          matrix[1][0] = 4 → res = [1, 2, 3, 6, 9, 8, 7, 4]
        left = 1

        Step 5: Traverse top row again (left → right)
          matrix[1][1] = 5 → res = [1, 2, 3, 6, 9, 8, 7, 4, 5]
        top = 2

        Now, top > bottom and left > right → Exit loop

        Final result:
        res = [1, 2, 3, 6, 9, 8, 7, 4, 5]
    */
    // TC => O(N + M)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
