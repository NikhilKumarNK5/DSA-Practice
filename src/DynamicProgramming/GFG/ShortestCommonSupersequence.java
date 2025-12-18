package DynamicProgramming.GFG;

/*
Given two strings s1 and s2, find the length of the smallest string which has both s1 and s2 as its sub-sequences.
Note: s1 and s2 can have both uppercase and lowercase English letters.

Examples:
Input: s1 = "geek", s2 = "eke"
Output: 5
Explanation: String "geeke" has both string "geek" and "eke" as subsequences.

Input: s1 = "AGGTAB", s2 = "GXTXAYB"
Output: 9
Explanation: String "AGXGTXAYB" has both string "AGGTAB" and "GXTXAYB" as subsequences.

Input: s1 = "geek", s2 = "ek"
Output: 4
Explanation: String "geek" has both string "geek" and "ek" as subsequences.

Constraints:
1 ≤ s1.size(), s2.size() ≤ 500
*/

public class ShortestCommonSupersequence {

    // Approach: We need the length of shortest common supersequence
    // longest would be n + m
    // shortest -> find length of lcs and subtract as that would be common and will we added twice in n + m
    // n + m - lcs
    // TC => O(n * m)
    // SC => O(n * m)
    public static int minSuperSeq(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return n + m - dp[n][m];
    }
}
