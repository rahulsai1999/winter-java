import java.sql.*;
import java.util.*;

class Student {
  String name, regno, hosteller;
  int age;
  float cgpa;

  public Student(String name, String regno, int age, float cgpa, String hosteller) {
    this.name = name;
    this.regno = regno;
    this.age = age;
    this.cgpa = cgpa;
    this.hosteller = hosteller;
  }
}

public class studentdb {
  static String driver = "com.mysql.cj.jdbc.Driver";
  static String dburl = "jdbc:mysql://localhost:9906/ri";
  static String user = "test";
  static String pass = "test123";

  static ArrayList<Student> students = new ArrayList<Student>();

  public static void inputDB() {
    Connection conn = null;
    Scanner in = new Scanner(System.in);
    System.out.print("Enter the number of students to be entered: ");
    int n = Integer.parseInt(in.nextLine());
    System.out.println();

    for (int i = 0; i < n; ++i) {
      System.out.print("Enter Name: ");
      String name = in.nextLine();
      System.out.println();
      System.out.print("Enter Reg No: ");
      String regno = in.nextLine();
      System.out.println();
      System.out.print("Enter Age: ");
      int age = Integer.parseInt(in.nextLine());
      System.out.println();
      System.out.print("Enter CGPA: ");
      float cgpa = Float.parseFloat(in.nextLine());
      System.out.println();
      System.out.print("Enter Hosteller(Y/N): ");
      String hosteller = in.nextLine();
      System.out.println();
      Student x = new Student(name, regno, age, cgpa, hosteller);
      students.add(x);
    }
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(dburl, user, pass);
      // insertion or updation
      for (Student student : students) {
        PreparedStatement stmta = conn.prepareStatement("INSERT INTO Students VALUES(?,?,?,?,?)");
        stmta.setString(1, student.name);
        stmta.setString(2, student.regno);
        stmta.setInt(3, student.age);
        stmta.setFloat(4, student.cgpa);
        stmta.setString(5, student.hosteller);
        stmta.executeUpdate();
      }
      students.clear();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void select2018() {
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(dburl, user, pass);
      PreparedStatement stmta = conn.prepareStatement("SELECT * FROM Students WHERE Reg LIKE '18%'");
      ResultSet rs = stmta.executeQuery();
      System.out.println("Name\t\tRegNo\t\tAge\tCGPA\tHosteller");
      while (rs.next()) {
        System.out.format("%s\t\t%s\t%s\t%s\t%s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void age1820() {
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(dburl, user, pass);
      PreparedStatement stmta = conn.prepareStatement("SELECT * FROM Students WHERE Age BETWEEN 18 AND 20");
      ResultSet rs = stmta.executeQuery();
      System.out.println("Name\t\tRegNo\t\tAge\tCGPA\tHosteller");
      while (rs.next()) {
        System.out.format("%s\t\t%s\t%s\t%s\t%s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void cgpa5() {
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(dburl, user, pass);
      PreparedStatement stmta = conn.prepareStatement("SELECT * FROM Students WHERE CGPA < 5");
      ResultSet rs = stmta.executeQuery();
      System.out.println("Name\t\tRegNo\t\tAge\tCGPA\tHosteller");
      while (rs.next()) {
        System.out.format("%s\t\t%s\t%s\t%s\t%s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void hosteller() {
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(dburl, user, pass);
      PreparedStatement stmta = conn.prepareStatement("SELECT * FROM Students WHERE Hosteller = 'Y'");
      ResultSet rs = stmta.executeQuery();
      System.out.println("Name\t\tRegNo\t\tAge\tCGPA\tHosteller");
      while (rs.next()) {
        System.out.format("%s\t\t%s\t%s\t%s\t%s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void daysc19() {
    Connection conn = null;
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(dburl, user, pass);
      PreparedStatement stmta = conn
          .prepareStatement("SELECT * FROM Students WHERE Hosteller = 'N' AND Reg LIKE '19%'");
      ResultSet rs = stmta.executeQuery();
      System.out.println("Name\t\tRegNo\t\tAge\tCGPA\tHosteller");
      while (rs.next()) {
        System.out.format("%s\t\t%s\t%s\t%s\t%s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
            rs.getString(5));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.print('\n');
      System.out.println("Student Management");
      System.out.println("1. Insert n students");
      System.out.println("2. Select => Joined in 2018");
      System.out.println("3. Select => Age 18-20 ");
      System.out.println("4. Select => CGPA < 5");
      System.out.println("5. Select => Hostellers");
      System.out.println("6. Select => 2019 dayscholars");
      System.out.println();
      System.out.print("\nEnter choice: ");
      int choice = Integer.parseInt(in.nextLine());
      switch (choice) {
        case 1:
          inputDB();
          break;
        case 2:
          select2018();
          break;
        case 3:
          age1820();
          break;
        case 4:
          cgpa5();
          break;
        case 5:
          hosteller();
          break;
        case 6:
          daysc19();
          break;
        default:
          in.close();
          return;
      }
    }
  }
}
