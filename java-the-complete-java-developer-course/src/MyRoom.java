public class MyRoom {

    public static void main(String[] args) {

        CeilingLamp ceilingLamp = new CeilingLamp(1, "white", false);
        Window window = new Window(2, false);
        Room myRoom = new Room(ceilingLamp, window);

        System.out.println(ceilingLamp.getColor());
        ceilingLamp.useTheSwitch();
        ceilingLamp.useTheSwitch();
        ceilingLamp.useTheSwitch();
        ceilingLamp.useTheSwitch();
        ceilingLamp.turnOff();
        ceilingLamp.turnOn();

        System.out.println(window.getIsOpen());
    }

}
