package LeetCode;

/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements
appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:
Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.

Example 2:
Input: nums = [-1,0]
Output: [-1,0]

Example 3:
Input: nums = [0,1]
Output: [1,0]

Constraints:
2 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
Each integer in nums will appear twice, only two integers will appear once.
*/

import java.util.Arrays;
import java.util.HashSet;

public class SingleNumberIII {
    // Approach 1: Brute force - using sorting
    // TC => O(NLogN)
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);

        int[] result = new int[2];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // If it's the last element or it doesn't match the next one
            if ((i == nums.length - 1) || (nums[i] != nums[i + 1])) {
                result[index++] = nums[i];
            } else {
                i++; // skip the next duplicate
            }

            if (index == 2) break;
        }

        return result;
    }

    // Approach 2: Using HashSet
    // TC => O(N)
    // SC => O(N)
    public int[] singleNumberHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int ele: nums) {
            if(set.contains(ele))
                set.remove(ele); // if the value is present then remove (twice then remove)
            else
                set.add(ele); // if not present than add
        }

        int[] res = new int[2];
        int index = 0;
        for(int val: set) {
            res[index++] = val; // adding the two unique values from set to the result array
        }

        return res;
    }

    // Approach 3: Using Bitwise Operators
    // TC => O(N)
    public int[] singleNumberUsingBitwiseOperator(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i]; // xor of all the elements gives the xor of two unique elements
        }

        int j = 0;
        while(j < 32) {
            if(checkBit(xor, j)) {
                break;
            }
            j++;
        }

        int[] res = new int[2];
        int res1 = 0;
        int res2 = 0;
        for(int k = 0; k < nums.length; k++) {
            if(checkBit(nums[k], j))
                res1 = res1 ^ nums[k]; // xor of elements whose bit is set
            else
                res2 = res2 ^ nums[k]; // xor of the elements whose bit is unset
        }

        // since the output can be in any order
        res[0] = res1;
        res[1] = res2;

        return res;
    }
    // checks if the Bit is set of unset
    static boolean checkBit(int n, int i) {
        if((n & (1 << i)) == 0)
            return false;
        return true;
    }
}
