package HeapAndGreedy.LeetCode;

/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
If multiple values have the same frequency, sort them in decreasing order.
Return the sorted array.

Example 1:
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Example 2:
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Example 3:
Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]

Constraints:
1 <= nums.length <= 100
-100 <= nums[i] <= 100
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencySort {

    // Approach 1: Using HashMap and Heap
    // Store the frequency and element in map and then push to heap based upon frequency in increasing order
    // put into result array the values from heap based upon its frequency
    // TC => O(N + MLogM) , M = number of unique elements
    // SC => O(N + M)
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
            if(map.get(a).equals(map.get(b))) {
                return b - a; // higher value first if frequency is same
            }
            return map.get(a) - map.get(b); // lower frequency first
        });

        for(int num : map.keySet()) {
            minHeap.add(num);
        }

        int index = 0;
        while(!minHeap.isEmpty()) {
            int num = minHeap.poll();
            for(int i = 0; i < map.get(num); i++) {
                nums[index++] = num;
            }
        }

        return nums;
    }

    // Approach 2: Using Custom comparator with Arrays.sort
    // TC => O(NLogN)
    // SC => O(N + M)
    public int[] frequencySortComparator(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // convert int[] to Integer[] for custom sorting
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> {
            if(map.get(a).equals(map.get(b))) {
                return b - a; // higher value first if the frequency is the same
            }
            return map.get(a) - map.get(b); // lowerfrequency first
        });

        // conver back to int[]
        for(int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}
