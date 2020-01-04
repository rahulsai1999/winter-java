import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class genom {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Genome: ");
        String genome = in.nextLine();
        Pattern pattern = Pattern.compile("ATG([ATGC]+?)(TAG|TAA|TGA)");

        Matcher m = pattern.matcher(genome);

        while (m.find()) {
            System.out.println("From " + m.start(1) + " to " + m.end(1) + " Gene: " + m.group(1));
        }

        in.close();
    }
}