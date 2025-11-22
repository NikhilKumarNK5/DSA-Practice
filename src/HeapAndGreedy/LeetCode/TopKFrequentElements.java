package HeapAndGreedy.LeetCode;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]

Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    // Approach: Use a HashMap to store the frequency of element and then sort the heap based upon the frequency
    // TC => O(NLogk)
    // SC => O(k)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        // create a minHeap and sort based on the frequency of element from the map
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int num : map.keySet()) {
            minHeap.add(num);
            if(minHeap.size() > k)
                minHeap.poll();
        }

        int[] res = new int[k];
        int index = 0;

        while(!minHeap.isEmpty()) {
            res[index++] = minHeap.poll();
        }

        return res;
    }
}
