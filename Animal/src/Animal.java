import java.util.Scanner;
import java.util.*;

public class Animal {

    public static final double FAVNUMBER = 1.6180;

    private String name;
    private int weight;
    private boolean hasOwner = false;
    private byte age;
    private long uniqueID;
    private char favoriteChar;
    private double speed;
    private float height;

    protected static int numberOfAnimals = 0;

    static Scanner userInput = new Scanner(System.in);

    public Animal() {
        numberOfAnimals++;

        int sumOfNumbers = 5 + 1;
        System.out.println("5 + 1 = " + sumOfNumbers);

        System.out.print("Enter the name: \n");

        // hasNextInt, hasNextFloat, hasNextDouble, hasNextByte
        // nextInt, nextFloat, nextDouble, nextByte

        if(userInput.hasNextLine()){

            this.setName(userInput.nextLine());

        }

        this.setFavoriteChar();
        this.setUniqueID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
        System.out.println("unique ID set to: " + this.uniqueID);
    }

    public void setUniqueID() {
        long minNumber = 1;
        long maxNumber = 1000000;

        this.uniqueID = minNumber + (long) (Math.random() * ((maxNumber - minNumber) + 1));
        String stringNumber = Long.toString(maxNumber);

        int numberString = Integer.parseInt(stringNumber);
        System.out.println("Unique ID set to: " + this.uniqueID);
    }

    public char getFavoriteChar() {
        return favoriteChar;
    }

    public void setFavoriteChar(char favoriteChar) {
        this.favoriteChar = favoriteChar;
    }

    public void setFavoriteChar() {
        int randomNumber = (int) (Math.random() * 126) + 1;

        // convert randomNumber into character
        this.favoriteChar = (char) randomNumber;

        if (randomNumber == 32) {

            System.out.println("Favorite character set to Space");

        } else if (randomNumber == 10) {

            System.out.println("Favorite character set to Newline");

        } else {

            System.out.println("Favorite character set to " + this.favoriteChar);

        }

        if((randomNumber > 97) && (randomNumber < 122)){

            System.out.println("Favorite character is a lowercase letter");

        }

        if(((randomNumber > 97) && (randomNumber < 122)) || ((randomNumber > 64) && (randomNumber < 122))){

            System.out.println("Favorite character is a letter");

        }

        int whichIsBigger = (50 > randomNumber) ? 50 : randomNumber;

        switch(randomNumber){
            case 8:
                System.out.println("Favorite character set to backspace");
                break;

            case 10:
            case 11:
            case 12:
                System.out.println("Favorite character set to ???");
                break;

            default:
                System.out.println("Default");
        }

    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height){
        this.height = height;
    }

    protected static void countTo(int startingNumber){

        for(int i = startingNumber; i <= 100; i++){

            if(i % 2 == 0) continue;

            System.out.println("Value of I: " + i);

        }

    }

    protected static String printNumbers(int maxNumbers){

        int count = 1;
        while(count < (maxNumbers / 2)){
            System.out.print("While loop: " + count + "\n");
            count++;

            if(count > 30) break;
        }

        Animal.countTo(count);

        return "End";

    }

    protected static void guessMyNumber(){

        int number;

        do {

            System.out.println("Guess Number up to 100");

            while(!userInput.hasNextInt()){

                String numberEntered = userInput.next();
                System.out.printf("%s is not a number\n", numberEntered);

            }

            number = userInput.nextInt();

        } while(number != 50);

        System.out.println("Yay! You get the number!");

    }

    public static void main(String[] args) {

        Animal theAnimal = new Animal();

        System.out.println("It worked!:D");
        System.out.println("Hello, World!:)");
        System.out.println((int) (Math.random() * 24));

        for (int i = 0; i < 10; i++) {
            System.out.println("Random Number: " + (int) (Math.random() * 24));
        }

        String str = printNumbers(1000);
        System.out.println(str);

    }

}