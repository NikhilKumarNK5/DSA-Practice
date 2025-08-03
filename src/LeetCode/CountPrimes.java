package LeetCode;

/*
Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:
Input: n = 0
Output: 0

Example 3:
Input: n = 1
Output: 0

Constraints:
0 <= n <= 5 * 10^6
*/

public class CountPrimes {
    // Approach 1: Get the factors of the number and check it has only 2 factors then it is prime
    // TC => O(N * sqrt(N)) -> TLE
    public int countPrimes(int n) {
        int countPrimes = 0;
        for(int i = 2; i < n; i++) {
            if(countFactors(i) == 2) // if a number has exactly 2 factors then it is prime
                countPrimes++;
        }
        return countPrimes;
    }
    // calculating the no of factors of a given number
    static int countFactors(int n) {
        int countFactors = 0;
        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                if(i != n / i) {
                    countFactors += 2;
                } else {
                    countFactors ++;
                }
            }
        }
        return countFactors;
    }

    // Approach 2: Using Sieve of Eratosthenes
    // TC => O(NLogLogN)
    // SC => O(N)
    public int countPrimesSieve(int n) {
        boolean[] prime = new boolean[n];
        for(int i = 2; i < n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p < n; p++) {
            if (prime[p]) {
                // marking multiple of i as not prime
                for (int i = p * p; i < n; i += p)
                    prime[i] = false;
            }
        }

        // Count number of primes
        int count = 0;
        for (int p = 2; p < n; p++) {
            if (prime[p])
                count++;
        }
        return count;
    }
}
