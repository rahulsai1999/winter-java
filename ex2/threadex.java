import java.util.*;

class Votes {
    Vector<Integer> arr = new Vector<Integer>(240);
    static int votesA = 0;
    static int votesB = 0;
    static int votesC = 0;

    Votes() {
        Random rand = new Random(23);
        for (int i = 0; i < 240; ++i) {
            int x = rand.nextInt(3) + 1;
            arr.add(x);
        }
    }

    static synchronized void inc(int x) {
        if (x == 1)
            votesA++;
        else if (x == 2)
            votesB++;
        else if (x == 3)
            votesC++;
    }
}

class CounterA extends Thread {
    Vector<Integer> v;

    CounterA(Vector<Integer> votes) {
        this.v = votes;
    }

    public void run() {
        for (int i = 0; i < v.size(); ++i)
            if (v.get(i) == 1)
                Votes.inc(1);
    }

}

class CounterB extends Thread {
    Vector<Integer> v;

    CounterB(Vector<Integer> votes) {
        this.v = votes;
    }

    public void run() {
        for (int i = 0; i < v.size(); ++i)
            if (v.get(i) == 2)
                Votes.inc(2);
    }

}

class CounterC extends Thread {
    Vector<Integer> v;

    CounterC(Vector<Integer> votes) {
        this.v = votes;
    }

    public void run() {
        for (int i = 0; i < v.size(); ++i)
            if (v.get(i) == 3)
                Votes.inc(3);
    }

}

class threadex {
    public static void main(String args[]) {
        Votes v = new Votes();
        CounterA a = new CounterA(v.arr);
        CounterB b = new CounterB(v.arr);
        CounterC c = new CounterC(v.arr);

        a.start();
        b.start();
        c.start();

        System.out.print("Election Results");
        System.out.printf("\nStudent A: %d", Votes.votesA);
        System.out.printf("\nStudent B: %d", Votes.votesB);
        System.out.printf("\nStudent C: %d\n", Votes.votesC);

        int winner = Votes.votesA > Votes.votesB ? Votes.votesA : Votes.votesB;
        winner = winner > Votes.votesC ? winner : Votes.votesC;

        if (winner == Votes.votesA)
            System.out.println("A wins the election");
        if (winner == Votes.votesB)
            System.out.println("B wins the election");
        if (winner == Votes.votesC)
            System.out.println("C wins the election");

    }
}