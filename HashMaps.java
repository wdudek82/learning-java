import java.util.*;

public class HashMaps {

    public static void main(String[] args) {

        HashMap<String, Integer> someAnimals = new HashMap<String, Integer>();

        someAnimals.put("Huskie", 5);
        someAnimals.put("Manju", 4);
        someAnimals.put("Red", 10);

        // This returns null
        System.out.println(someAnimals.get(0));

        System.out.println("Size of someAnimals HashMap: " + someAnimals.size());

        for (String animal: someAnimals.keySet()) {
            System.out.println(animal + " " + someAnimals.get(animal));
            if (someAnimals.get(animal) > 6) {
                System.out.println("You have " + someAnimals.get(animal) +
                     " years already " + animal + "! Wow!");
            }

        }

        System.out.println(someAnimals.keySet());
        System.out.println(someAnimals);


    }
}
