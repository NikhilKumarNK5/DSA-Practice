package LeetCode;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an
integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:
2 <= numbers.length <= 3 * 10^4
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
*/

import java.util.HashMap;

public class TwoSumII_InputArrayIsSorted {

    // Approach 1: Brute Force
    // TC => O(N^2)
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        return new int[] {0, 0}; // {0, 0} also works as the edge because we are considering 1 based indexing
    }

    // Approach 2: Using HashMap
    // TC => O(N)
    // SC => O(N)
    public int[] twoSumHashMap(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            int difference = target - numbers[i];
            if(hm.containsKey(difference))
                return new int[] {hm.get(difference) + 1, i + 1};
            hm.put(numbers[i], i);
        }
        return new int[] {0, 0};
    }

    // Approach 3: Using Two Pointers (Binary Search)
    // Since the array is sorted then Binary search can be applied to check for the indices of target
    // TC => O(LogN)
    public int[] twoSumTwoPointers(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while(start < end) {
            if((numbers[start] + numbers[end]) == target) {
                // since the index starts from 1 so converting to 1 based index
                res[0] = start + 1;
                res[1] = end + 1;
                return res;
            } else if((numbers[start] + numbers[end]) > target) { // if the target is lesser than the current sum we need to move the end pointer to the left as that will give lesser sum
                end--;
            } else { // if the target is greater than the current sum then we need to move the start pointer to the right as that will give the greater sum
                start++;
            }
        }
        return res;
    }
}
