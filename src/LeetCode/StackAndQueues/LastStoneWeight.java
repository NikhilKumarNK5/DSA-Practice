package LeetCode.StackAndQueues;

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.
We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.
Return the weight of the last remaining stone. If there are no stones left, return 0.

Example 1:
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

Example 2:
Input: stones = [1]
Output: 1

Constraints:
1 <= stones.length <= 30
1 <= stones[i] <= 1000
*/

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    // Approach 1: Brute Force - Sort the array and compare the last two values and keep updating
    // TC => O(N^2LogN)
    // SC => O(1)
    public int lastStoneWeightSorting(int[] stones) {
        int n = stones.length;

        while(n > 1) {
            Arrays.sort(stones);

            // smash the largest two stones
            int y = stones[n - 1];
            int x = stones[n - 2];

            if(x == y) {
                n -= 2; // if both the equal then exclude the last 2
            } else {
                stones[n - 2] = y - x; // update second last
                n -= 1; // exclude the last
            }
        }

        // if no stones left, return 0 else return the last stone
        return n == 0 ? 0 : stones[0];
    }

    // Approach 2: Using Priority Queue -> always sorted in descending order
    // TC => O(NLogN)
    // SC => O(N)
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add all the stones in the priority queue
        for(int stone : stones) {
            pq.add(stone);
        }

        while(pq.size() > 1) {

            // get two heaviest stones
            int y = pq.poll();
            int x = pq.poll();

            // if the stones are not equal
            if(x != y) {
                pq.add(y - x);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
