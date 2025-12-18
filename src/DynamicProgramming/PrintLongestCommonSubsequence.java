package DynamicProgramming;

/*
Problem statement
You are given two strings ‘s1’ and ‘s2’.
Return the longest common subsequence of these strings.
If there’s no such string, return an empty string. If there are multiple possible answers, return any such string.
Note:
Longest common subsequence of string ‘s1’ and ‘s2’ is the longest subsequence of ‘s1’ that is also a subsequence of ‘s2’. A ‘subsequence’ of ‘s1’ is a string that can be formed by deleting one or more (possibly zero) characters from ‘s1’.

Example:
Input: ‘s1’  = “abcab”, ‘s2’ = “cbab”
Output: “bab”
Explanation:
“bab” is one valid longest subsequence present in both strings ‘s1’ , ‘s2’.
Detailed explanation ( Input/output format, Notes, Images )

Sample Input 1:
5 6
ababa
cbbcad
Expected Answer:
"bba"
Output on console:
1
Explanation of sample output 1:
“bba” is only possible longest subsequence present in both s1 = “ababa” and s2 = “cbbcad”. '1' is printed if the returned string is equal to "bba".

Sample Input 2:
3 3
xyz
abc
Expected Answer:
""
Output on console:
1
Explanation of sample output 2:
There’s no subsequence of ‘s1’ that is also present in ‘s2’. Thus an empty string is returned and '1' is printed.

Expected Time Complexity:
Try to solve this in O(n*m). Where ‘n’ is the length of ‘s1’ and ‘m’ is the length of ‘s2’.

Constraints:
1 <= n, m <= 10^3
Time Limit: 1 sec
*/

public class PrintLongestCommonSubsequence {

    // Approach: Find the length of LCS and then backtrack to find the LCS
    // TC => O(n * m)
    // SC => O(n * m)
    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // string builder to store the lcs
        StringBuilder s = new StringBuilder();

        int i = n;
        int j = m;

        // start from the end of both the strings
        while(i > 0 && j > 0) {
            // if the characters match then append the character to result and move backwards
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                s.append(s1.charAt(i - 1));
                i--;
                j--;
            } else { // if the characters don't match
                // check which location was greater and then move backwards accordingly
                if(dp[i - 1][j] > dp[i][j - 1])
                    i--;
                else
                    j--;
            }
        }

        return s.reverse().toString();
    }
}
