package GFG;
/*
You are given an array arr[] of size n - 1 that contains distinct integers in the range from 1 to n (inclusive).
This array represents a permutation of the integers from 1 to n with one element missing.
Your task is to identify and return the missing element.

Examples:
Input: arr[] = [1, 2, 3, 5]
Output: 4
Explanation: All the numbers from 1 to 5 are present except 4.

Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
Output: 6
Explanation: All the numbers from 1 to 8 are present except 6.

Input: arr[] = [1]
Output: 2
Explanation: Only 1 is present so the missing element is 2.

Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ arr.size() + 1
*/

public class MissingInArray {
    // Approach 1: Using sum of N natural numbers
    // calculate sum can lead to overflow so need to handle those carefully
    // TC => O(N)
    int missingNum(int arr[]) {
        // code here
        int n = arr.length + 1;
        long expectedSum = ((long) n * (n + 1)) / 2;
        long actualSum = 0;
        for(int i = 0; i < n - 1; i++) {
            actualSum += arr[i];
        }

        return (int)(expectedSum - actualSum);
    }

    // Approach 2: Using XOR bitwise operator
    // TC => O(N)
    int missingNumXOR(int arr[]) {
        int n = arr.length + 1;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];     // XOR with actual element
            res ^= (i + 1);     // XOR with expected number (1 to n - 1)
        }

        res ^= n; // XOR with the last number 'n'

        return res;
    }
}
