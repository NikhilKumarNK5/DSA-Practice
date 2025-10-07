package DynamicProgramming;

/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
such that each number is the sum of the two preceding ones, starting from 0 and 1.
That is,
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: n = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: n = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

Constraints:
0 <= n <= 30
*/

public class FibonacciNumber {

    // Approach 1: Using Recursion
    // If n is less than two then we have numbers such that 0, 1
    // For n greater than two we have (n - 1) + (n - 2)
    // TC => O(2^N)
    // SC => O(N)
    public int fibRecursion(int n) {
        if(n < 2)
            return n;
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    // Approach 2: Using Dynamic Programming
    // Take a dp array and store the previous two values and the current is calculated as dp[i] = dp[i -1] + dp[i - 2]
    // TC => O(N)
    // SC => O(N)
    public int fibDP(int n) {
        if(n == 0)
            return 0;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
        }

        return dp[n];
    }

    // Approach 3: Using Dynamic Programming - Space optimized
    // Instead of maintaining a DP array, we can just have two different variables to track the prev two values and calculate current based upon that
    // TC => O(N)
    // SC => O(1)
    public int fib(int n) {
        if(n == 0)
            return 0;

        int prev2 = 0;
        int prev1 = 1;

        int current = 0;

        for(int i = 2; i <= n; i++) {
            current = prev2 + prev1;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
