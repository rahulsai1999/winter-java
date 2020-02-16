import java.util.*;
import primespackage.Primes;

class twinprimes {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter start: ");
        int a = in.nextInt();
        System.out.print("Enter end: ");
        int b = in.nextInt();

        for (int i = a; i <= b; ++i) {
            for (int j = a + 1; j <= b; ++j) {

                int x = new Primes().checkForPrime(i);
                int y = new Primes().checkForPrime(j);

                if (x == 1 && y == 1 && i < j && j - i == 2) {
                    System.out.printf("(%d,%d)\n", i, j);
                }
            }
        }

        in.close();
    }
}