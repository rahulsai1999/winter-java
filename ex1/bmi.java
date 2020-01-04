import java.util.*;

class bmi {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = in.nextLine();
        System.out.print("\nEnter your last name: ");
        String lastName = in.nextLine();
        System.out.print("\nEnter your height(in cm): ");
        float height = Float.parseFloat(in.nextLine());
        System.out.print("\nEnter your weight(in kg): ");
        float weight = Float.parseFloat(in.nextLine());
        float heightInM = height / 100;
        double bmi = weight / (Math.pow(heightInM, 2));
        System.out.printf("\nHello %s %s. Your BMI is %f", firstName, lastName, bmi);
        if (bmi < 18.5)
            System.out.println("\nYou are underweight ");
        else if (bmi >= 18.5 && bmi < 25)
            System.out.println("\nYou are of normal weight");
        else if (bmi >= 25 && bmi < 30)
            System.out.println("\nYou are overweight");
        else
            System.out.println("\nYou are obese");

        in.close();
    }
}