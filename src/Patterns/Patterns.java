package Patterns;

public class Patterns {
    public static void main(String[] args) {
        pattern1(5);
        System.out.println();
        pattern2(4);
        System.out.println();
        pattern3(4);
        System.out.println();
        pattern4(5);
        System.out.println();
        pattern5(4);
        System.out.println();
        pattern6(4);
        System.out.println();
        pattern7(5);
        System.out.println();
        pattern8(4);
        System.out.println();
        pattern9(4);
    }

    static void pattern1(int n) {
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for(int row = 1; row <= n; row++) {
            // for every row run the col
            for(int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // when one row is printed we need to add a new line
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for(int row = 1; row <= n; row++) {
            // if we go from 0 to n then we can use col < n - r
            for(int col = 1; col <= (n + 1 - row); col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for(int row = 1; row <= n; row++) {
            for(int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n) {
        for(int row = 0; row < (2 * n); row++) {
            int totalColsInRow = row > n ? (2 * n) - row: row;
            for(int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n) {
        for(int row = 0; row < (2 * n); row++) {

            int totalColsInRow = row > n ? (2 * n) - row: row;
            int noOfSpaces = n - totalColsInRow;

            for(int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }

            for(int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern7(int n) {
        for (int row = 1; row <= n; row++) {

            for (int space = 0; space < n - row; space++) {
                System.out.print("  ");
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }

    static void pattern8(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {

            int c = row > n ? 2 * n - row : row;

            for (int space = 0; space < n - c; space++) {
                System.out.print("  ");
            }

            for (int col = c; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= c; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }

    static void pattern9(int n) {
        int originalN = n;
        n = 2 * n;
        for(int row = 0; row <= n; row++) {
            for(int col = 0; col <= n; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}
