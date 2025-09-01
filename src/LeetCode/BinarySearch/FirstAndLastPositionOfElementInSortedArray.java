package LeetCode.BinarySearch;/*
Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
*/

public class FirstAndLastPositionOfElementInSortedArray {
    // Approach 1: Using simple linear search by using two pointer - one from start and one from end
    // TC => O(N)
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = {-1, -1}; // if the target element does not exist

        for(int i = 0; i < n; i++) {
            if(nums[i] == target && res[0] == -1) { // to make sure we only update the res[0] once that is when we find the first occurrence from start
                res[0] = i;
            }
            if(nums[n - 1 - i] == target && res[1] == -1) { // // to make sure we only update the res[1] once that is when we find the first occurrence from end
                res[1] = n - 1 - i;
            }
        }
        return res;
    }

    // Approach 2: Sorted so use Binary Search
    // TC => O(LogN)
    public int[] searchRangeBinarySearch(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int[] res = {-1, -1};

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) {
                res[0] = mid;
                end = mid - 1; // checking in the left part of array for the 1st occurrence
            } else if(target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        start = 0;
        end = n - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target == nums[mid]) {
                res[1] = mid;
                start = mid + 1; // checking in the right part of array for the last occurrence
            } else if(target < nums[mid]) {
                end =  mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }
}
