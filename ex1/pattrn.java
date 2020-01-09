import java.util.*;

class pattrn {
    public static void rightAngledTriangle(int n) {
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void equiTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n - i; j > 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows in the triangle: ");
        int n = in.nextInt();
        System.out.println();
        rightAngledTriangle(n);
        System.out.println();
        equiTriangle(n);

        in.close();
    }
}