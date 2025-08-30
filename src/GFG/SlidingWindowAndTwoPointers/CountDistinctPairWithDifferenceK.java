package GFG.SlidingWindowAndTwoPointers;

/*
Given an integer array of size n and a non-negative integer k,
count all distinct pairs with a difference equal to k, i.e., A[ i ] - A[ j ] = k.

Example 1:
Input: array = {1, 5, 4, 1, 2}, k = 0
Output: 1
Explanation: There is only one pair (1, 1) whose difference equal to 0.

Example 2;
Input: array = {1, 5, 3}, k = 2
Output: 2
Explanation: There are two pairs (5, 3) and (1, 3) whose difference equal to 2.

Your Task:
You don't need to read or print anything.
Your task is to complete the function TotalPairs() which takes array and k as input parameters and returns the count of all distinct pairs.

Expected Time Complexity: O(n)
Expected Space Complexity: O(n)

Constraints:
2 <= n <= 10^4
0 <= k <= 10^4
1 <= nums[i] <= 10^6
*/

import java.util.HashMap;

public class CountDistinctPairWithDifferenceK {

    // Brute force - Using HashMap
    // TC => O(N)
    // SC => O(N)
    public int TotalPairs(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        if(k == 0) {
            // count numbers that appear atleast twice
            for(int freq : map.values()) {
                if(freq > 1)
                    count++;
            }
        } else {
            for(int num : map.keySet()) {
                if(map.containsKey(num + k))
                    count++;
            }
        }
        return count;
    }
}
