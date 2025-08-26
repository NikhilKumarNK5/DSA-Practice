package LeetCode;

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]
Example 2:
Input: nums = [1]
Output: [1]
Example 3:
Input: nums = [1,2]
Output: [1,2]

Constraints:
1 <= nums.length <= 5 * 10^4
-10^9 <= nums[i] <= 10^9

Follow up: Could you solve the problem in linear time and in O(1) space?
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    // Approach 1: Store and element and count in HashMap
    // iterate through HashMap and check if count > n / 3 then add the element to result
    // TC => O(N)
    // SC => O(N)
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > n / 3)
                res.add(entry.getKey());
        }

        return res;
    }

    // Approach 2: Using Boyer-Moore Majority Voting Algorithm
    // there could be atmost 2 elements that could appear more than N/3 times
    // work on identifying the two potential candidates and count the occurrences of both and then return
    // TC => O(N)
    // SC => O(1)
    public List<Integer> majorityElementVoting(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        // choosing two potential candidates
        for(int current : nums) {
            if(current == candidate1)
                count1++;
            else if(current == candidate2)
                count2++;
            else if(count1 == 0) {
                candidate1 = current;
                count1 = 1;
            } else if(count2 == 0) {
                candidate2 = current;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // counting the occurrences of both the candidates
        count1 = 0;
        count2 = 0;
        for(int ele: nums) {
            if(ele == candidate1)
                count1++;
            else if(ele == candidate2)
                count2++;
        }

        // adding to the result list
        if(count1 > n / 3)
            res.add(candidate1);
        if(count2 > n / 3)
            res.add(candidate2);

        return res;
    }
}
