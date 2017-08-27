public class Truck extends Car {

    public Truck() {
        super("Truck", "black", 6);
    }

    @Override
    public String startEngine() {
        return "Starts engine of a Truck";
    }

    @Override
    public String accelerate() {
        return "Truck slowly accelerates 1mph";
    }

    @Override
    public String brake() {
        return "Truck loudly brakes, it slides couple more meters!";
    }

}
