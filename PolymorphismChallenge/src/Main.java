public class Main {

    public static void main(String[] args) {

        for (int i = 1; i < 5; i++) {
            Car car = randomCar();

            System.out.println("\n================================");
            System.out.println("Car #" + i);
            System.out.println("Name: " + car.getName());
            System.out.println("Color: " + car.getColor());
            System.out.println("Cylinders: " + car.getCylinders());
            System.out.println("Start engine: " + car.startEngine());
            System.out.println("Accelerate: " + car.accelerate());
            System.out.println("Brake: " + car.brake());
            System.out.println("================================\n");
        }

    } // END OF main

    public static Car randomCar() {
        int randomNum = (int) (Math.random() * 3) + 1;

        System.out.printf("Random number is: " + randomNum);

        switch (randomNum) {
            case 1:
                return new Tesla();
            case 2:
                return new ToyCar();
            case 3:
                return new Truck();
            default:
                return null;
        }
    } // END OF randomCar

}
