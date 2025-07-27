package LeetCode;

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Example 1:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Example 2:
Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matrix[i][j] <= 10^9
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-10^9 <= target <= 10^9
*/

public class SearchInA2DMatrix {

    // Approach: Binary Search Modified / Staircase method
    // TC => O(N + M), SC => O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        // checks if the target is less than the smallest or greater than the largest
        if(target < matrix[0][0] || target > matrix[n - 1][m - 1])
            return false;

        int row = 0;
        int col = m - 1;

        while(row < n && col >= 0) {
            if(matrix[row][col] == target)
                return true;
            else if(matrix[row][col] < target)
                row++;
            else
                col--;
        }

        return false;
    }
}
