public class MyRoom {

    public static void main(String[] args) {

        CeilingLamp ceilingLamp = new CeilingLamp(1, "white", false);
        Window window = new Window(2, false);
        Room myRoom = new Room(ceilingLamp, window);

        System.out.println(ceilingLamp.getColor());
        myRoom.useTheSwitch();
        myRoom.useTheSwitch();
        myRoom.useTheSwitch();
        myRoom.useTheSwitch();
        myRoom.turnOffTheLamp();
        myRoom.turnOnTheLamp();

        // accessing composite's attributes by getters and setters
        System.out.print("Lamp is On: ");
        myRoom.getCeilingLamp().getIsOn();

        System.out.println(window.getIsOpen());
    }

}
