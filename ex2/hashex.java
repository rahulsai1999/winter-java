import java.util.*;

class hashex {
    static Scanner in = new Scanner(System.in);
    static HashMap<String, ArrayList<String>> h1 = new HashMap<String, ArrayList<String>>();
    static HashMap<String, Integer> h2 = new HashMap<String, Integer>();

    static void addStudent() {
        System.out.print("\nEnter student name: ");
        String name = in.nextLine();
        System.out.print("\nEnter number of subjects: ");
        int n = Integer.parseInt(in.nextLine());

        ArrayList<String> sub = new ArrayList<String>();
        System.out.print("\nEnter the subjects: ");
        for (int i = 0; i < n; ++i) {
            String subj = in.nextLine();
            sub.add(subj);
        }

        h1.put(name, sub);
    }

    static void removeStudent() {
        System.out.print("\nEnter student name: ");
        String name = in.nextLine();
        h1.remove(name);
    }

    static void viewAll(int who) {
        if (who == 1) {
            for (String i : h1.keySet()) {
                System.out.printf("%s : %s\n", i, h1.get(i).toString());
            }
        } else {
            for (String i : h2.keySet()) {
                System.out.printf("%s : %d\n", i, h2.get(i));
            }
        }
    }

    static void viewTeachers() {
        System.out.print("\nEnter student name: ");
        String name = in.nextLine();
        ArrayList<String> subs = h1.get(name);
        System.out.print("\nYour faculties are: ");
        for (String i : subs) {
            System.out.printf("%d ", h2.get(i));
        }
    }

    public static void main(String args[]) {
        h2.put("Python", 111);
        h2.put("Maths", 222);
        h2.put("C", 333);
        h2.put("C++", 444);
        h2.put("Physics", 555);
        h2.put("Chemistry", 666);
        h2.put("Digital Electronics", 777);

        int choice = 0;

        while (choice != 6) {
            System.out.print("\n\nMENU\nPress 1 to add student\nPress 2 to remove student");
            System.out.print("\nPress 3 to view all teachers\nPress 4 to see your teachers");
            System.out.print("\nPress 5 to see all students\nPress 6 to exit\nEnter your choice: ");
            choice = Integer.parseInt(in.nextLine());
            System.out.print("\n");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    viewAll(2);
                    break;
                case 4:
                    viewTeachers();
                    break;
                case 5:
                    viewAll(1);
                    break;
            }
        }
    }
}