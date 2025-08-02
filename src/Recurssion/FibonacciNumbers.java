package Recurssion;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibonacci(n)); // return 5 in our example (0, 1, 1, 2, 3, 5)
    }

    // returns the nth fibonacci number
    static int fibonacci(int n) {
        if(n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
