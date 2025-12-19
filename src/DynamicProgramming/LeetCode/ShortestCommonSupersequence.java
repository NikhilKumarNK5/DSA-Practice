package DynamicProgramming.LeetCode;

/*
Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.
A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

Example 1:
Input: str1 = "abac", str2 = "cab"
Output: "cabac"
Explanation:
str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
The answer provided is the shortest such string that satisfies these properties.

Example 2:
Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
Output: "aaaaaaaa"

Constraints:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of lowercase English letters.
*/

public class ShortestCommonSupersequence {

    // Approach: Follow the approach of Print LCS
    // Build the table for LCS then trace back the DP table and build SCS
    // At the end append the remaining characters from both strings to the ans string as well
    // TC => O(n * m)
    // SC => O(n * m)
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Fill DP table for LCS
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Build SCS by tracing back through DP table
        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;

        while(i > 0 && j > 0) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if(dp[i - 1][j] > dp[i][j - 1]) {
                    sb.append(str1.charAt(i - 1));
                    i--;
                } else {
                    sb.append(str2.charAt(j - 1));
                    j--;
                }
            }
        }

        // Add remaining characters from either string
        while(i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while(j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        // Reverse because we built it backwards
        return sb.reverse().toString();
    }
}
