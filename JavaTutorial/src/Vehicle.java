
public class Vehicle extends Crashable implements Drivable {
    int numOfWheels = 2;
    double theSpeed = 0;

    private int carStrength = 0;

    public void setCarStrength(int carStrength) {
        this.carStrength = carStrength;
    }

    public int getCarStrength() {
        return this.carStrength;
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

    public Vehicle(int wheels, double speed) {
        this.numOfWheels = wheels;
        this.theSpeed = speed;
    }

}
