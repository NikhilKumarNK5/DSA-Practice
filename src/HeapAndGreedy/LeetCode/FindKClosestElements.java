package HeapAndGreedy.LeetCode;

/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
The result should also be sorted in ascending order.
An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,1,2,3,4,5], k = 4, x = -1
Output: [1,1,2,3]

Constraints:
1 <= k <= arr.length
1 <= arr.length <= 10^4
arr is sorted in ascending order.
-10^4 <= arr[i], x <= 10^4
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {

    // Approach 1: Using max heap
    // TC => O(NLogK)
    // SC => O(K)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    if(a[0] == b[0])
                        return b[1] - a[1]; // if distance equal keep smaller value
                    return b[0] - a[0]; // large distance first
                }
        );

        for(int num : arr) {
            int distance = Math.abs(num - x);
            maxHeap.add(new int[] {distance, num});

            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        // Extract elements from heap
        List<Integer> res = new ArrayList<>();
        while(!maxHeap.isEmpty()) {
            res.add(maxHeap.poll()[1]);
        }

        Collections.sort(res);
        return res;
    }

    // Approach 2: Binary Search + two pointers
    // TC => O(Log(N -K) + K)
    // SC => O(K)
    public List<Integer> findClosestElementsBS(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        // Binary search to find the smallest left such that arr[left...left+k-1] is the closest window to x
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = left; i < left + k; i++)
            res.add(arr[i]);

        return res;
    }
}
