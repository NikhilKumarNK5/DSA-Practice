package GFG;

/*
Given a positive integer n, determine whether it is odd or even.
Return true if the number is even and false if the number is odd.

Examples:
Input: n = 15
Output: false
Explanation: The number is not divisible by 2, Odd number.

Input: n = 44
Output: true
Explanation: The number is divisible by 2, Even number.

Constraints:
1 ≤ n ≤ 10^4
*/

public class OddOrEven {
    // Approach 1: Do modulo 2 and if it returns 0 then the number is even else odd
    // TC => O(1)
    static boolean isEven(int n) {
        return (n % 2) == 0;
    }

    // Approach 2: Using AND bitwise operator
    // the least significant bit in any number in binary form represent if the number is even or odd
    // the LSB is 2^0 which equal 1 -> so if last number is 0 then even else if it's 1 then odd
    // TC => O(1)
    static boolean isEvenUsingBitWiseAnd(int n) {
        return (n & 1) == 0;
    }
}
