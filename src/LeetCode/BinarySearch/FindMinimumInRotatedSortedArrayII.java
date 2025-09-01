package LeetCode.BinarySearch;/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,4,4,5,6,7] might become:
[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time
results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
Given the sorted rotated array nums that may contain duplicates,
return the minimum element of this array.
You must decrease the overall operation steps as much as possible.

Example 1:
Input: nums = [1,3,5]
Output: 1

Example 2:
Input: nums = [2,2,2,0,1]
Output: 0

Constraints:
n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
nums is sorted and rotated between 1 and n times.

Follow up: This problem is similar to Find Minimum in Rotated Sorted Array,
but nums may contain duplicates. Would this affect the runtime complexity? How and why?
*/

public class FindMinimumInRotatedSortedArrayII {
    // Approach 1: Using Linear Search
    // Linear Search that we use to find the minimum in any given array
    // TC => O(N)
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min)
                min = nums[i];
        }
        return min;
    }

    // Approach 2: Using Binary Search
    // TC => O(LogN)
    public int findMinBinarySearch(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[end]) { // minimum is in the left half (including mid)
                end = mid;
            } else if(nums[mid] > nums[end]) {
                start = mid + 1; // minimum is in the right half (excluding mid)
            } else {
                end--; // in case nums[mid] == nums[end] Ex: [1, 1]
            }
        }
        return nums[start];
    }
}
