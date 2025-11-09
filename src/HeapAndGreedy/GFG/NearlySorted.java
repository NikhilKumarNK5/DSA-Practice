package HeapAndGreedy.GFG;

/*
Given an array arr[], where each element is at most k positions away from its correct position in the sorted order.
Your task is to restore the sorted order of arr[] by rearranging the elements in place.

Note: Don't use any sort() method.

Examples:
Input: arr[] = [2, 3, 1, 4], k = 2
Output: [1, 2, 3, 4]
Explanation: All elements are at most k = 2 positions away from their correct positions.
Element 1 moves from index 2 to 0
Element 2 moves from index 0 to 1
Element 3 moves from index 1 to 2
Element 4 stays at index 3

Input: arr[]= [7, 9, 14], k = 1
Output: [7, 9, 14]
Explanation: All elements are already stored in the sorted order.

Constraints:
1 ≤ arr.size() ≤ 10^6
0 ≤ k < arr.size()
1 ≤ arr[i] ≤ 10^6
*/

import java.util.PriorityQueue;

public class NearlySorted {

    // Approach: Using minHeap to take k elements and sort the array
    // TC => O(NLogK)
    // SC => O(1)
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = arr.length;

        // Build heap with first k+1 elements
        for(int i = 0; i <= k && i < n; i++) {
            minHeap.add(arr[i]);
        }

        int index = 0; // position to place sorted elements

        // For remaining elements
        for(int i = k + 1; i < n; i++) {
            arr[index++] = minHeap.poll(); // smallest so far
            minHeap.add(arr[i]);
        }

        // Pop remaining elements
        while(!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
