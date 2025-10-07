package DynamicProgramming;

/*
Each element nums[i] represents the maximum length of a forward jump from index i.
In other words, if you are at index i, you can jump to any index (i + j) where:
0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach index n - 1.
The test cases are generated such that you can reach index n - 1.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
*/

public class JumpGameII {

    // Approach: Greedy -> Try to reach as far as possible and check if we have reached the end of the current window then increase the window size and increase the no of jumps
    // TC => O(N)
    // SC => O(1)
    public int jump(int[] nums) {
        int current = 0; // current window end
        int farthest = 0; // the farthest we can each from the current position
        int jumps = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // farthest go is from ith position to i + nums[i] th position

            // if we reach the end of current jump window means we have used a jump so need to update the window to the farthest we can go as well as increment the jump
            if(current == i) {
                current = farthest;
                jumps++;
            }
        }

        return jumps;
    }
}
