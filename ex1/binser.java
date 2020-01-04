import java.util.*;

class binser {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in array:");
        int n = in.nextInt();
        System.out.print("\nEnter the elements of the array: ");

        int a[] = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        in.close();

    }
}