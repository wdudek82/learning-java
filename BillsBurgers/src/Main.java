public class Main {

    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");

        double price = hamburger.itemizeHamburger();

        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.12);
        hamburger.addHamburgerAddition4("Onion", 0.27);

        price = hamburger.itemizeHamburger();

        System.out.printf("Total Burger Price: %.2f\n\n", price);

        HealthyHamburger healthyHamburger = new HealthyHamburger("Bacon", 5.67);
        healthyHamburger.itemizeHamburger();

        healthyHamburger.addHealthyAddition1("Egg", 5.43);
        healthyHamburger.addHealthyAddition2("Lentils", 3.41);
        System.out.printf("Total Heathy Burger Price: %.2f\n\n", healthyHamburger.itemizeHamburger());

        DeluxeHamburger deluxeHamburger = new DeluxeHamburger();
        price = deluxeHamburger.itemizeHamburger();
        deluxeHamburger.addHamburgerAddition1("Shouldn't do that", 45.34);
        deluxeHamburger.addHamburgerAddition2("Shouldn't do that", 45.34);
        deluxeHamburger.addHamburgerAddition3("Shouldn't do that", 45.34);
        deluxeHamburger.addHamburgerAddition4("Shouldn't do that", 45.34);
        System.out.printf("Total Deluxe Hamburger Price: %.2f\n\n", price);

    }

}
