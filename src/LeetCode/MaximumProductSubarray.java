package LeetCode;

/*
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
*/

public class MaximumProductSubarray {

    // Approach 1: Using Modified Kadane's algorithm
    // TC => O(N)
    public int maxProduct(int nums[]) {
        int n = nums.length;
        if(n == 1) {
            return nums[0]; // if only one element then return the element
        }
        int leftProduct = 1;
        int rightProduct = 1;
        int maxProduct = nums[0];

        for(int i = 0; i < n; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct; // if becomes 0 then reset it
            rightProduct = rightProduct == 0 ? 1 : rightProduct; // if becomes 0 then reset it

            leftProduct *= nums[i]; // product from left of array

            rightProduct *= nums[n - 1 - i]; // product from right of array

            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct)); // maintaining the maximum product
        }
        return maxProduct;
    }

    // Approach 2: Dynamic Programming
    // Tracking maximum and minimum product in each step
    /*
        DRY RUN
     Input: [2, 3, -2, 4]

     Initial values:
     res = Integer.MIN_VALUE -> will become max of array = 4
     currMax = 1
     currMin = 1

     Iteration 1: ele = 2
         temp = 1 * 2 = 2
         currMax = max(2, max(1*2, 2)) = 2
         currMin = min(2, min(1*2, 2)) = 2
         res = max(4, 2) = 4

     Iteration 2: ele = 3
         temp = 2 * 3 = 6
         currMax = max(6, max(2*3, 3)) = 6
         currMin = min(6, min(2*3, 3)) = 3
         res = max(4, 6) = 6

     Iteration 3: ele = -2
         temp = 6 * -2 = -12
         currMax = max(-12, max(3 * -2, -2)) = max(-12, -6, -2) = -2
         currMin = min(-12, min(3 * -2, -2)) = min(-12, -6, -2) = -12
         res = max(6, -2) = 6

     Iteration 4: ele = 4
         temp = -2 * 4 = -8
         currMax = max(-8, max(-12 * 4, 4)) = max(-8, -48, 4) = 4
         currMin = min(-8, min(-12 * 4, 4)) = min(-8, -48, 4) = -48
         res = max(6, 4) = 6

     Final result: 6
     ---------------------
    */
    // TC => O(N)
    public int maxProductDP(int[] nums) {
        // Initialize result with the minimum possible integer value
        // It will eventually hold the maximum product of any subarray
        int res = Integer.MIN_VALUE;

        // First, set res to the maximum element in the array
        // This helps handle cases where all elements are negative or zero
        for (int ele : nums) {
            res = Math.max(res, ele);
        }

        int currMax = 1; // Tracks the current maximum product ending at the current index
        int currMin = 1; // Tracks the current minimum product ending at the current index (used for handling negatives)

        for (int ele : nums) {
            // temp stores current max before it gets overwritten
            int temp = currMax * ele;

            // Update currMax by considering:
            // 1. current element alone (starting new subarray)
            // 2. product of current element with previous max
            // 3. product of current element with previous min (in case ele is negative)
            currMax = Math.max(temp, Math.max(currMin * ele, ele));

            // Similarly, update currMin
            currMin = Math.min(temp, Math.min(currMin * ele, ele));

            // Update global max product found so far
            res = Math.max(res, currMax);
        }

        return res;
    }
}
