import java.util.*;

class interest {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 for SI, 2 for CI: ");
        int choice = in.nextInt();

        if (choice == 1) {
            System.out.print("Enter the principal amount: ");
            int p = in.nextInt();
            System.out.print("\nEnter the interest rate: ");
            float r = in.nextFloat();
            System.out.print("\nEnter the number of years: ");
            int t = in.nextInt();
            float interest = (p * r * t) / 100;
            System.out.print("\nThe interest is: " + interest);

        } else {
            System.out.print("\nEnter the principal amount: ");
            int p = in.nextInt();
            System.out.print("\nEnter the interest rate: ");
            float r = in.nextFloat();
            System.out.print("\nEnter the number of years: ");
            int t = in.nextInt();
            System.out.print("\nEnter the compound period: ");
            int n = in.nextInt();
            double multi = Math.pow(1 + (r / 100) / n, n * t);
            double amount = multi * p;
            double interest = amount - p;
            System.out.printf("\nThe interest is: %.2f\n", interest);
        }
        in.close();
    }
}