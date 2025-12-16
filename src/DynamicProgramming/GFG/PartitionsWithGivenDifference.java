package DynamicProgramming.GFG;

/*
Given an array arr[] and an integer diff, count the number of ways to partition the array into two subsets such that the difference between their sums is equal to diff.
Note: A partition in the array means dividing an array into two subsets say S1 and S2 such that the union of S1 and S2 is equal to the original array and each element is present in only one of the subsets.

Examples :
Input: arr[] = [5, 2, 6, 4], diff = 3
Output: 1
Explanation: There is only one possible partition of this array. Partition : [6, 4], [5, 2]. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.

Input: arr[] = [1, 1, 1, 1], diff = 0
Output: 6
Explanation: We can choose two 1's from indices [0,1], [0,2], [0,3], [1,2], [1,3], [2,3] and put them in sum1 and remaning two 1's in sum2.
Thus there are total 6 ways for partition the array arr.

Input: arr[] = [3, 2, 7, 1], diff = 4
Output: 0
Explanation: There is no possible partition of the array that satisfy the given difference.

Constraint:
1 ≤ arr.size() ≤ 50
0 ≤ diff ≤ 50
0 ≤ arr[i] ≤ 6
*/

public class PartitionsWithGivenDifference {

    // Approach: Same as the countSubsetSum problem
    // Here we reduce the difference into sum and find the count
    // Two equations used:
    // sum1 + sum2 = totalSum
    // sum1 - sum2 = diff
    // add the two equations
    // sum1 = (totalSum + diff) / 2 -> use this in the count subsetSum problem and we get the result
    // TC => O(n * sum)
    // SC => O(n * sum)
    public int countPartitions(int[] arr, int diff) {
        int n = arr.length;
        int totalSum = 0;
        int sum1 = 0;

        for(int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        if((totalSum + diff) % 2 != 0)
            return 0;

        sum1 = (totalSum + diff) / 2;

        return countSubsetSum(arr, sum1);
    }

    private int countSubsetSum(int[] arr, int sum) {
        int n = arr.length;

        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= sum; j++) {
                if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][sum];
    }
}
