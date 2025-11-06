package HeapAndGreedy.GFG;

/*
Given an array arr[] of positive integers and an integer k,
Your task is to return k largest elements in decreasing order.

Examples:
Input: arr[] = [12, 5, 787, 1, 23], k = 2
Output: [787, 23]
Explanation: 1st largest element in the array is 787 and second largest is 23.

Input: arr[] = [1, 23, 12, 9, 30, 2, 50], k = 3
Output: [50, 30, 23]
Explanation: Three Largest elements in the array are 50, 30 and 23.

Input: arr[] = [12, 23], k = 1
Output: [23]
Explanation: 1st Largest element in the array is 23.

Constraints:
1 ≤ k ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {

    // Approach 1: Sort the array and return elements from arr[length - 1] to arr[length - k]
    // TC => O(NLogN)
    // SC => O(1)
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = arr.length - 1; i >= arr.length - k; i--) {
            res.add(arr[i]);
        }

        return res;
    }

    // Approach 2: Using MinHeap
    // TC => O(NLogK)
    // SC => O(K)
    public  ArrayList<Integer> kLargestHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : arr) {
            minHeap.add(num);
            if(minHeap.size() > k)
                minHeap.poll();
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(minHeap.size() > 0) {
            res.add(0, minHeap.poll());
        }

        return res;
    }
}
