package Recurssion.GFG;

/*
We have N persons sitting on a round table. Any person can do a handshake with any other person.

     1
2         3
     4

Handshake with 2-3 and 1-4 will cause cross.
In how many ways these N people can make handshakes so that no two handshakes cross each other.
N would be even.

Example 1:
Input:
N = 2
Output:
1
Explanation:
{1,2} handshake is
possible.

Example 2:
Input:
N = 4
Output:
2
Explanation:
{{1, 2}, {3, 4}} are the
two handshakes possible.
{{1, 3}, {2, 4}} is another
set of handshakes possible.

Your Task:
You don't need to read input or print anything.
Your task is to complete the function count() which takes an integer N as input parameters and
returns an integer, the total number of handshakes possible so that no two handshakes cross each other.

Expected Time Complexity: O(2^N)
Expected Space Complexity: O(1)

Constraints:
1 <= N <= 30
*/

public class Handshakes {

    // Approach 1: Using Recursion
    static int count(int N) {
        // if N becomes odd then not possible to handshake for everyone
        if(N % 2 != 0)
            return 0;
        // if N == 0 then 1 handshake is possible
        if(N == 0)
            return 1;

        int ans = 0;
        // pairing even numbers with 1 and checking and calculating the total handshakes
        for(int i = 2; i <= N; i++) {
            int left = count(i - 2);
            int right = count(N - i);
            ans += left * right;
        }
        return ans;
    }

    // Approach 2: Using Catalan Number
    static int countUsingCatalanNumber(int N) {
        int n = N / 2;
        long res = 1;
        for(int i = 0; i < n; i++) {
            res = res * (2 * n - i) / (i + 1);
        }
        return (int) (res / (n + 1));
    }
}
