package Recurssion;

public class Palindrome {
    public static void main(String[] args) {
        int n = 12321;
        System.out.println(reverseNumber(n));
        System.out.println(palindrome(n));
    }

    static int reverseNumber(int n) {
        int digits = (int) (Math.log10(n)) + 1;
        return helper(n, digits);
    }

    static int helper(int n, int digits) {
        if(n % 10 == n)
            return n;
        int rem = n % 10;
        return rem * (int) Math.pow(10, digits - 1) + helper(n / 10, digits - 1);
    }

    static boolean palindrome(int n) {
        return (n == reverseNumber(n));
    }
}
