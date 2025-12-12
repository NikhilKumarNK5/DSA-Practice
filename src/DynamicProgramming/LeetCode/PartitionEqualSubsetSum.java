package DynamicProgramming.LeetCode;

/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= 100
*/

public class PartitionEqualSubsetSum {

    // Approach: Use the subsetsum problem approach
    // TC => O(n * sum)
    // SC => O(n * sum)
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int i = 0; i <= nums.length; i++)
            sum+= nums[i];

        // if the sum is odd then can't divide into 2 subsets of equal sum
        if(sum % 2 != 0)
            return false;

        // if the sum is even then check if the subset sum of sum / 2 is possible
        return isSubsetSum(nums, sum / 2);
    }

    private boolean isSubsetSum(int[] nums, int sum) {
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // initialization
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= sum; j++) {
                if(i == 0)
                    dp[i][j] = false;
                if(j == 0)
                    dp[i][j] = true;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(nums[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }
}
