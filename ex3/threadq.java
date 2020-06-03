import java.util.*;
import java.io.*;

class CipherNext extends Thread {
    StringBuffer original;
    StringBuffer encrypted = new StringBuffer("");

    CipherNext(String s) {
        this.original = new StringBuffer(s);
    }

    public void run() {
        for (int i = 0; i < original.length(); ++i) {
            char x = original.charAt(i);
            if (x >= 'a' && x <= 'z') {
                x = (char) (x + 1);
            }
            if (x >= 'z') {
                x = 'a';
            }
            this.encrypted.append(x);
        }
        System.out.println("Encrypted (Next Char): " + encrypted);
        try {
            FileWriter mw = new FileWriter("crypto.txt", true);
            mw.write(encrypted.toString());
            mw.write("\n");
            mw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

class CipherPrev extends Thread {
    StringBuffer original;
    StringBuffer encrypted = new StringBuffer("");

    CipherPrev(String s) {
        this.original = new StringBuffer(s);
    }

    public void run() {
        for (int i = 0; i < original.length(); ++i) {
            char x = original.charAt(i);
            if (x >= 'a' && x <= 'z') {
                x = (char) (x - 1);
            }
            if (x <= 'a') {
                x = 'z';
            }
            this.encrypted.append(x);
        }
        System.out.println("Encrypted (Prev Char): " + encrypted);
        try {
            FileWriter mw = new FileWriter("crypto.txt", true);
            mw.write(encrypted.toString());
            mw.write("\n");
            mw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

class threadq {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the String to be encrypted (lowercase):  ");
        String sample = in.nextLine();

        CipherNext a = new CipherNext(sample);
        CipherPrev b = new CipherPrev(sample);

        a.start();
        b.start();
        in.close();
    }
}