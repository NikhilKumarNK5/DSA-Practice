package LeetCode;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^5

Follow up:
Try to come up with as many solutions as you can.
There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/

public class RotateArray {
    // Approach 1: Brute Force, repeating the steps to move the elements k times
    // TC: O(N * K), SC => O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0 ; i < k; i++) {
            int temp = nums[n - 1];
            for(int j = n - 1; j >= 1; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    // Approach 2: Using extra array
    // TC => O(N), SC => O(N)
    public void rotateUsingExtra(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[(i + k) % n] = nums[i]; // placing the elements in the result array in the correct position
        }
        // copying the result array in the original array
        for(int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }

    // Approach 3: Using reverse of array
    // TC => O(N), SC => O(1)
    public void rotateUsingReverse(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // to handle cases where k is greater than n
        if(k == 0) {
            return; // if k is 0 then we do not need to perform the rotation
        }
        reverseArray(nums, 0, n - 1); // reverse the whole array
        reverseArray(nums, 0, k - 1); // reverse the array from start to k - 1
        reverseArray(nums, k, n - 1); // reverse the array from k to n - 1
        // finally we get the required rotated array
    }

    public int[] reverseArray(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}
