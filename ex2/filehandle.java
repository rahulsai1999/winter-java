import java.util.*;
import java.io.*;

class Donor implements Serializable {
    private static final long serialVersionUID = 1L;
    String name, address, contact, blood, lastDonation;
    int age;

    Donor(String n, String a, String c, String b, int age, String date) {
        this.name = n;
        this.address = a;
        this.contact = c;
        this.blood = b;
        this.age = age;
        this.lastDonation = date;
    }

    public String retLD() {
        return this.lastDonation;
    }

    public String retBG() {
        return this.blood;
    }

    @Override
    public String toString() {
        String n = "Name: " + this.name;
        String a = " Address: " + this.address;
        String c = " Contact: " + this.contact;
        String b = " Blood Type: " + this.blood;
        String age = " Age: " + this.age;
        String dat = " Date: " + this.lastDonation;
        return n + a + c + b + age + dat;
    }
}

class filehandle {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Donor Management System");
            System.out.println("1. Enter New Donor");
            System.out.println("2. Read from file");
            System.out.print("\nChoice: ");

            int choice = Integer.parseInt(in.nextLine());
            if (choice == 1) {
                FileOutputStream fo = new FileOutputStream(new File("objects.txt"));
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                System.out.print("\nEnter the number of Donors: ");
                int n = Integer.parseInt(in.nextLine());
                for (int i = 0; i < n; ++i) {
                    System.out.print("\nEnter the name: ");
                    String name = in.nextLine();
                    System.out.print("\nEnter the age: ");
                    int age = Integer.parseInt(in.nextLine());
                    System.out.print("\nEnter the contact: ");
                    String contact = in.nextLine();
                    System.out.print("\nEnter the blood type: ");
                    String blood = in.nextLine();
                    System.out.print("\nEnter the address: ");
                    String address = in.nextLine();
                    System.out.print("\nEnter the last Donation date: ");
                    String donation = in.nextLine();

                    Donor x = new Donor(name, address, contact, blood, age, donation);
                    oo.writeObject(x);
                }
                oo.close();
                fo.close();
            } else {
                System.out.print("\nEnter the blood group: ");
                String bloodType = in.nextLine();

                FileInputStream fi = new FileInputStream(new File("objects.txt"));
                ObjectInputStream oi = new ObjectInputStream(fi);
                boolean cont = true;

                System.out.println("\nDonors:");
                while (cont) {
                    Donor x = (Donor) oi.readObject();

                    if (x != null && x.blood.equals(bloodType)) {
                        System.out.println(x.toString());
                    } else {
                        cont = false;
                    }
                }

                oi.close();
                fi.close();
            }

            in.close();

        } catch (Exception e) {
        }
    }
}