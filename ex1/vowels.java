import java.util.*;

class vowels {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the input string: ");
        String inputVo = in.nextLine();
        int vowels = 0;

        for (int i = 0; i < inputVo.length(); ++i) {
            switch (inputVo.charAt(i)) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                vowels++;
            }
        }

        System.out.println("The number of vowels are: " + vowels);

        in.close();
    }
}