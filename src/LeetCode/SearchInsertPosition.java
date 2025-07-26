package LeetCode;/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:
1 <= nums.length <= 10^4
-104 <= nums[i] <= 10^4
nums contains distinct values sorted in ascending order.
-10^4 <= target <= 10^4
*/

public class SearchInsertPosition {
    // Approach 1: Linear Search
    // Check if the current element is greater than or equal to the target and if that's true that return index
    /*
       Input:
            nums = [1, 3, 5, 6]
            target = 2
       Iteration 1
            i = 0
            nums[0] = 1
            nums[0] >= target → 1 >= 2 → false
            → continue
       Iteration 2
            i = 1
            nums[1] = 3
            nums[1] >= target → 3 >= 2 → true
            → return 1
       Final Result:
            Output = 1
            (2 would be inserted at index 1 to maintain sorted order)
    */
    // TC => O(N)
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= target)
                return i;
        }
        return nums.length; // if target is greater than all the elements in the array then we need to insert it at the end
        //[1, 3, 5, 6], target = 7 => insert at 4th index that is after 6
    }

    // Binary Search
    /*
        Input:
            nums = [1, 3, 5, 6]
            target = 2
        Initial:
            n = 4
            start = 0, end = 3
            res = -1
        Iteration 1
            mid = 0 + (3 - 0) / 2 = 1
            nums[mid] = 3
            target = 2
            nums[mid] > target → go left
            → end = mid - 1 = 0
            → res = mid = 1
        Iteration 2
            start = 0, end = 0
            mid = 0 + (0 - 0) / 2 = 0
            nums[mid] = 1
            target = 2
            nums[mid] < target → go right
            → start = mid + 1 = 1
            → res = mid + 1 = 1
        Now:
            start = 1, end = 0 → loop exits
        Final Result:
            return res = 1
            (2 should be inserted at index 1 to maintain sorted order)
    */
    // TC => O(LogN)
    public int searchInsertBinarySearch(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int res = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid; // target found
            } else if(nums[mid] < target) {
                start = mid + 1;
                res = mid + 1; // potential insert position
            } else {
                end = mid - 1;
                res = mid; // potential insert position
            }
        }
        return res;
    }
}
