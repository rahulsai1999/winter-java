import java.util.Arrays;
import java.util.Scanner;

abstract class ThemePark {
    float adultPrice = 500;
    float childPrice = 300;

    abstract void calculateCost(int adult, int child);

    abstract void playGame();
}

class Queensland extends ThemePark {
    boolean games[] = new boolean[30];

    public Queensland() {
        Arrays.fill(games, false);
    }

    public void calculateCost(int adult, int child) {
        float total = (adultPrice * adult) + (childPrice * child);
        System.out.println("\nThe total ticket cost is: " + total);
    }

    public void playGame() {
        int choice = 1;
        int gameID;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("\nQueensland\n1.Play game\n2.Quit\n");
            choice = in.nextInt();
            if (choice == 1) {
                System.out.print("Enter the gameID: ");
                gameID = in.nextInt();
                if (games[gameID] == false) {
                    games[gameID] = true;
                    System.out.println("Queensland: Current game -> " + gameID);
                } else {
                    System.out.println("Queensland: Maximum limit for game " + gameID + " reached");
                }
            } else
                break;
        } while (choice != 2);
    }

    public void showDetails() {
        for (int i = 0; i < games.length; ++i) {
            System.out.println("GameId " + (i + 1) + ": Status -> " + games[i]);
        }
    }

}

class WonderLa extends ThemePark {
    int games[] = new int[30];

    public WonderLa() {
        Arrays.fill(games, 0);
    }

    public void calculateCost(int adult, int child) {
        float total = (adultPrice * adult) + (childPrice * child);
        System.out.println("\nThe total ticket cost is: " + total);
    }

    public void playGame() {
        int choice = 1;
        int gameID;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("\nWonderLa\n1.Play game\n2.Quit\n");
            choice = in.nextInt();
            if (choice == 1) {
                System.out.print("Enter the gameID: ");
                gameID = in.nextInt();
                games[gameID]++;
                System.out.println("WonderLa Game " + gameID + " played " + games[gameID] + " times");
            } else
                break;
        } while (choice != 2);
    }

    public void showDetails() {
        for (int i = 0; i < games.length; ++i) {
            System.out.println("GameId " + (i + 1) + ": Count -> " + games[i]);
        }
    }
}

class abstheme {
    public static void main(String args[]) {
        Queensland park1 = new Queensland();
        WonderLa park2 = new WonderLa();

        park1.calculateCost(4, 2);
        park2.calculateCost(2, 1);

        park1.playGame();
        park2.playGame();

        park1.showDetails();
        park2.showDetails();
    }
}