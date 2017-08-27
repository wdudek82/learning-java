public class HealthyHamburger extends Hamburger {

    private String healthyEtra1Name;
    private double healthyEtra1Price;

    private String healthyEtra2Name;
    private double healthyEtra2Price;

    public HealthyHamburger(String meat, double price) {
        super("Healthy", meat, price,"Brown rye");
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyEtra1Name = name;
        this.healthyEtra1Price = price;
    }

    public void addHealthyAddition2(String name, double price) {
        this.healthyEtra2Name = name;
        this.healthyEtra2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice = super.itemizeHamburger();

        if (healthyEtra1Name != null) {
            hamburgerPrice += this.healthyEtra1Price;
            System.out.println("Added " + this.healthyEtra1Name + " for an extra " + this.healthyEtra1Price);
        }
        if (healthyEtra2Name != null) {
            hamburgerPrice += this.healthyEtra2Price;
            System.out.println("Added " + this.healthyEtra2Name + " for an extra " + this.healthyEtra2Price);
        }

        return hamburgerPrice;
    }

}
