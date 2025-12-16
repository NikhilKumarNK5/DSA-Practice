package DynamicProgramming.GFG;

/*
Given an array arr[]  containing non-negative integers, the task is to divide it into two sets set1 and set2 such that the absolute difference between their sums is minimum and find the minimum difference.

Examples:

Input: arr[] = [1, 6, 11, 5]
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
Hence, minimum difference is 1.

Input: arr[] = [1, 4]
Output: 3
Explanation:
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {4}, sum of Subset2 = 4
Hence, minimum difference is 3.

Input: arr[] = [1]
Output: 1
Explanation:
Subset1 = {1}, sum of Subset1 = 1
Subset2 = {}, sum of Subset2 = 0
Hence, minimum difference is 1.

Constraints:
1 ≤ arr.size()*|sum of array elements| ≤ 10^5
1 <= arr[i] <= 10^5
*/

import java.util.ArrayList;
import java.util.List;

public class MinimumSumPartition {

    // Approach: Same as the Subset sum problem with using a possible sum array and that can store all the possible sums of subset less than the totalSum
    // TC => O(n * totalSums)
    // SC => O(n * totalSums)
    public int minDifference(int arr[]) {
        int n = arr.length;

        // calculate the total sum of the array
        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        boolean[][] dp = new boolean[n + 1][totalSum + 1];

        // initialization
        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= totalSum; j++) {
                if(arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        // store the indexes of the dp for cases where last row has true in them
        // store only till half the length of that row as we are considering the sum to be always less than the totalSum
        List<Integer> possibleSums = new ArrayList<>();
        for(int j = 0; j <= totalSum / 2; j++) {
            if(dp[n][j])
                possibleSums.add(j);
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < possibleSums.size(); i++) {
            min = Math.min(min, totalSum - 2 * possibleSums.get(i));
        }

        return min;
    }
}
