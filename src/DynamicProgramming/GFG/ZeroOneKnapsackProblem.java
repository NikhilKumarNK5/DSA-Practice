package DynamicProgramming.GFG;

/*
Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively, and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).
The task is to put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.
Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.

Examples :
Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.

Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6]
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).

Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3]
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.

Constraints:
1 ≤ val.size() = wt.size() ≤ 10^3
1 ≤ W ≤ 10^3
1 ≤ val[i] ≤ 10^3
1 ≤ wt[i] ≤ 10^3
*/

import java.util.Arrays;

public class ZeroOneKnapsackProblem {

    // Recursive Solution
    // TLE
    // TC => O(2^N)
    // SC => O(N)
    public static int knapsack1(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int res = maxProfit1(W, val, wt, n);
        return res;
    }

    private static int maxProfit1(int W, int[] val, int[] wt, int n) {
        if(n == 0 || W == 0)
            return 0;

        if(wt[n - 1] <= W) {
            return Math.max(val[n - 1] + maxProfit1(W - wt[n - 1], val, wt, n - 1), maxProfit1(W, val, wt, n - 1));
        }
        return maxProfit1(W, val, wt, n - 1);
    }


    // Memoization
    // TC => O(n * W)
    static int knapsack2(int W, int val[], int wt[]) {
        // code here
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        // fill the matrix with invalid value (-1)
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int res = maxProfit2(W, val, wt, n, dp);
        return res;
    }

    private static int maxProfit2(int W, int[] val, int[] wt, int n, int[][] dp) {
        if(n == 0 || W == 0)
            return 0;

        if(dp[n][W] != -1)
            return dp[n][W];

        if(wt[n - 1] <= W) {
            return dp[n][W] =  Math.max(val[n - 1] + maxProfit2(W - wt[n - 1], val, wt, n - 1, dp), maxProfit2(W, val, wt, n - 1, dp));
        }
        return dp[n][W] = maxProfit2(W, val, wt, n - 1, dp);
    }

    // Top Down Approach
    // TC => O(n * W)
    // SC => O(n * W)
    static int knapsack3(int W, int val[], int wt[]) {
        int n = wt.length;

        int[][] dp = new int[n + 1][W + 1];

        // base condition -> initialization => no need to perform this step here as in array when created all values are already 0
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= W; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= W; j++) {
                if(wt[i - 1] <= j)
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][W];
    }

}
