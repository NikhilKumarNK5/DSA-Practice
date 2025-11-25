package HeapAndGreedy.GFG;

/*
Given an array A[] of N positive integers and two positive integers K1 and K2.
Find the sum of all elements between K1th and K2th smallest elements of the array.
It may be assumed that (1 <= k1 < k2 <= n).

Example 1:
Input:
N  = 7
A[] = {20, 8, 22, 4, 12, 10, 14}
K1 = 3, K2 = 6
Output:
26
Explanation:
3rd smallest element is 10
6th smallest element is 20
Element between 10 and 20
12,14. Their sum = 26.

Example 2:
Input
N = 6
A[] = {10, 2, 50, 12, 48, 13}
K1= 2, K2 = 6
Output:
73

Your Task:
You don't need to read input or print anything.
Your task is to complete the function sumBetweenTwoKth() which takes the array A[], its size N and two integers K1 and K2 as inputs and returns the sum of all the elements between K1th and K2th smallest elements.
Expected Time Complexity: O(N. log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 10^5
1 ≤ K1, K2 ≤ 10^5
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class SumOfElementsBetweenK1AndK2SmallestElements {

    // Approach: Use max heap to find the k1th smallest element and k2th smallest element
    // find the sum of elements that lie between those
    // TC => O(NLogN)
    // SC => O(max(K1, K2))
    public static long sumBetweenTwoKth(long A[], long N, long K1, long K2) {
        long first = kthSmallestElement(A, K1);
        long second = kthSmallestElement(A, K2);

        long sum = 0;

        for(long num : A) {
            if(num > first && num < second)
                sum += num;
        }

        return sum;
    }

    private static long kthSmallestElement(long[] A, long k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(long num : A) {
            maxHeap.add(num);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
