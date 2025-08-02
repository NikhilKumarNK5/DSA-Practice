package Recurssion;

public class CountZeroesInANumber {
    public static void main(String[] args) {
        int n = 302040065;
        System.out.println(countZeroes(n));
    }

    static int countZeroes(int n) {
        return helper(n, 0);
    }

    // taking count as arguments
    // special pattern - how to pass a value to above calls
    static int helper(int n, int count) {
        if(n == 0) {
            return count;
        }
        int rem = n % 10;
        if(rem == 0) {
            return helper(n / 10, count + 1);
        }
        return helper(n / 10, count);
    }
}
