package DynamicProgramming.GFG;

/*
Given a set of items, each with a weight and a value, represented by the array wt[] and val[] respectively. Also, a knapsack with a weight limit capacity.
Your task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
Note: Each item can be taken any number of times.

Examples:
Input: val[] = [1, 1], wt[] = [2, 1], capacity = 3
Output: 3
Explanation: The optimal choice is to pick the 2nd element 3 times.

Input: val[] = [10, 40, 50, 70], wt[] = [1, 3, 4, 5], capacity = 8
Output: 110
Explanation: The optimal choice is to pick the 2nd element and the 4th element.

Input: val[] = [6, 8, 7, 100], wt[] = [2, 3, 4, 5], capacity = 1
Output: 0
Explanation: We can't pick any element. Hence, total profit is 0.

Constraints:
1 ≤ val.size() = wt.size() ≤ 1000
1 ≤ capacity ≤ 1000
1 ≤ val[i], wt[i] ≤ 100
*/

public class KnapsackWithDuplicateItem {
    // Approach: this is an unbounded knapsack problem - the problem is similar to 0/1 knapsack but here we can pick an item again even after picking it up once before
    // A slight change in the 0/1 knapsack problem can give the solution to this problem
    // TC => O(n * capacity)
    // SC => O(n * capacity)
    public int knapSack(int val[], int wt[], int capacity) {
        int n = wt.length;

        int[][] dp = new int[n + 1][capacity + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= capacity; j++) {
                if(wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][capacity];
    }
}
