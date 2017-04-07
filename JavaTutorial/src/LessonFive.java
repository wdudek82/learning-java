import java.util.Scanner;

public class LessonFive {

    static double myPI = 3.14159;  // Class variable
    static int randomNumber;
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        int result = addThem(2, 5);
        System.out.println("Result: " + result);
        System.out.println("Global myPI: " + myPI);

        int d = 5;
        tryToChange(d);
        System.out.println("Outside d: " + d);

        System.out.println("Got random number: " + getRandomNum());

        int guessResult = 1;
        int randomGuess = 0;

        while (guessResult != -1) {
            System.out.print("Guess a number between 0 and 50: ");

            randomGuess = userInput.nextInt();
            guessResult = checkGuess(randomGuess);

            if (randomGuess > randomNumber) {
                System.out.println("The random number is smaller");
            } else if (randomGuess < randomNumber) {
                System.out.println("The random number is bigger");
            }

        }

        System.out.println("Yes the random number is " + randomGuess);

    }

    public static int addThem(int a, int b) {

        int c = a + b;
        double smallPI = 3.140;  // Local variable
        double myPI = 3.0;

        System.out.println("Local " + myPI);

        return c;

    }

    public static void tryToChange(int d) {

        d += 10;
        System.out.println("Inside d: " + d);

    }

    public static int getRandomNum() {
        randomNumber = (int) (Math.random() * 51);
        return randomNumber;
    }

    public static int checkGuess(int guess) {

        if (guess == randomNumber) {
            return -1;
        } else {
            return guess;
        }

    }

}
