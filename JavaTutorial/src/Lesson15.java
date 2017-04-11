// Used in this lesson: Drivable, Crashable, Vehicle

public class Lesson15 {
    public static void main(String[] args) {
        Vehicle car = new Vehicle(4, 100.00);

        System.out.println("Car Number of Wheels " + car.getWheels());
        System.out.println("Car Max Speed " + car.getSpeed());

        System.out.println("Car strength is " + car.getCarStrength());
        car.setCarStrength(10);
        System.out.println("Car strength is " + car.getCarStrength());
    }
}
