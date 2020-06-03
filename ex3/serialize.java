import java.io.*;
import java.util.*;

class Measurement implements Serializable {
  private static final long serialVersionUID = 1L;
  String id;
  float length, weight, diameter;

  Measurement(String id, float l, float w, float d) {
    this.id = id;
    this.length = l;
    this.weight = w;
    this.diameter = d;
  }

  @Override
  public String toString() {
    return String.format("%s\t%f\t%f\t%f", id, length, weight, diameter);
  }
}

public class serialize {
  public static boolean QAPass(Measurement x) {
    if (x.diameter > 3 && x.length > 10 && x.weight > 100) {
      return true;
    } else
      return false;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    try {
      System.out.println("Quality Assurance System");
      System.out.println("1. Enter New Measurement to serialize");
      System.out.println("2. Check QA from deserialized objects");
      System.out.print("\nChoice: ");

      int choice = Integer.parseInt(in.nextLine());
      if (choice == 1) {
        FileOutputStream fo = new FileOutputStream(new File("objects.txt"));
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        System.out.print("\nEnter the number of Measurements: ");
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; ++i) {
          System.out.print("\nEnter the ID: ");
          String id = in.nextLine();
          System.out.print("\nEnter the length: ");
          float l = Float.parseFloat(in.nextLine());
          System.out.print("\nEnter the weight: ");
          float w = Float.parseFloat(in.nextLine());
          System.out.print("\nEnter the diameter: ");
          float d = Float.parseFloat(in.nextLine());

          Measurement x = new Measurement(id, l, w, d);
          oo.writeObject(x);
        }
        oo.close();
        fo.close();
      } else {
        FileInputStream fi = new FileInputStream(new File("objects.txt"));
        ObjectInputStream oi = new ObjectInputStream(fi);
        boolean cont = true;

        System.out.println("\nMeasurements:");
        while (cont) {
          Measurement x = (Measurement) oi.readObject();

          if (x != null && QAPass(x)) {
            System.out.println(x.toString() + " Passed");
          } else if (x != null) {
            System.out.println(x.toString() + " Defective");
          } else {
            cont = false;
          }
        }
        oi.close();
        fi.close();
      }

      in.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}