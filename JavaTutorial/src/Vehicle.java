
public class Vehicle extends Crashable implements Drivable, Cloneable {

    String name = "A vehicle";
    int numOfWheels = 2;
    double theSpeed = 0;

    private int carStrength = 0;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarStrength() {
        return this.carStrength;
    }

    public void setCarStrength(int carStrength) {
        this.carStrength = carStrength;
    }

    public int getWheels() {
        return this.numOfWheels;
    }

    public void setWheels(int numWheels) {
        this.numOfWheels = numWheels;
    }

    public double getSpeed() {
        return this.theSpeed;
    }

    public void setSpeed(double speed) {
        this.theSpeed = speed;
    }

    public String toString() {
        return this.name;
    }

    public Object clone() {
        Vehicle car;

        try {
            car = (Vehicle) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }

        return car;
    }

    public Vehicle(int wheels, double speed) {
        this.numOfWheels = wheels;
        this.theSpeed = speed;
    }

}
