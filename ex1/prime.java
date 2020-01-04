class prime {
    public static void main(String args[]) {
        int n = 100;
        System.out.println("Printing primes from 1 to 100:");
        for (int i = 2; i <= n; ++i) {
            int flag = 1;
            for (int j = 2; j < i / 2; ++j) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                System.out.print(i + " ");
        }
    }
}