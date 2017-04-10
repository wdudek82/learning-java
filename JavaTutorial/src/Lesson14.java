

public class Lesson14 {
    public static void main(String[] args) {
        Cats manju = new Cats("Manju", "crisps", "rubber mouse");
        Animals arna = new Animals("Arna", "meat");

        System.out.println("Animal: " + manju.getName());
        System.out.println("Animal eat: ");
        manju.eatStuff();
        manju.favFood = "crisps";
        System.out.println("Manju's favorites: " + manju.favFood);
        manju.eatStuff();
        arna.eatStuff();
        manju.walkAround();

        manju.walkAround();

        Animals filip = new Cats("Filip", "fish", "ball");
        System.out.println(filip.getName());
        System.out.println(filip.favFood);
        filip.walkAround();
        // filip.favToy;  // can't do that - it works only for methods and fields defined both in super class and child class (polymorphism)

        // To get access to favToy field I need to cast the object 1. indirectly or 2. directly
        Cats tempCat = (Cats) filip;
        System.out.println("tempCat favToy: " + tempCat.favToy);  // 1
        System.out.println("filip's favToy: " + ((Cats) filip).favToy);  // 2

        acceptAnimal(filip);
        acceptAnimal(manju);
    }

    public static void acceptAnimal(Animals randomAnimal) {
        System.out.println();
        System.out.println(randomAnimal.getName());
        System.out.println(randomAnimal.favFood);
        System.out.println();

        randomAnimal.walkAround();

        if (randomAnimal instanceof Cats) {
            System.out.println(((Cats) randomAnimal).getName() + " is a Cat!");
        }
    }

    public static void acceptAnimal(Cats randomCat) {
        System.out.println(randomCat.favToy);
    }
}
