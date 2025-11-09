package HeapAndGreedy.LeetCode;

/*
Given the array of integers nums, you will choose two different indices i and j of that array.
Return the maximum value of (nums[i]-1)*(nums[j]-1).

Example 1:
Input: nums = [3,4,5,2]
Output: 12
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.

Example 2:
Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.

Example 3:
Input: nums = [3,7]
Output: 12

Constraints:
2 <= nums.length <= 500
1 <= nums[i] <= 10^3
*/

import java.util.PriorityQueue;

public class MaximumProductOfTwoElementsInAnArray {

    // Approach 1: Using min heap
    // TC => O(N)
    // SC => O(1)
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums) {
            minHeap.add(num);

            if(minHeap.size() > 2)
                minHeap.poll();
        }

        int res = 0;
        int ele1 = minHeap.poll();
        int ele2 = minHeap.poll();

        res = (ele1 - 1) * (ele2 - 1);

        return res;
    }

    // Approach 2: Find the first - largest and second - largest numbers in single pass
    // TC => O(N)
    // SC => O(1)
    public int maxProductII(int [] nums) {
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num > largest) {
                secondlargest = largest;
                largest = num;
            } else if(num > secondlargest) {
                secondlargest = num;
            }
        }

        return (largest - 1) * (secondlargest - 1);
    }
}
