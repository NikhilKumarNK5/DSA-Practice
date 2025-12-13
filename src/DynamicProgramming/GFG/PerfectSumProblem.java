package DynamicProgramming.GFG;

/*
Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.

Examples:

Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10
Output: 3
Explanation: The subsets {5, 2, 3}, {2, 8}, and {10} sum up to the target 10.

Input: arr[] = [2, 5, 1, 4, 3], target = 10
Output: 3
Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} sum up to the target 10.

Input: arr[] = [5, 7, 8], target = 3
Output: 0
Explanation: There are no subsets of the array that sum up to the target 3.

Input: arr[] = [35, 2, 8, 22], target = 0
Output: 1
Explanation: The empty subset is the only subset with a sum of 0.

Constraints:
1 ≤ arr.size() ≤ 10^3
0 ≤ arr[i] ≤ 10^3
0 ≤ target ≤ 10^3
*/

public class PerfectSumProblem {

    // Approach: Similar to the Subset Sum problem but here instead of true or false we need the count of subsets
    // to count the subsets we can use an int dp[][] matrix that can store the count of subset at each possible point
    // TC => O(n * target)
    // SC => O(n * target)
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int mod = 1000000007;

        int[][] dp = new int[n + 1][target + 1];

        // initialization
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++) {
            // j begins from 0 here to cover the scenario where nums array contains zeroes and sum is 0
            for(int j = 0; j <= target; j++) {
                if(nums[i - 1] <= j)
                    dp[i][j] = (dp[i - 1][j - nums[i - 1]] + dp[i - 1][j]) % mod;
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][target];
    }
}
