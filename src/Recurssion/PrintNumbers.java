package Recurssion;

public class PrintNumbers {
    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
    }

    static void printNumbers(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        printNumbers(n - 1);
        System.out.println(n);
    }
}
