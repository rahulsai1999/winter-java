import java.util.*;
import java.io.*;
import java.lang.*;

class multiarray {
    public static int genTutor(int n) {
        if (n % 4 == 0)
            n /= 4;
        else
            n = n / 4 + 1;
        return n;
    }

    public static void printArr(int a[]) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of batches: ");
        int n[] = new int[Integer.parseInt(in.nextLine())];

        int tutors[][] = new int[n.length][];

        for (int i = 0; i < n.length; ++i) {
            System.out.print("\nEnter the number of slow learners in batch " + (i + 1) + ": ");
            tutors[i] = new int[genTutor(Integer.parseInt(in.nextLine()))];
        }

        for (int i = 0; i < n.length; ++i) {
            int j;
            int q = n[i] / 4;
            int r = n[i] % 4;
            for (j = 0; i < q; ++j) {
                tutors[i][j] = 4;
            }
            tutors[i][j] = r;
        }

        System.out.print("\n The batches scheduled are: ");
        for (int i = 0; i < n.length; ++i)
            printArr(tutors[i]);

        in.close();
    }
}