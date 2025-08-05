package LeetCode;

/*
Given an array of integers nums containing n + 1 integers where each
integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3

Constraints:
1 <= n <= 10^5
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which
appears two or more times.

Follow up:
How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
*/

import java.util.Arrays;
import java.util.HashSet;

public class FindTheDuplicateNumber {
    // Approach 1: Brute Force
    // For each number check if any duplicate exists or not if it does then return the number
    // TC => O(N^2) -> TLE
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] == nums[j])
                    return nums[i];
            }
        }
        // never reaches here as it is specified that a number is repeated
        return -1;
    }

    // Approach 2: Using Sorting
    // It is stated that we are not to modify the array
    // TC => O(NLogN)
    // SC => O(N)
    public int findDuplicateUsingSorting(int[] nums) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        for(int i = 0; i < n - 1; i++) {
            if(sorted[i] == sorted[i + 1]) {
                return sorted[i];
            }
        }
        return -1;
    }

    // Approach 3: Using HashSet - as soon as we see the value already exists then that is the ans
    // TC => O(N)
    // SC => O(N)
    public int findDuplicateUsingHashSet(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(set.contains(nums[i]))
                return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }

    // Approach 4: Using Two Pointers (Floyd's Tortoise and Hare algorithm)
    // Here we model the array as linked list, each index i points to nums[i]
    // Because one number is duplicated, there is a cycle in the list
    // Finding the start of the cycle = duplicate number
    /*
        index:  0  1  2  3  4
        nums:   1  3  4  2  2

        0 → nums[0] = 1
        1 → nums[1] = 3
        3 → nums[3] = 2
        2 → nums[2] = 4
        4 → nums[4] = 2 → ...
    */
    /*
        Input: nums = [1, 3, 4, 2, 2]

        Phase 1: Finding the intersection point
        ---------------------------------------
        Initial:
        slow = nums[0] = 1
        fast = nums[0] = 1

        Iteration 1:
        slow = nums[slow] = nums[1] = 3
        fast = nums[nums[fast]] = nums[nums[1]] = nums[3] = 2

        Iteration 2:
        slow = nums[slow] = nums[3] = 2
        fast = nums[nums[fast]] = nums[nums[2]] = nums[4] = 2

        Now slow == fast == 2 → cycle detected

        Phase 2: Finding the start of the cycle (duplicate number)
        ----------------------------------------------------------
        Reset slow = nums[0] = 1

        Iteration 1:
        slow = nums[slow] = nums[1] = 3
        fast = nums[fast] = nums[2] = 4

        Iteration 2:
        slow = nums[slow] = nums[3] = 2
        fast = nums[fast] = nums[4] = 2

        Now slow == fast == 2 → duplicate number is 2

        Return: 2
     */
    // TC => O(N)
    // SC => O(1)
    public int findDuplicateUsingTwoPointers(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        // Phase 1: Detect cycle (find meeting point)
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        // Phase 2: Find entrance to cycle (duplicate)
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
