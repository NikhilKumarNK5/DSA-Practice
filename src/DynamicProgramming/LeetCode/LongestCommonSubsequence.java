package DynamicProgramming.LeetCode;

/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:
1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
*/

public class LongestCommonSubsequence {

    // Approach 1: Recursion
    // TC => O(2^n+m)
    // SC => O(n + m)
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        return lcs(text1, text2, n, m);
    }

    private int lcs(String text1, String text2, int n, int m) {
        if(n == 0 || m == 0)
            return 0; // if either of the string is empty then subsequence does not exist

        if(text1.charAt(n - 1) == text2.charAt(m - 1))
            return 1 + lcs(text1, text2, n - 1, m - 1); // if the characters match then we add 1 and recursively call

        return Math.max(lcs(text1, text2, n - 1, m), lcs(text1, text2, n, m - 1)); // if the characters don't match then call recursively and store the max but removing once character from either
    }

    // Approach 2: Memoization
    // TC => O(n * m)
    // SC => O(n * m)
    public int longestCommonSubsequence1(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                dp[i][j] = -1; // initialize with -1 to mark that the problem is not solved yet (not evaluated)
            }
        }

        return lcs1(text1, text2, n, m, dp);
    }

    private int lcs1(String text1, String text2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0)
            return 0;

        if(dp[n][m] != -1)
            return dp[n][m]; // checking if the value is already evaluated then return otherwise do the below (this handles the sub problems)

        if(text1.charAt(n - 1) == text2.charAt(m - 1))
            dp[n][m] = 1 + lcs1(text1, text2, n - 1, m - 1, dp);
        else
            dp[n][m] = Math.max(lcs1(text1, text2, n - 1, m, dp), lcs1(text1, text2, n, m - 1, dp));

        return dp[n][m];
    }

    // Approach 3: Top Down DP
    // TC => O(n * m)
    // SC => O(n * m)
    public int longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];

        // initialized the 0th row and 0th column to 0 as the base case => m == 0 || n == 0 returns 0

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // if characters match add 1 to the previous value
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // if the characters don't match
            }
        }

        return dp[n][m];
    }
}
