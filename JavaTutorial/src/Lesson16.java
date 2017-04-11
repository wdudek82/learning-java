
public class Lesson16 {
    public static void main(String[] args) {
        Object superCar = new Vehicle(3, 50.00);

        System.out.println("SuperCar: " + ((Vehicle) superCar).getCarStrength());

        Vehicle superTruck = new Vehicle(8, 100.00);

        superTruck.setName("Truck One");

        System.out.println(superCar.equals(superTruck));
        System.out.println(superCar);
        System.out.println(superCar.hashCode());
        System.out.println(superCar.getClass());
        System.out.println(superCar.getClass().getName());

        if (superCar.getClass() == superTruck.getClass()) {
            System.out.println("Same class!:)");
        }

        ((Vehicle)superCar).setName("Super Car");
        System.out.println(superCar.getClass().getSuperclass().getClass().getSuperclass());
        System.out.println(((Vehicle) superCar).getName());
        System.out.println(superCar.toString());

        int randNum = 100;
        System.out.println(Integer.toString(randNum));

        Vehicle superTruckTwo = (Vehicle) superTruck.clone();
        System.out.println(superTruckTwo.getName());

        System.out.println(superTruck.hashCode());
        System.out.println(superTruckTwo.hashCode());
    }
}
