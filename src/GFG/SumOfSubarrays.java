package GFG;

/*
Given an array arr[], find the sum of all the subarrays of the given array.
Note: It is guaranteed that the total sum will fit within a 32-bit integer range.

Examples:
Input: arr[] = [1, 2, 3]
Output: 20
Explanation: All subarray sums are: [1] = 1, [2] = 2, [3] = 3, [1, 2] = 3, [2, 3] = 5, [1, 2, 3] = 6.
Thus total sum is 1 + 2 + 3 + 3 + 5 + 6 = 20.

Input: arr[] = [1, 3]
Output: 8
Explanation: All subarray sums are: [1] = 1, [3] = 3, [1, 3] = 4. Thus total sum is 1 + 3 + 4 = 8.

Constraints :
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^4
*/

public class SumOfSubarrays {
    // Approach 1: Brute force - Find all the subarrays and calculate their total sum
    // TC => O(N^3) -> TLE
    public int subarraySum(int[] arr) {
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                ans += sum;
            }
        }
        return ans;
    }

    // Approach 2: Using Carry forward technique
    // TC => O(N^2)
    public int subarraySumCarryForward(int[] arr) {
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            int sum = 0;
            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
                ans += sum;
            }
        }
        return ans;
    }

    // Approach 3: Using contribution technique
    // TC => O(N)
    public int subarraySumContribution(int[] arr) {
        int n = arr.length;
        long ans = 0;
        for(int i = 0; i < n; i++) {
            long occurrence = (i + 1) * (n - i);
            long contribution = arr[i] * occurrence;
            ans += contribution;
        }
        return (int) ans;
    }
}
