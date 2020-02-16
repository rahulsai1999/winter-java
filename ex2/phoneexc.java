import java.util.*;
import java.lang.*;

class IllegalArgumentException extends Exception {
    IllegalArgumentException(String s) {
        super(s);
    }
}

class NumberFormatException extends Exception {
    NumberFormatException(String s) {
        super(s);
    }
}

class NoSuchElementException extends Exception {
    NoSuchElementException(String s) {
        super(s);
    }
}

class phoneexc {
    static int flagA = 0;
    static int flagB = 0;
    static int flagC = 0;

    static void checkArg(String reg, String phone) throws IllegalArgumentException {
        if (reg.length() == 9 && phone.length() == 10) {
            System.out.println("\nRegister Number and Phone Number valid");
            flagA = 1;
        } else {
            throw new IllegalArgumentException("Either Register Number or Phone number not of valid length");
        }
    }

    static void checkNum(String phone) throws NumberFormatException {
        if (phone.matches("[0-9]{10}")) {
            System.out.println("Phone Number matches the format");
            flagB = 1;
        } else {
            throw new NumberFormatException("Number Format is invalid");
        }
    }

    static void checkReg(String reg) throws NoSuchElementException {
        if (reg.matches("[1-9]{2}[A-Z]{3}[0-9]{4}")) {
            System.out.println("Registration Number is Valid");
            flagC = 1;
        } else {
            throw new NoSuchElementException("Registration Number contains invalid characters");
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter your Registration Number: ");
        String reg = in.nextLine();
        System.out.print("\nEnter your Phone Number: ");
        String phone = in.nextLine();

        try {
            checkArg(reg, phone);
            checkNum(phone);
            checkReg(reg);

            if (flagA == 1 && flagB == 1 && flagC == 1)
                System.out.println("Final Result: Valid");
            else
                System.out.println("Final Result: Invalid");

        } catch (Exception e) {
            e.printStackTrace();
        }

        in.close();
    }
}