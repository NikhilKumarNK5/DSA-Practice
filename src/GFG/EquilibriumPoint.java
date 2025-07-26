package GFG;/*
Given an array of integers arr[], the task is to find the first equilibrium point in the array.
The equilibrium point in an array is an index (0-based indexing)
such that the sum of all elements before that index is the same as the sum of elements after it.
Return -1 if no such point exists.

Examples:
Input: arr[] = [1, 2, 0, 3]
Output: 2
Explanation: The sum of left of index 2 is 1 + 2 = 3 and sum on right of index 2 is 3.

Input: arr[] = [1, 1, 1, 1]
Output: -1
Explanation: There is no equilibrium index in the array.

Input: arr[] = [-7, 1, 5, 2, -4, 3, 0]
Output: 3
Explanation: The sum of left of index 3 is -7 + 1 + 5 = -1 and sum on right of index 3 is -4 + 3 + 0 = -1.

Constraints:
3 <= arr.size() <= 10^5
-10^4 <= arr[i] <= 10^4
*/

public class EquilibriumPoint {

    // Approach: Find totalSum and leftSum and rightSum and compare leftSum and rightSum and if equal then return the equilibrium index
    // TC => O(N)
    public static int findEquilibrium(int arr[]) {
        int totalSum = 0;
        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];

            if (rightSum == leftSum)
                return i;

            leftSum += arr[i];
        }
        return -1;
    }
}
