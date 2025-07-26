package LeetCode;

/*
Given a positive integer num, split it into two non-negative integers num1 and num2 such that:
The concatenation of num1 and num2 is a permutation of num.
In other words, the sum of the number of occurrences of each digit in num1 and num2
is equal to the number of occurrences of that digit in num.
num1 and num2 can contain leading zeros.
Return the minimum possible sum of num1 and num2.
Notes:
It is guaranteed that num does not contain any leading zeros.
The order of occurrence of the digits in num1 and num2 may differ from the order of occurrence of num.

Example 1:
Input: num = 4325
Output: 59
Explanation: We can split 4325 so that num1 is 24 and num2 is 35, giving a sum of 59.
We can prove that 59 is indeed the minimal possible sum.

Example 2:
Input: num = 687
Output: 75
Explanation: We can split 687 so that num1 is 68 and num2 is 7, which would give an optimal sum of 75.

Constraints:
10 <= num <= 10^9
*/

import java.util.Arrays;

public class SplitWithMinimumSum {
    // Approach: Using char array and sorting
    // TC => O(NLogN)
    public int splitNum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        // constructing num1 and num2
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for(int i = 0; i < digits.length; i++) {
            if(i % 2 == 0) {
                num1.append(digits[i]);
            } else {
                num2.append(digits[i]);
            }
        }
        int n1 = Integer.parseInt(num1.toString());
        int n2 = Integer.parseInt(num2.toString());
        int sum = n1 + n2;
        return sum;
    }

    // Approach 2: Approach using Digit frequency
    /*
        Dry Run for input: num = 2932
        Digit frequency after counting:
        count[2] = 2
        count[3] = 1
        count[9] = 1

        count[] = [0, 0, 2, 1, 0, 0, 0, 0, 0, 1]

        +-----------+-----------+--------+-------+-------+----------------------------+
        | Digit (i) | count[d]  | Toggle | num1  | num2  | Action                     |
        +-----------+-----------+--------+-------+-------+----------------------------+
        |     0     |    0      |   -    |   0   |   0   | skip                       |
        |     1     |    0      |   -    |   0   |   0   | skip                       |
        |     2     |    2      |   T    |   2   |   0   | num1 = 0 * 10 + 2 = 2      |
        |     2     |    1      |   F    |   2   |   2   | num2 = 0 * 10 + 2 = 2      |
        |     3     |    1      |   T    |  23   |   2   | num1 = 2 * 10 + 3 = 23     |
        |   4–8     |    0      |   -    |  23   |   2   | skip                       |
        |     9     |    1      |   F    |  23   |  29   | num2 = 2 * 10 + 9 = 29     |
        +-----------+-----------+--------+-------+-------+----------------------------+

        Final Result:
        num1 = 23
        num2 = 29
        return num1 + num2 = 52
    */
    // TC => O(N)
    public int splitNumDigitFrequency(int num) {
        // num = 2932
        int[] count = new int[10]; // frequency of digits [0-9]

        // Count frequency of each digit in the number
        while (num > 0) {
            int digit = num % 10;
            count[digit]++;
            num /= 10;
        }
        // After loop, count[] = [0, 0, 2, 1, 0, 0, 0, 0, 0, 1]

        int num1 = 0, num2 = 0;

        // Reconstruct two numbers by distributing digits
        boolean toggle = true; // used to alternate assigning digits between num1 and num2

        for (int i = 0; i <= 9; i++) {
            while (count[i] > 0) {
                if (toggle) {
                    num1 = num1 * 10 + i;
                } else {
                    num2 = num2 * 10 + i;
                }
                toggle = !toggle; // used to alternate assigning digits between num1 and num2
                count[i]--;
            }
        }

        return num1 + num2;
    }
}
