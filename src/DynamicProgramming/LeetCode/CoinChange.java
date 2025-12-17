package DynamicProgramming.LeetCode;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4
*/

import java.util.Arrays;

public class CoinChange {

    // Approach 1: Recursion
    // TC => O(n^amount)
    // SC => O(amount)
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0; // if amount is 0 means we do not need any coin
        if(amount < 0)
            return -1; // if amount is less than 0 then it means we cannot make it

        int minCoins = Integer.MAX_VALUE;

        for(int coin : coins) {
            int res = coinChange(coins, amount - coin);
            if(res >= 0 && res < minCoins)
                minCoins = 1 + res;
        }

        return (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
    }

    // Approach 2: Memoization
    // TC => O(n * amount)
    // SC => O(amount)
    public int coinChange1(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return helper(coins, amount, memo);
    }

    private int helper(int[] coins, int amount, int[] memo) {
        if(amount == 0)
            return 0;
        if(amount < 0)
            return -1;
        if(memo[amount] != 0)
            return memo[amount];

        int minCoins = Integer.MAX_VALUE;
        for(int coin : coins) {
            int res = helper(coins, amount - coin, memo);
            if(res >= 0 && res < minCoins)
                minCoins = 1 + res;
        }

        memo[amount] = (minCoins == Integer.MAX_VALUE) ? - 1 : minCoins;
        return memo[amount];
    }

    // Approach 3: 2D DP
    // TC => O(n * amount)
    // SC => O(n * amount)
    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= amount; j++) {
                if(i == 0)
                    dp[i][j] = Integer.MAX_VALUE - 1;
                if(j == 0)
                    dp[i][j] = 0;
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i - 1] <= j)
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    }

    // Approach 3: 1D DP
    // TC => O(n * amount)
    // SC => O(amount)
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            for(int coin : coins) {
                if(i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
