package LeetCode;

/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial,
could you find an O(n) solution using a different approach?
*/

import java.util.Arrays;

public class SquaresOfASortedArray {
    // Approach 1: Brute Force
    // Find the squares of each element of the array and then sort the array
    // TC => O(NLogN)
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
           nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }

    // Approach 2: Using two pointer
    // TC => O(N)
    public int[] sortedSquaresTwoPointers(int[] nums) {
        int[] res = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length - 1; // index of the resultant array

        while(start <= end) {
            int sqOfStart = nums[start] * nums[start];
            int sqOfEnd = nums[end] * nums[end];
            if(sqOfEnd > sqOfStart) {
                res[index] = sqOfEnd;
                end--;
            } else {
                res[index] = sqOfStart;
                start++;
            }
            index--;
        }
        return res;
    }
}
