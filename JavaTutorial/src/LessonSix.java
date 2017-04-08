import java.io.*;
import java.util.*;


public class LessonSix {

//    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

//        System.out.print("How old are you? ");
//        int age = checkValidAge();
//
//        if (age != 0) {
//            System.out.println("You are " + age + " years old");
//        }

//        divideByZero(2);

        String path = "./somestuff.txt";

        getAFile(path);

        try {
            getAFile2(path);
        } catch (IOException e) {
            System.out.println("An IO Error: " + e);
        }

    }

    public static void divideByZero(int numOne) {

        try {
            System.out.println("Result: " + 2/0);
        } catch (ArithmeticException e) {
            System.out.println("You can't do that: " + e);
            System.out.println("Error msg: " + e.getMessage());
            System.out.println("Exception name: " + e.toString());
            System.out.print("Stack Trace: ");
            e.printStackTrace();

//            System.out.println("Done!");
        }

    }

//    public static int checkValidAge() {
//
//        try {
//            return userInput.nextInt();
//        } catch (InputMismatchException e) {
//            userInput.next();
//            System.out.println("That isn't a whole number");
//            return 0;
//        }
//
//    }

    public static void getAFile(String fileName) {

        try {
            FileInputStream file = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOError | IOException e) {}  // ignored exceptions
        catch (Exception e) {
            System.out.println("Catched everything else...: " + e);
        } finally {
            System.out.println("Cleanup...");
            System.out.println("Done!");
        }

    }

    public static void getAFile2(String fileName) throws IOException, FileNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
    }

}