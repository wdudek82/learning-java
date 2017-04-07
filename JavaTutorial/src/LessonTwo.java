import java.util.Scanner;
import static java.lang.System.out;
import java.util.concurrent.TimeUnit;


public class LessonTwo {

//    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        // .hasNextDouble()
        // .hasNextFloat() Boolean Byte Long Short

        int numberEntered = 0;

        do {

            System.out.print("Your favorite number: ");

            Scanner userInput = new Scanner(System.in);

            boolean inputIsNumber = userInput.hasNextInt();

            if (inputIsNumber) {

                numberEntered = userInput.nextInt();

                System.out.println("You entered " + numberEntered);

                int numberEnteredTimes2 = numberEntered * 2;
                int numberEnteredTimesSelf = numberEntered;
                numberEnteredTimesSelf *= numberEntered;

                System.out.println("Number entered times 2: " + numberEnteredTimes2);
                System.out.printf("Number %1$d times %1$d is %2$d\n\n", numberEntered, numberEnteredTimesSelf);

                break;

            } else {

                System.out.println("Not a number");

            }

        } while (true);

        // Testing Math module
        int numAbs = Math.abs(numberEntered);
        int whichIsBigger = Math.max(5, 7);

        System.out.println("ABS: " + numAbs);
        System.out.println("SQRT (double): " + Math.sqrt(numAbs));
        System.out.println("SQRT (int): " + (int) Math.sqrt(numAbs));
        out.println("Which is bigger (5, 7) : " + whichIsBigger);
        out.println("Ceiling of 5.23: " + Math.ceil(5.23));
        out.println("Floor of 5.23: " + Math.floor(5.23));
        out.println("Round 5.23: " + (double) Math.round(5.23));

        // random number
        for (int i = 0; i < 15; i++) {
            int randomNumber = (int) (Math.random() * 10) + 1;
            System.out.println("Random number 1-10: " + randomNumber);

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

    }

}
