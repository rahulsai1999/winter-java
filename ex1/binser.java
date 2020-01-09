import java.util.*;

class binser {
    public static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    public static int linearSearch(int arr[], int x) {
        int ans = -1;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == x) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in array: ");
        int n = in.nextInt();
        System.out.print("\nEnter the elements of the array: ");

        int a[] = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        System.out.print("\nEnter the number to be searched: ");
        int x = in.nextInt();
        int f1 = binarySearch(a, 0, a.length - 1, x);
        int f2 = linearSearch(a, x);

        System.out.println("The element found at index " + f1 + " by Binary Search");
        System.out.println("The element found at index " + f2 + " by Linear Search");

        in.close();

    }
}