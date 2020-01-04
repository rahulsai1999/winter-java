import java.util.*;

class chemeqn {

    public static String chemString(String Arr[], String Init) {
        for (int i = 0; i < Arr.length; ++i) {
            String string = Arr[i];
            String xx[] = string.split("\\D");
            int firstC = (int) string.charAt(0);
            if (firstC > 48 && firstC < 57)
                Init = Init + xx[0] + " moles of " + string.substring(1);
            else
                Init = Init + "1 mole of " + string;

            if (i < Arr.length - 1)
                Init += " and ";
        }
        return Init;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the chemical equation: ");
        String eqn = in.nextLine();
        String arr[] = eqn.split("->");

        String lhs = arr[0];
        String rhs = arr[1];

        String leftInit = "Reactants are ";
        String rightInit = "Products are ";
        String leftArr[] = lhs.split("\\+");
        String rightArr[] = rhs.split("\\+");

        leftInit = chemString(leftArr, leftInit);
        rightInit = chemString(rightArr, rightInit);

        System.out.println(leftInit);
        System.out.println(rightInit);
        in.close();
    }
}