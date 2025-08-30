package GFG.SlidingWindowAndTwoPointers;

/*
Given an array arr[] of integers and another integer target.
Determine if there exist two distinct indices such that the sum of their elements is equal to the target.

Examples:
Input: arr[] = [0, -1, 2, -3, 1], target = -2
Output: true
Explanation: arr[3] + arr[4] = -3 + 1 = -2

Input: arr[] = [1, -2, 1, 0, 5], target = 0
Output: false
Explanation: None of the pair makes a sum of 0

Input: arr[] = [11], target = 11
Output: false
Explanation: No pair is possible as only one element is present in arr[]

Constraints:
1 ≤ arr.size ≤ 10^5
-10^5 ≤ arr[i] ≤ 10^5
-2*10^5 ≤ target ≤ 2*10^5
*/

import java.util.HashMap;

public class TwoPair_PairWithGivenSum {

    // Approach 1: Brute Force: For each element check every other element and compare if the sum equals the target
    // TC => O(N^2)
    boolean twoSum(int arr[], int target) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] + arr[j] == target)
                    return true;
            }
        }
        return false;
    }

    // Approach 2: Using HashMap
    // TC => O(N)
    // SC => O(N)
    boolean twoSumMap(int arr[], int target) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int difference = target - arr[i];
            if(map.containsKey(difference))
                return true;
            else {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
        }
        return false;
    }
}
