import java.util.Scanner;

public class Conditionals {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int answer;

        System.out.println("Type a number: ");
        answer = in.nextInt();

        if (answer > 8) {
            System.out.println("Try lower");
        } else if (answer < 8) {
            System.out.println("Try upper");
        } else System.out.println("Bull's Eye!");

        int test_case = 3;
        switch (test_case) {
        case 1:
            System.out.println("One");
            break;
        case 2:
            System.out.println("Two");
            break;
        case 3:
            System.out.println("Three");
            break;
        default:
            System.out.println("Default.");

        }

        int a = 10;
        // Rest of divission
        System.out.println(a % 4);

        // Ternary operator
        System.out.println(a > 15 ? "T" : "F");
    }
}
