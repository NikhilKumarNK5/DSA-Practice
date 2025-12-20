package DynamicProgramming.LeetCode;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:
0 <= s.length <= 100
0 <= t.length <= 10^4
s and t consist only of lowercase English letters.

Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
*/

public class IsSubsequence {

    // Approach 1: Identify the LCS of s and t and if the LCS equals s then it is a subsequence else not
    // TC => O(n * m)
    // SC => O(n * m)
    public boolean isSubsequence(String s, String t) {
        if(s.equals("") && t.equals(""))
            return true;
        if(t.equals(""))
            return false;

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m] == n;
    }

    // Approach 2: Two Pointer
    // Take two pointers starting from the beginning of both the strings and check if they are equal then move both else move the t string pointer
    // if we are able to reach the case where i becomes equal to the length of s then surely s is a subsequence of t
    // TC => O(n)
    // SC => O(1)
    public boolean isSubsequence2(String s, String t) {
        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }

        return i == s.length();
    }
}
