package DynamicProgramming.GFG;

/*
Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum.

Examples:
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.

Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.

Constraints:
1 <= arr.size() <= 200
1<= arr[i] <= 200
1<= sum <= 10^4
*/

public class SubsetSumProblem {

    // Approach: Dynamic Programming - 0/1 Knapsack -> treat the arr as the wt array and follow the same approach
    // TC => O(n * sum)
    // SC => O(n * sum)
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // initialization
        for(int i = 0; i<= n; i++) {
            for(int j = 0; j <= sum; j++) {
                if(i == 0)
                    dp[i][j] = false;
                if(j == 0)
                    dp[i][j] = true;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }
}
