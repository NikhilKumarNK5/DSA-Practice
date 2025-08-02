package Recurssion;

public class PrintNumbersNToOne {
    public static void main(String[] args) {
        int n = 5;
        printFunction(5);
    }

    static void printFunction(int n) {
        // put up the base condition before recurssion call otherwise it will run in infinite loop
        if(n == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(n); // prints n
        printFunction(n - 1); // calls the next value i.e n - 1
    }
}
