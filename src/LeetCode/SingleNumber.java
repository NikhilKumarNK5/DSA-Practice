package LeetCode;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Constraints:
1 <= nums.length <= 3 * 10^4
-3 * 10^4 <= nums[i] <= 3 * 10^4
Each element in the array appears twice except for one element which appears only once.
*/

import java.util.Arrays;
import java.util.HashSet;

public class SingleNumber {
    // Approach 1: Brute Force -> Sort the number and compare
    // Check pairwise
    // TC => O(NLogN)
    public int singleNumber(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Check pairwise
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];  // Found the single number
            }
        }

        // Step 3: If all pairs are fine, the last element is the single one
        return nums[nums.length - 1];
    }

    // Approach 2: Use HashSet and check if it exists in the set and if it does remove otherwise add
    // Using this approach only element will be left in the set, as array contains all numbers twice only one once and that would be the result
    // TC => O(N)
    // SC => O(N)
    public int singleNumberHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num))
                set.remove(num); // second occurrence - remove it
            else
                set.add(num); // first occurrence - add it
        }

        // only one element will be left in the set
        for(int ele: set) {
            return ele;
        }

        // for handling invalid inputs
        return -1;
    }

    // Approach 3: Using XOR Operation
    // Performing XOR of all the numbers inside array returns the single number that is present only once
    // a ^ a = 0, a ^ 0 = a
    // TC => O(N)
    public int singleNumberXOR(int[] nums) {
        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }
}
