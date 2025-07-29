package GFG;

/*
Given a number n and a value k. From the right, set the kth bit in the binary representation of n.
The position of the Least Significant Bit(or last bit) is 0, the second last bit is 1 and so on.

Examples:
Input: n = 10, k = 2
Output: 14
Explanation: Binary representation of the given number 10 is: 1 0 1 0,
number of bits in the binary reprsentation is 4. Thus 2nd bit from right is 0.
The number after changing this bit to 1 is: 14(1 1 1 0).

Input: n = 15, k = 3
Output: 15
Explanation: The binary representation of the given number 15 is: 1 1 1 1,
number of bits in the binary representation is 4. Thus 3rd bit from the right is 1.
The number after changing this bit to 1 is 15(1 1 1 1).

Constraints:
1 <= n <= 10^9
0 <= k < x, where x is the number of bits in the binary representation of n.


*/

public class SetKthBit {
    // (1 << k) creates a mask where only the k-th bit is set.
    // For example, if k = 2 → 1 << 2 = 4 → binary: 00000100
    // Use bitwise OR to set the k-th bit to 1:
    // If the k-th bit is already 1 → it remains 1
    // If the k-th bit is 0 → it becomes 1
    // All other bits remain unchanged
    static int setKthBit(int n, int k) {
        return n | (1 << k );
    }
}
