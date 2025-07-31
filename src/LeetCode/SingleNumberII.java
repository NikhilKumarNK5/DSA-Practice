package LeetCode;

/*
Given an integer array nums where every element appears three times except for one, which appears exactly once.
Find the single element and return it.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99

Constraints:
1 <= nums.length <= 3 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
Each element in nums appears exactly three times except for one element which appears once.
*/

import java.util.HashMap;

public class SingleNumberII {
    // Approach 1: Using Hashmap
    // Store the frequency of each element in the hashmap and check if frequency 1 then return it
    // TC => O(N)
    // SC => O(N)
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(frequency.containsKey(nums[i])) {
                frequency.put(nums[i], frequency.get(nums[i]) + 1);
            } else {
                frequency.put(nums[i], 1);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(frequency.get(nums[i]) == 1)
                return nums[i];
        }
        return - 1; // never reaches here
    }

    // Approach 2: Using Bit Manipulation
    // Each integer is made up of 32 bits (for a standard int).
    // If every number appears 3 times, then each bit position across all numbers should
    // have a count divisible by 3, except for the one number that appears once.
    // TC => O(N)
    public int singleNumberBitManipulation(int[] nums) {
        int result = 0;

        // Go through all 32 bits (assuming 32-bit integers)
        for (int i = 0; i < 32; i++) {
            int bitCount = 0;

            // Count how many numbers have the i-th bit set
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    bitCount++;
                }
            }

            // If count is not divisible by 3, this bit belongs to the single number
            if (bitCount % 3 != 0) {
                result |= (1 << i);  // Set the i-th bit in result
            }
        }

        return result;
    }

    // Approach 3: Bit Manipulation with State tracking
    // ones holds bits that have appeared once.
    // twos holds bits that have appeared twice.
    // On the third appearance, bits are cleared from both.
    // TC => O(N)
    public int singleNumberStateTracking(int[] nums) {
        int ones = 0;
        int twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones; // contains the single number
    }
}
