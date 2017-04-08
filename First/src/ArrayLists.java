import java.util.*;

public class Arrays {

    public static void main(String[] args) {

        // Some Animals
        ArrayList<String> someAnimals = new ArrayList<String>();
        someAnimals.add("a Dog");
        someAnimals.add("a Cat");
        someAnimals.add("a Wombat");
        someAnimals.add("a Bear");

        System.out.println(someAnimals.size() + " animal(s) in list, i.e.:");
        // Enumeration of animals:
        for (String animal: someAnimals) {
            System.out.println(someAnimals.indexOf(animal)+1 + ". " + animal);
        }

        System.out.println("All animals: " + someAnimals);
        System.out.println("First animal: " + someAnimals.get(0));

        // Loop for making an array slice
        ArrayList<String> someAnimalsSlice = new ArrayList<String>();
        // Instead of writing 'Integer' I can use 'int'
        for (Integer i = 1; i < 3; i++) {
            someAnimalsSlice.add(someAnimals.get(i));
        }

        System.out.println("Second and third animal (array slice): " +
                            someAnimalsSlice);

        // Reversing array
        ArrayList<String> someAnimalsReversed = new ArrayList<String>();
        for (Integer i = 3; i > -1; i--) {
            someAnimalsReversed.add(someAnimals.get(i));
        }
        System.out.println("Reversed array: " + someAnimalsReversed);


    }

}
