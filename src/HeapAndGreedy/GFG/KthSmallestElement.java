package HeapAndGreedy.GFG;

/*
Given an integer array arr[] and an integer k,
your task is to find and return the kth smallest element in the given array.

Examples :
Input: arr[] = [10, 5, 4, 3, 48, 6, 2, 33, 53, 10], k = 4
Output: 5
Explanation: 4th smallest element in the given array is 5.

Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
Output: 7
Explanation: 3rd smallest element in the given array is 7.

Constraints:
1 ≤ arr.size() ≤ 10^5
1 ≤ arr[i] ≤ 10^5
1 ≤ k ≤  arr.size()
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    // Approach 1: Sort the array and return the (k - 1)th index value
    // TC => O(NLogN)
    // SC => O(1)
    public int kthSmallest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    // Approach 2: Using max heap to get the kth smallest
    // TC => O(NlogK)
    // SC => O(K)
    public int kthSmallestHeap(int[] arr, int k) {
        // max heap for kth Smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : arr) {
            maxHeap.add(num);
            if(maxHeap.size() > k)
                maxHeap.poll(); // remove largest among k + 1
        }

        // the root is the kth smallest
        return maxHeap.peek();
    }
}
