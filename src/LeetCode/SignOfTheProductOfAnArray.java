package LeetCode;

/*
Implement a function signFunc(x) that returns:
1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.
Return signFunc(product).

Example 1:
Input: nums = [-1,-2,-3,-4,3,2,1]
Output: 1
Explanation: The product of all values in the array is 144, and signFunc(144) = 1

Example 2:
Input: nums = [1,5,0,2,-3]
Output: 0
Explanation: The product of all values in the array is 0, and signFunc(0) = 0

Example 3:
Input: nums = [-1,1,-1,1,-1]
Output: -1
Explanation: The product of all values in the array is -1, and signFunc(-1) = -1

Constraints:
1 <= nums.length <= 1000
-100 <= nums[i] <= 100
*/

public class SignOfTheProductOfAnArray {
    // Approach 1: need for find the product of array and then check
    // If we directly multiply the elements of the array the situation might lead to overflow and even log is not safe
    // We could change all the negative elements to -1 and positive to 1 as we are only concerned about the sign of the product and not the actual product
    // TC => O(N)
    public int arraySign(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                nums[i] = -1;
            } else if(nums[i] > 0) {
                nums[i] = 1;
            }
        }
        int product = 1;
        for(int i = 0; i < nums.length; i++) {
            product *= nums[i];
        }

        if(product == 1)
            return 1;
        else if(product == -1)
            return -1;

        return 0;
    }

    // Approach 2: Instead of changing the elements of the array we can just keep track of what would be the sign
    // We can loop through the array and update the sign if we find any negative element
    // TC => O(N)
    public int arraySignII(int[] nums) {
        int sign = 1; // initial Sign
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                return 0; // if zero exists at any point the product would be zero, hence returning 0
            else if(nums[i] < 0)
                sign *= -1; // each time we encounter a negative number we change the sign
        }
        return sign;
    }
}
