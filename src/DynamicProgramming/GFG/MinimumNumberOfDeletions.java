package DynamicProgramming.GFG;

/*
Given a string s. The task is to remove or delete the minimum number of characters from the string s, so that the resultant string forms a palindrome. Find the minimum number of characters we need to remove.
Note: The order of characters should be maintained.

Examples:
Input: s = "aebcbda"
Output: 2
Explanation: Remove characters 'e' and 'd'. Resultant string will be "abcba" which is a palindromic string.
Input: s = "aba"
Output: 0
Explanation: We don’t remove any character.
Constraints:
1 ≤ s.size() ≤ 10^3
*/

public class MinimumNumberOfDeletions {

    // Approach: LCS
    // Reverse the given string -> if we need palindrome then reverse and the string would have the LCS
    // result -> n - lcs (remove the characters to make it palindrome)
    // TC => O(n^2)
    // SC => O(n^2)
    public int minDeletions(String s) {
        String str = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == str.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return n - dp[n][n];
    }
}
