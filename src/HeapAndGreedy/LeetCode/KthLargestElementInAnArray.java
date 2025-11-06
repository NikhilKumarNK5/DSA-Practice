package HeapAndGreedy.LeetCode;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    // Approach 1: Sort the array
    // Return the length - k the index
    // TC => O(NLogN)
    // SC => O(1)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // Approach 2: Using Min Heap
    // TC => O(NLogK)
    // SC => O(1)
    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums) {
            minHeap.add(num);
            if(minHeap.size() > k)
                minHeap.poll(); // removes the smallest among k + 1
        }

        // root will have the kth largest
        return minHeap.peek();
    }
}
