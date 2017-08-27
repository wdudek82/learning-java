public class Car {

    private String name;
    private String color;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, String color, int cylinders) {
        this.name = name;
        this.color = color;
        this.engine = true;
        this.wheels = 4;
        this.cylinders = cylinders;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
        return "Starts engine of a car";
    }

    public String accelerate() {
        return "Accelerates by 2mph";
    }

    public String brake() {
        return "Car stops";
    }
}
